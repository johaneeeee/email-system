package com.connectiva.email_system.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private Integer activityId;

    @Column(name = "lead_id")
    private Integer leadId;

    @Column(name = "event_id")
    private String eventId;

    @Column(name = "activity_type")
    private String activityType;

    @Column(name = "activity_date")
    private LocalDateTime activityDate;

    @Column(name = "summary")
    private String summary;

    // Getters and Setters
    public void setLeadId(Integer leadId) { this.leadId = leadId; }
    public void setEventId(String eventId) { this.eventId = eventId; }
    public void setActivityType(String activityType) { this.activityType = activityType; }
    public void setActivityDate(LocalDateTime activityDate) { this.activityDate = activityDate; }
    public void setSummary(String summary) { this.summary = summary; }
}
