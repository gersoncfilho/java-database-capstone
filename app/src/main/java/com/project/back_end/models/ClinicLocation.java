package com.project.back_end.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClinicLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @NotNull
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address_street", column = @Column(name = "address_street")),
            @AttributeOverride(name = "address_number", column = @Column(name = "address_number")),
            @AttributeOverride(name = "address_city", column = @Column(name = "address_city")),
            @AttributeOverride(name = "address_state", column = @Column(name = "address_state")),
            @AttributeOverride(name = "address_type", column = @Column(name = "address_type")),
            @AttributeOverride(name = "address_zip_code", column = @Column(name = "address_zip_code"))
    })
    private Address address;

    @NotNull
    @Column(name = "phone", nullable = false, length = 15)
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Phone number must be between 10 and 15 digits.")
    private String phone;

    @NotNull
    @Email
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @NotNull
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

}
