package com.banana.bananamint.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "account", description = "Modelo account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(0)
    @Schema(name = "Account ID", example = "1", required = false)
    private Long id;

    private String type;

    LocalDate openingDate;

    private double balance;

    private double maxOverdraft;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    @ToString.Exclude
    private Customer owner;

    private boolean active;

    //lo añado
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY,
            mappedBy = "moneyFrom")
    private List<Expense> expenses = new ArrayList<>();

    public Account(Long id, String type, LocalDate openingDate, double balance, double maxOverdraft, Customer owner, boolean active) {
        this.id = id;
        this.type = type;
        this.openingDate = openingDate;
        this.balance = balance;
        this.maxOverdraft = maxOverdraft;
        this.owner = owner;
        this.active = active;
    }
}
