package com.suraj.portfolioBackend.service;

import com.suraj.portfolioBackend.Dto.EmailRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public String sendMail(EmailRequestDto request) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("surajop609@gmail.com");
        simpleMailMessage.setFrom(request.getEmail());
        simpleMailMessage.setSubject(request.getSubject());
        simpleMailMessage.setText("This mail is send from "+ request.getName()
                +" The Message is : " +request.getMessage());

        mailSender.send(simpleMailMessage);
        return "Mail Send Successfully!! I Will Reach You Soon!!";
    }
}
