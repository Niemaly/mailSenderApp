package com.szumski.mailSenderApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailSenderAppApplication implements CommandLineRunner {

	@Autowired
	MailSenderClass mailSender;

	@Autowired
	Mail mail;


	public static void main(String[] args) {
		SpringApplication.run(MailSenderAppApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		//mailSender.sendMail();


		mail.setTitle("Hello Jacek");

		mail.contentFileName="mail1";

		mail.setContent();
		mail.sendMail();
	}
}
