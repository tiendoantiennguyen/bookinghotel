package com.nhapmoncongnghephanmem.controller.web;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nhapmoncongnghephanmem.converter.CodeConverter;
import com.nhapmoncongnghephanmem.converter.RoomConverter;
import com.nhapmoncongnghephanmem.dto.CodeDTO;
import com.nhapmoncongnghephanmem.dto.RoomDTO;
import com.nhapmoncongnghephanmem.entity.Bill;
import com.nhapmoncongnghephanmem.entity.BillDetails;
import com.nhapmoncongnghephanmem.entity.Code;
import com.nhapmoncongnghephanmem.entity.CodeDetails;
import com.nhapmoncongnghephanmem.entity.User;
import com.nhapmoncongnghephanmem.repository.BillDetailsRepository;
import com.nhapmoncongnghephanmem.repository.BillRepository;
import com.nhapmoncongnghephanmem.repository.CodeDetailsRepository;
import com.nhapmoncongnghephanmem.repository.ICodeRepository;
import com.nhapmoncongnghephanmem.repository.UserRepository;

@Controller
@RequestMapping(value = "/checkOutProcessing")
public class CheckOutProcessingController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ICodeRepository codeRepository;

	@Autowired
	private BillDetailsRepository billDetailsRepository;
	@Autowired
	private CodeDetailsRepository codeDetailsRepository;

	@Autowired
	private CodeConverter codeConverter;

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private RoomConverter roomConverter;

	// Tien hanh cap nhat dat phong
	@PostMapping
	public ModelAndView receiveCheckOutRequest(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, IOException {
		ModelAndView mav = new ModelAndView("web/checkoutsucess");
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		String cmnd = request.getParameter("cmnd");
		String phoneNumber = request.getParameter("phoneNumber");
		String specialRequest = request.getParameter("specialRequest");
		String payment = request.getParameter("payment");
		CodeDTO data = (CodeDTO) request.getSession().getAttribute("data");
		response.getWriter().println("1");

		if (isVaildEmail(email) && !fullName.isEmpty() && !cmnd.isEmpty() && !phoneNumber.isEmpty()) {
			String randomCode = createRandomString();
			data.setRandomCode(randomCode);
			data.setEmail(email);
			data.setCMND(cmnd);
			data.setPhoneNumber(phoneNumber);
			data.setSpecialRequest(specialRequest);
			data.setFullName(fullName);
			data.setPaymentMethod(payment);
			codeRepository.save(codeConverter.toEntity(data));
			response.getWriter().println("2");

			for (RoomDTO room : data.getRooms()) {
				CodeDetails codeDetails = new CodeDetails();
				response.getWriter().println(room.getCategoryRoom());
				codeDetails.setRoom(roomConverter.toEntity(room));
				codeDetails.setPrice(room.getPrice());
				codeDetails.setCode(codeConverter.toEntity(data));
				codeDetailsRepository.save(codeDetails);
			}

			try {
				response.getWriter().println("3");
				sendVertificationEmail(randomCode, email);
				response.getWriter().println("4");

			} catch (MessagingException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return mav;

	}

	@GetMapping
	public void handeCheckOut(HttpServletRequest request, HttpServletResponse response)throws ParseException, IOException {
		//		ModelAndView mav = new ModelAndView("web/bill");
		String codeParameter = (String) request.getParameter("code");
		Code code = codeRepository.findOneByRandomCode(codeParameter);
		
		if(code == null) {
			
//			try {
//				sendVertificationEmail("gui hong duoc", "satakemysoul@gmail.com");
//			}
//			catch (Exception e) {
//			
//			}
			
			return;
		}
		
//		Code code = codeRepository.findOneByRandomCode(codeParameter);
		User user = new User();
		
		user.setCMND(code.getCMND());
		user.setEmail(code.getEmail());
		user.setFullName(code.getFullName());
		user.setPhoneNumber(code.getPhoneNumber());
		user.setStatus(0);
		User saveUser = userRepository.save(user);
		Bill bill = new Bill();
		bill.setCheckInDate(code.getCheckInDate());
		bill.setCheckOutDate(code.getCheckOutDate());
		bill.setPaymentMethod(code.getPaymentMethod());
		bill.setSpecialRequest(code.getSpecialRequest());
		bill.setUser(saveUser);
		bill.setStatus("OnGoing");
		Bill saveBill = billRepository.save(bill);
		ArrayList<Integer> roomNumbers = new ArrayList<Integer>();
		for (CodeDetails codeDetails : code.getCodeDetails()) {
			BillDetails billDetail = new BillDetails();
			billDetail.setBill(bill);
			billDetail.setPrice(codeDetails.getPrice());
			billDetail.setRoom(codeDetails.getRoom());
			roomNumbers.add(codeDetails.getRoom().getRoomNumber());
			billDetailsRepository.save(billDetail);
		}
		for (CodeDetails codeDetails : code.getCodeDetails()) {
			codeDetailsRepository.delete(codeDetails);
		}
		code.setCodeDetails(null);
		codeRepository.delete(code);

		try {
			
			sendElectronicBillEmail(roomNumbers, saveUser.getEmail(), saveBill.getBill_ID());
		} catch (MessagingException | IOException e) {
			
			e.printStackTrace();
		}
//		return mav;
		response.sendRedirect("/trang-chu");

	}

	// Tao chuoi ngau nhien
	private String createRandomString() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		return generatedString;
	}

	private boolean isVaildEmail(String email) {
		EmailValidator validator = EmailValidator.getInstance();
		return validator.isValid(email);
	}

	private void sendVertificationEmail(String randomCode, String email)
			throws AddressException, MessagingException, IOException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		// email gui
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("satakemysoul@gmail.com", "tienNguye1n");
			}
		});
		// Email Nhan
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("satakemysoul@gmail.com", false));

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		msg.setSubject("Confirm Email");
		msg.setContent("Hotel Email", "text/html");
		msg.setText("Please click The link below to vertify your email."
				+ "https://chuyendeweb.herokuapp.com/checkOutProcessing?code=" + randomCode);
		msg.setSentDate(new Date());
		Transport.send(msg);
	}

	private void sendElectronicBillEmail(ArrayList<Integer> roomNumbers, String email, int bill_ID)
			throws AddressException, MessagingException, IOException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		// email gui
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("satakemysoul@gmail.com", "tienNguye1n");
			}
		});
		// Email Nhan
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("satakemysoul@gmail.com", false));

		String roomRent = "";
		for (Integer integer : roomNumbers) {
			roomRent = roomRent.concat(integer + ",");
		}
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		msg.setSubject("Hotel Electronic Bill. ID_" + bill_ID);
		msg.setContent("Hotel Email", "text");
		msg.setText("Room Number: " + roomRent);
		msg.setSentDate(new Date());
		Transport.send(msg);
	}

}
