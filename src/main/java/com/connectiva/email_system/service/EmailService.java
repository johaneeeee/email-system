package com.connectiva.email_system.service;

import com.connectiva.email_system.model.Activity;
import com.connectiva.email_system.model.Lead;
import com.connectiva.email_system.repository.ActivityRepository;
import com.connectiva.email_system.repository.LeadRepository;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.*;
import com.sendgrid.helpers.mail.objects.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmailService {

    @Value("${sendgrid.api.key}")
    private String apiKey;

    private static final String FROM_EMAIL = "johane@fiza.events";

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private ActivityRepository activityRepository;

    public void sendCampaign(String eventId) {
        List<Lead> leads = leadRepository.findEmailCampaignLeadsByEvent(eventId);

        for (Lead lead : leads) {
            String toEmail = lead.getPerson().getEmail();
            String firstName = lead.getPerson().getFirstName();

            Activity activity = new Activity();
            activity.setLeadId(lead.getLeadId());
            activity.setEventId(eventId);
            activity.setActivityType("EMAIL");
            activity.setActivityDate(LocalDateTime.now());

            try {
                Email from = new Email(FROM_EMAIL);
                Email to = new Email(toEmail);
                String subject = "Connectiva Finance Conference Invitation";
                String body = "Hi " + firstName + ",\n\n" +
                        "You are invited to our upcoming finance conference.\n\n" +
                        "Regards,\nConnectiva Events";
                Content content = new Content("text/plain", body);
                Mail mail = new Mail(from, subject, to, content);

                SendGrid sg = new SendGrid(apiKey);
                Request request = new Request();
                request.setMethod(Method.POST);
                request.setEndpoint("mail/send");
                request.setBody(mail.build());
                Response response = sg.api(request);

                activity.setSummary("SENT - status: " + response.getStatusCode());
                System.out.println("Email sent to: " + toEmail);

            } catch (IOException ex) {
                activity.setSummary("FAILED - " + ex.getMessage());
                System.out.println("SendGrid error for " + toEmail + ": " + ex.getMessage());
            } finally {
                activityRepository.save(activity);
            }
        }
    }
}
