package com.banana.bananamint.domain;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.banana.bananamint.exception.CustomerException;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
@Schema(name = "customer", description = "Modelo customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(0)
    @Schema(name = "Customer ID", example = "1", required = false)
    private Long id;

    @NotNull
    private String name;

    @NotBlank
    private String email;

    @DateTimeFormat
    @NotNull
    private LocalDate birthDate;

    @NotBlank
    private String dni;

//    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY,
//            mappedBy = "owner")
//    private List<Account> accounts = new ArrayList<>();

    public Customer(Long id) {
        this.id = id;
    }
    //Usado en relación bidireccional
//    public Customer(Long id, String name, String email, LocalDate birthDate, String dni) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.birthDate = birthDate;
//        this.dni = dni;
//    }

    public boolean isValid() throws CustomerException {
        // Para que el usuario sea valido:
        // email válido
        // mayor de 18 años
        // dni: 8_Numeros + 1_Letra
        // Si no es válido, debe lanzar exception

        return false;
    }

}
