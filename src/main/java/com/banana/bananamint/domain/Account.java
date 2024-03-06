package com.banana.bananamint.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

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

    @Size(min = 3, max = 10)
    private String type;

    @DateTimeFormat
    @NotNull
    LocalDate openingDate;

    @Min(0)
    private double balance;

    @Min(0)
    private double maxOverdraft;

    //@ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @ToString.Exclude
    private Customer owner;

    @NotNull
    private boolean active;

}
