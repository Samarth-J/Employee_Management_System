package com.SpringBootProject.Employee_Management_System.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    @Value("${spring.mail.username}")
    private String from;

    public void sendOtp(String toEmail,String otp){
        SimpleMailMessage simpleMailMessage =new  SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject("OTP Verification");
        simpleMailMessage.setText("your otp is"+" "+otp);
        javaMailSender.send(simpleMailMessage);
    }
}
