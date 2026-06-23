package com.suraj.portfolioBackend.cotroller;

import com.suraj.portfolioBackend.Dto.EmailRequestDto;
import com.suraj.portfolioBackend.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {
    private final EmailService service;


    @PostMapping("/contact/email")
    public ResponseEntity<String> sendMail(@RequestBody EmailRequestDto request){
        return ResponseEntity.ok(service.sendMail(request));
    }
}
