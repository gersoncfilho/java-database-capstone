package com.project.back_end.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Entity
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@Table(name = "patients")
public class Patient extends User {

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @Embedded
    @NotNull
    private Address address;

    @NotNull
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;
}
