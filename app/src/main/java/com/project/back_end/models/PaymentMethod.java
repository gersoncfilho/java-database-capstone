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
public class PaymentMethod {
    @NotNull
    @Column(name = "type", nullable = false)
    String type;

    @NotNull
    @Column(name = "details", nullable = false, length = 15)
    String details;
}
