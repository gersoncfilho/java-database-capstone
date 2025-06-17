package com.project.back_end.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@Table(name = "doctors")
public class Doctor extends User {

    @NotNull
    @Size(min = 3, max = 50)
    private String specialty;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DoctorAvailableTimes> availableTimes;
}
