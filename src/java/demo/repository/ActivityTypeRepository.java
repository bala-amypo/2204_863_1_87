package com.example.demo.repository;

import com.example.demo.entity.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityTypeRepository
        extends JpaRepository<ActivityType, Long> {
}
