package com.connectiva.email_system.service;

import com.connectiva.email_system.model.Lead;
import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {

    @Value("${sendgrid.api.key}")
    private String apiKey;

    private static final String FROM_EMAIL = "johane@fiza.events";

    public void sendEmail(Lead lead) {

        Email from = new Email(FROM_EMAIL);
        Email to = new Email(lead.getEmail());

        String subject = "Connectiva Finance Conference Invitation";

        String contentText =
                "Hi " + lead.getName() + ",\n\n" +
                "You are invited to our upcoming finance conference.\n" +
                "Company: " + lead.getCompany() + "\n\n" +
                "Regards,\nConnectiva Events";

        Content content = new Content("text/plain", contentText);

        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            Response response = sg.api(request);

            System.out.println("Email sent to: " + lead.getEmail());
            System.out.println("Status: " + response.getStatusCode());

        } catch (IOException ex) {
            System.out.println("SendGrid error: " + ex.getMessage());
        }
    }
}
