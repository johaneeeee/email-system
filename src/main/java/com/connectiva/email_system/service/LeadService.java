package com.connectiva.email_system.service;

import com.connectiva.email_system.model.Lead;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadService {

    public List<Lead> getLeads() {
        return List.of(
                new Lead("john@example.com", "John Doe", "ABC Bank"),
                new Lead("sara@example.com", "Sara Lee", "FinCorp"),
                new Lead("mike@example.com", "Mike Smith", "Global Finance")
        );
    }
}