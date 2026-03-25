package br.com.fiap.Shift.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Vehicle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String manuFacturer;
    private String model;
    private Integer year;
    private String licensePlate;
    private BigDecimal dailyPrice;
}