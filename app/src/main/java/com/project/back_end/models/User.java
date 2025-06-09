package com.project.back_end.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotNull(message = "Name cannot be null")
    @Column(name = "name", nullable = false)
    @Size(min = 3, max = 100)
    private String name;

    @NotNull(message = "Email cannot be null")
    @Column(name = "email", nullable = false, unique = true)
    @Email
    private String email;

    @NotNull(message = "Password cannot be null and must be at least 6 characters long and contain at least one uppercase letter, one number, and one special character")
    @Column(name = "password", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 6, max = 20)
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{6,20}$",
            message = "The password must contain at least an uppercase letter, a number and a special character.")
    private String password;

    @Column(name = "available_times", columnDefinition = "TEXT")
    private String availableTimes; // JSON format, nullable for non-doctors

    private LocalDateTime lastLogin;

    @NotNull(message = "Phone number cannot be null and must be exactly 10 digits")
    @Column(name = "phone", nullable = false)
    @Pattern(regexp = "^[0-9]{10}$")
    private String phone;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}