package com.invest.investpg.src.sendEmail.controller;

import com.invest.investpg.src.sendEmail.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sendEmail")
public class SendEmailController {

    @Autowired
    private SendEmailService sendEmailService;

    @PostMapping("/send")
    public void sendEmail(@RequestBody SendEmailRequest sendEmailRequest) {
        sendEmailService.sendSimpleMessage(sendEmailRequest.getTo(), sendEmailRequest.getSubject(), sendEmailRequest.getText());
    }
}
