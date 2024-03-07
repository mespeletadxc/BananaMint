package com.banana.bananamint.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "expenses")
@Schema(name = "expense", description = "Modelo expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(0)
    @Schema(name = "Expense ID", example = "1", required = false)
    private Integer Id;

    //    @Transient
//    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    @ToString.Exclude
    @JsonIgnore
    private Customer user;

    private double amount;

    private LocalDate dueDate;

    //    @Transient
//    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    @ToString.Exclude
    @JsonIgnore
    private Account moneyFrom;

    private String status;

    public Expense(double amount, LocalDate dueDate, String status) {
        this.amount = amount;
        this.dueDate = dueDate;
        this.status = status;
    }

    public Expense(double amount, LocalDate dueDate, Account moneyFrom) {
        this.amount = amount;
        this.dueDate = dueDate;
        this.moneyFrom = moneyFrom;
    }
}
