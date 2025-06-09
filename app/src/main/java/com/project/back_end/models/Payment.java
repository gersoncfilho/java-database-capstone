package com.project.back_end.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "payments")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Long appointmentId;

    @NotNull
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @NotNull
    @Column(name="payment_date", nullable = false)
    private Date paymentDate;

    @NotNull
    @Column(name = "status", nullable = false)
    private Integer status; // 0 = Pending, 1 = Completed, 2 = Failed

    @Embedded
    private PaymentMethod paymentMethod;
}
