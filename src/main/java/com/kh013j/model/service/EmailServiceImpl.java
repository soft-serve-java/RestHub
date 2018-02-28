package com.kh013j.model.service;

import com.kh013j.model.service.interfaces.EmailService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

@NoArgsConstructor
//@Service("emailService")
public class EmailServiceImpl implements EmailService{
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	public EmailServiceImpl(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

    @Async
	public void sendEmail(SimpleMailMessage email) {
		mailSender.send(email);
	}
}
