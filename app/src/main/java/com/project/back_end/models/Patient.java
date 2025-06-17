package com.project.back_end.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;
}
