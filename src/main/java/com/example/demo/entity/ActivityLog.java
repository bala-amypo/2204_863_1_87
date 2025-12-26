package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.*;

@Entity
@Table(name = "activity_logs")
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ActivityType activityType;

    @ManyToOne
    private User user;

    private Double quantity;
    private LocalDate activityDate;
    private LocalDateTime loggedAt;
    private Double estimatedEmission;

    public ActivityLog() {}

    public ActivityLog(Long id, ActivityType activityType, User user,
                       Double quantity, LocalDate activityDate,
                       LocalDateTime loggedAt, Double estimatedEmission) {
        this.id = id;
        this.activityType = activityType;
        this.user = user;
        this.quantity = quantity;
        this.activityDate = activityDate;
        this.loggedAt = loggedAt;
        this.estimatedEmission = estimatedEmission;
    }

    @PrePersist
    public void prePersist() {
        this.loggedAt = LocalDateTime.now();
    }

    public Double getQuantity() { return quantity; }
    public LocalDate getActivityDate() { return activityDate; }
    public void setEstimatedEmission(Double e) { this.estimatedEmission = e; }
}
