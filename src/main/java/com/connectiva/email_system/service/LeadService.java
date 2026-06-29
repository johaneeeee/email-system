package com.connectiva.email_system.service;

import com.connectiva.email_system.model.Lead;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadService {

    public List<Lead> getLeads() {
        return List.of(
                new Lead("johanemihanta@gmail.com", "John Doe", "ABC Bank"),
                new Lead("mihantajohane8@gmail.com", "Sara Lee", "FinCorp"),
                new Lead("gasykelyyyyy@gmail.com", "Mike Smith", "Global Finance")
        );
    }
}
