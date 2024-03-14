package com.invest.investpg.src.sendEmail.controller;

import lombok.Data;

@Data
public class SendEmailRequest {

        private String to;
        private String subject;
        private String text;

}
