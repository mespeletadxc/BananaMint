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
@Table(name = "incomes")
@Schema(name = "income", description = "Modelo income")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(0)
    @Schema(name = "Income ID", example = "1", required = false)
    private Integer Id;

    @Transient
    private Customer user;

    private double amount;

    private LocalDate enterDate;

    @Transient
    private Account moneyTo;

    private String status;

}
