package com.example.demo.Controller;

import com.example.demo.Servis.MailServis;
import com.example.demo.Servis.SmsServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
