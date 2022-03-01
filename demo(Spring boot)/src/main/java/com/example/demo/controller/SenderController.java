package com.example.demo.controller;

import com.example.demo.servis.MailServis;
import com.example.demo.servis.SmsServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/send")
public class SenderController {

    @Autowired
    private MailServis mailServis;

    @Autowired
    private SmsServis smsServis;

    @GetMapping(path = "mail")
    public String getMail(){
        return mailServis.getMail();
    }

    @GetMapping(path = "sms")
    public String getSms(){
        return smsServis.getSms();
    }
}
