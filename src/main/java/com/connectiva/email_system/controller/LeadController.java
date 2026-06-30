package com.connectiva.email_system.controller;

import com.connectiva.email_system.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LeadController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendCampaign(@RequestParam String eventId) {
        emailService.sendCampaign(eventId);
        return ResponseEntity.ok("Campaign sent for event: " + eventId);
    }
}
