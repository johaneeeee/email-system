package com.connectiva.email_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "leads")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lead_id")
    private Integer leadId;

    @Column(name = "event_id")
    private String eventId;

    @Column(name = "email_campaign")
    private Boolean emailCampaign;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    // Getters
    public Integer getLeadId() { return leadId; }
    public String getEventId() { return eventId; }
    public Boolean getEmailCampaign() { return emailCampaign; }
    public Person getPerson() { return person; }
}
