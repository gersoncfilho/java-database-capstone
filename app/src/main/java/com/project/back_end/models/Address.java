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
    @Column(name= "address_street", nullable = false, length = 255)
    String addressStreet;

    @NotNull
    @Column(name="address_number", nullable = false, length = 10)
    String addressNumber;

    @NotNull
    @Column(name="address_city", nullable = false, length = 100)
    String addressCity;

    @NotNull
    @Column(name="address_state", nullable = false, length = 2)
    String addressState;

    @NotNull
    @Column(name="address_zip_code", nullable = false, length = 10)
    String addressZipCode;

    @NotNull
    @Column(name="address_type", nullable = false)
    Integer addressType; // 0 for home, 1 for work, 2 for other
}
