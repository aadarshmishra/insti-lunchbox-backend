package com.iiitb.instilunchbox.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    void sendEmailToNgo(String instiName) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("aadarsh9600@gmail.com");

        msg.setSubject("Lunchbox has been added.");
        msg.setText("Hello, \n \n A lunchbox has been added by " + instiName + ". Kindly check your dashboard."
        + "\n \n Thank You. \n Regards, \n Team InstiLunchbox");

        javaMailSender.send(msg);

    }
    void sendEmailToInsti(String ngoName) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("aadarsh9600@gmail.com");

        msg.setSubject("Lunchbox Pickup Confirmed.");
        msg.setText("Hello, \n \n Lunchbox has been confirmed for pickup by " + ngoName +
                ".\n \n Thank You. \n Regards, \n Team InstiLunchbox");

        javaMailSender.send(msg);

    }
}
