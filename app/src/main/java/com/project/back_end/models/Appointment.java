package com.project.back_end.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    private Doctor doctor;

    @ManyToOne
    @NotNull
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "clinic_location_id", referencedColumnName = "id")
    private ClinicLocation clinicLocation;

    @NotNull
    @Column(name = "appointment_time", nullable = false)
    @Future(message = "Appointment time must be in the future")
    private LocalDateTime appointmentTime;

    @NotNull
    private int status; // 0 for scheduled, 1 for completed, 2 = cancelled

    @NotNull
    @Column(name = "created_at", nullable = false, updatable = false)
    @Setter(AccessLevel.NONE)
    private LocalDateTime createdAt;
    @Builder.Default
    @Column(name = "updated_at")
    private LocalDateTime updatedAt = null;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @Transient
    public LocalDateTime getEndTime() {
        return appointmentTime.plusHours(1); // Assuming appointments last 1 hour
    }
}
