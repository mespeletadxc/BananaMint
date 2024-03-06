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
@Table(name = "goals")
@Schema(name = "goal", description = "Modelo goal")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(0)
    @Schema(name = "Goal ID", example = "1", required = false)
    private Long id;

    private String name;

    private String description;

    private double targetAmount;

    private String status;

    private LocalDate targetDate;

    @Transient
    private Customer user;


}
