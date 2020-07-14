package com.szumski.mailSenderApp;

import javax.mail.MessagingException;

public interface MailStrategy {

    void sendMail() throws MessagingException;
}
