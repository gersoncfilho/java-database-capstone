package com.project.back_end.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @Builder.Default
    private Set<Role> roles = new HashSet<>();

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

    private LocalDateTime lastLogin;

    @NotNull(message = "Phone number cannot be null and must be exactly 10 digits")
    @Column(name = "phone", nullable = false)
    @Pattern(regexp = "^[0-9]{10}$")
    private String phone;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;
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

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}