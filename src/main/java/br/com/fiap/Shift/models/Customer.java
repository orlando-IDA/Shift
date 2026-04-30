package br.com.fiap.Shift.models;

import br.com.fiap.Shift.validation.ValidLicense;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ValidLicense
    private String driverLicense;
    private String cpf;
    private LocalDate expiryDate;
    private Boolean active;
}

