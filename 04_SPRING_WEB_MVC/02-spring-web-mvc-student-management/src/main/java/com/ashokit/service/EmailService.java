package com.ashokit.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // SimpleMailMessage
    public void sendEmail(String subject,String body,String to){
        try {
            SimpleMailMessage simpleMailMessage=new SimpleMailMessage();

            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(body);
            simpleMailMessage.setTo(to);

            mailSender.send(simpleMailMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // MimeMessage
    public void sendMimeMessageEmail(String subject,String body,String to){
        try {
            MimeMessage mimeMessage=mailSender.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper(mimeMessage, true); //  multipart enabled

            helper.setSubject(subject);
            helper.setText(body,true);
            helper.setTo(to);

            helper.addAttachment("Notes",new File("F:\\Spring Boot And Microservice By Ashok IT 2024-JULY\\Notes\\11_REST_API_Material.pdf"));

            mailSender.send(mimeMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
