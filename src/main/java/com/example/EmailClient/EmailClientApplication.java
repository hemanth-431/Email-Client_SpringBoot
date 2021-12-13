package com.example.EmailClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class EmailClientApplication {

	@Autowired
	private EmailSendeerService emailSendeerService;

	public static void main(String[] args) {
		SpringApplication.run(EmailClientApplication.class, args);
		EmailClientApplication obj=new EmailClientApplication();
//		obj.triggerMail();
	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void triggerMail(){
//emailSendeerService.sendEmail("bandlavhemanth@gmail.com","Thanks Namaste","Subject Hi");
//	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {

		emailSendeerService.sendEmailWithAttachment("bandlavhemanth30431@gmail.com",
				"This is Email Body with Attachment...",
				"This email has attachment",
				"C:\\Users\\Lenovo\\Pictures\\photo_2021-11-30_17-13-31.jpg");

	}

}
