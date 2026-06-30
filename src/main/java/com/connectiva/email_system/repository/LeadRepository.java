package com.connectiva.email_system.repository;

import com.connectiva.email_system.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface LeadRepository extends JpaRepository<Lead, Integer> {

    @Query("SELECT l FROM Lead l JOIN FETCH l.person p WHERE l.eventId = :eventId AND l.emailCampaign = true AND p.email IS NOT NULL")
    List<Lead> findEmailCampaignLeadsByEvent(@Param("eventId") String eventId);
}
