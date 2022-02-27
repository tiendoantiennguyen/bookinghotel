package com.nhapmoncongnghephanmem.controller.web;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import com.nhapmoncongnghephanmem.entity.Room;
import com.nhapmoncongnghephanmem.entity.User;
import com.nhapmoncongnghephanmem.repository.BillDetailsRepository;
import com.nhapmoncongnghephanmem.repository.BillRepository;
import com.nhapmoncongnghephanmem.repository.CodeDetailsRepository;
import com.nhapmoncongnghephanmem.repository.ICodeRepository;
import com.nhapmoncongnghephanmem.repository.RoomRepository;
import com.nhapmoncongnghephanmem.repository.UserRepository;

@Controller
@RequestMapping(value = "/cancelRoom")
public class CancelRoomController {


	@Autowired
	private ICodeRepository codeRepository;
	
	@Autowired
	private BillDetailsRepository billDetailsRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private CodeDetailsRepository codeDetailsRepository;

	@Autowired
	private CodeConverter codeConverter;

	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private RoomConverter roomConverter;
	@PostMapping
	public ModelAndView receiveCancelRoomRequest(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, IOException, AddressException, MessagingException {
		ModelAndView mav = new ModelAndView("web/home");
		ArrayList<String> errors = new ArrayList<String>();
		CodeDTO data = (CodeDTO) request.getSession().getAttribute("data");
		ArrayList<Room> roomCancels = new ArrayList<Room>();
		List<BillDetails> billDetails = new ArrayList<BillDetails>();
		response.getWriter().println("1");
		if (data.getRooms().size() != 0) {
		for (RoomDTO roomDTO : data.getRooms()) {
			//lay bill can update
			response.getWriter().println("dataRooms:"+data.getRooms().size());
			Room roomCancel = roomConverter.toEntity(roomDTO);//chuyen dto sang entity de chuyen xuong sql
			
			int roomNumber = roomCancel.getRoomNumber();
			roomCancels = roomRepository.findRoom(roomNumber);//lay data room tu sql
			response.getWriter().println("categoryRoomID:"+roomNumber);
			response.getWriter().println("roomCancelSize:"+roomCancels.size());
			
			for (Room room : roomCancels) {
				billDetails = room.getBillDetails();
		
			response.getWriter().println("6");
			for (BillDetails billDetailCancel : billDetails) {
				Bill bill = billDetailCancel.getBill();
				response.getWriter().println("3");
				
				Bill billCancel = billRepository.find(bill.getBill_ID());//lay data 'bill' tu sql
				response.getWriter().println("bill_Id: la la"+billCancel.getBill_ID());
				
				
				//update bill status "Cancel"
					billCancel.setStatus("Cancel");
					
					billRepository.save(billCancel);
					int bill_id = billCancel.getBill_ID();
					response.getWriter().println("bill-id:"+bill_id);
					
					//delete billDetails
					billDetailsRepository.delete(billCancel.getBill_ID());
					 response.getWriter().println("8");
					 
					 //send email xac nhan
						String randomCode = createRandomString();
						int userID = billCancel.getUser().getUserID();
						User user = userRepository.findUser(userID);
					String email = user.getEmail();
					
					 sendVertificationEmail(randomCode, email);
					 
				}
			}
			
			}
		} else {
			errors.add("Cancel room failed");
		}

	
	if (errors.size() != 0) {
		mav.setViewName("redirect:/searchCancelRoom");
	}
		response.getWriter().println("sucess");

		return mav;
	}
	// Tien hanh huy phong
//	@GetMapping
//	public void handeCancelRoom(HttpServletRequest request, HttpServletResponse response) {
//		
//		}
//		
		
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
	public static boolean isVaildEmail(String email) {
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
		msg.setSubject("Confirm Cancel Room Email");
		msg.setContent("Hotel Email", "text/html");
		msg.setText("<a href='http://https://chuyendeweb.herokuapp.com/trang-chu/checkOutProcessing?code=" + randomCode
				+ "'>Please click this link to vertify your email.</a>");
		msg.setSentDate(new Date());
		Transport.send(msg);
	}
}

