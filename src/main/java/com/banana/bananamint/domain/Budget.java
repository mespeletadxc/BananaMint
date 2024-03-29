package com.banana.bananamint.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "budgets")
@Schema(name = "budget", description = "Modelo budget")
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(0)
    @Schema(name = "Budget ID", example = "1", required = false)
    private Long id;

    @Transient
    private Category category;

    private double amount;

    @Transient
    private Customer user;

    private Long selected;

    private Long balance;

}
