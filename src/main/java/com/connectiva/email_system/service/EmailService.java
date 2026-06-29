package com.connectiva.email_system.service;

import com.connectiva.email_system.model.Lead;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendEmail(Lead lead) {

        String subject = "Invitation to Connectiva Events";

        String body = """
                Hi %s,

                You are invited to our upcoming finance conference.

                Company: %s

                Regards,
                Connectiva Events
                """.formatted(lead.getName(), lead.getCompany());

        System.out.println("Sending email to: " + lead.getEmail());
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }
}
