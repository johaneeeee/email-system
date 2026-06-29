package com.connectiva.email_system.controller;

import com.connectiva.email_system.model.Lead;
import com.connectiva.email_system.service.EmailService;
import com.connectiva.email_system.service.LeadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LeadController {

    private final LeadService leadService;
    private final EmailService emailService;

    public LeadController(LeadService leadService, EmailService emailService) {
        this.leadService = leadService;
        this.emailService = emailService;
    }

    // Test endpoint: see all leads
    @GetMapping("/leads")
    public List<Lead> getLeads() {
        return leadService.getLeads();
    }

    // Trigger bulk email sending
    @GetMapping("/send-emails")
    public String sendEmails() {

        List<Lead> leads = leadService.getLeads();

        for (Lead lead : leads) {
            emailService.sendEmail(lead);
        }

        return "Emails processed 🚀";
    }
}
