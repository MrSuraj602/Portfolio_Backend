package com.suraj.portfolioBackend.Dto;

import lombok.Data;

@Data
public class EmailRequestDto {
    private String name;
    private String email;
    private String subject;
    private String message;
}
