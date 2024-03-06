package com.banana.bananamint.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
@Schema(name = "transaction", description = "Modelo transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(0)
    @Schema(name = "Transacion ID", example = "1", required = false)
    private Integer id;

    private double amount;

    private String description;

    private String paymentType;

    @Transient
    private Category category;

    @Transient
    private Account account;

    @Transient
    private Customer user;

    private boolean isDeleted;

    private Long dateTime;

    private LocalDate createdAt;

    private LocalDate updatedAt;


}
