package com.szumski.mailSenderApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailSenderClass {


    JavaMailSender javaMailSender;


    @Autowired
    public MailSenderClass(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public MailSenderClass() {
    }

    void sendMail(){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("jac3k2@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);


    }


}
