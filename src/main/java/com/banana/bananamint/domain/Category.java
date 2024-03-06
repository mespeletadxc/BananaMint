package com.banana.bananamint.domain;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categorys")
@Schema(name = "category", description = "Modelo category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(0)
    @Schema(name = "Category ID", example = "1", required = false)
    private Integer id;

    private String name;

    private String type;

    private String description;

    private LocalDate createdAt;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY,
            mappedBy = "category")
    private List<Budget> budgets = new ArrayList<>();

    public Category(Integer id, String name, String type, String description, LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.createdAt = createdAt;
    }

    public Category(Object o, String categoriaA, String tipoA, String descripcionA, LocalDate now) {

    }
}
