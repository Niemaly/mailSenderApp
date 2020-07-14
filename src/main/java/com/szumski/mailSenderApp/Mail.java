package com.szumski.mailSenderApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.*;

@Component
public class Mail implements MailStrategy {

    String contentFileName;

    String title;

    String content;

    JavaMailSender javaMailSender;

    @Autowired
    public Mail(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public Mail() {
    }

    void setContent() throws IOException {
        String filePath;

        if (!contentFileName.isEmpty()){
            filePath= "/home/jacek/Pobrane/mailSenderApp/src/main/resources/templates/"+ contentFileName +".html";

        } else {
            filePath ="/home/jacek/Pobrane/mailSenderApp/src/main/resources/templates/mail1.html";
        }


        File file = new File(filePath);

        BufferedReader bufferedReader= new BufferedReader(new FileReader(file.getPath()));
        StringBuilder stringBuilder = new StringBuilder();

        while (bufferedReader.ready()){

            stringBuilder.append(bufferedReader.readLine());

        }

        content = stringBuilder.toString();


    }

    // make it as builder with only build method available


    @Override
    public void sendMail() throws MessagingException {


        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("jac3k2@gmail.com");

        helper.setSubject(title);

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText(content, true);

        javaMailSender.send(msg);
    }


    public void setTitle(String title) {
        this.title = title;
    }




}
