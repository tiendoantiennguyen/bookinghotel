package com.nhapmoncongnghephanmem.controller.web;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/test")
public class TestController {
	@GetMapping
	public void test() throws AddressException, MessagingException, IOException {
		sendVertificationEmail("abc", "truongginjs@gmail.com");
		sendVertificationEmail("abc", "satakemysoul@gmail.com");
		
		
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
	
	
}