package com.project.back_end.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Embeddable
@Builder
@Getter
@Setter
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Address {
    @NotNull
    @Column(name= "street", nullable = false, length = 255)
    String street;

    @NotNull
    @Column(name="number", nullable = false, length = 10)
    String number;

    @NotNull
    @Column(name="city", nullable = false, length = 100)
    String city;

    @NotNull
    @Column(name="state", nullable = false, length = 2)
    String state;

    @NotNull
    @Column(name="zip_code", nullable = false, length = 10)
    String zipCode;

    @NotNull
    @Column(name="type", nullable = false)
    Integer type; // 0 for home, 1 for work, 2 for other
}
