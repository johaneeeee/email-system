package com.connectiva.email_system.repository;

import com.connectiva.email_system.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
}
