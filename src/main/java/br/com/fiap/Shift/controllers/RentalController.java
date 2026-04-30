package br.com.fiap.Shift.controllers;

import br.com.fiap.Shift.dto.RentalRequest;
import br.com.fiap.Shift.dto.RentalResponse;
import br.com.fiap.Shift.models.Rental;
import br.com.fiap.Shift.repositories.CustomerRepository;
import br.com.fiap.Shift.repositories.VehicleRepository;
import br.com.fiap.Shift.service.RentalService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@Slf4j
@Validated
@RequestMapping("rental")
public class RentalController {
    
    @Autowired
    private RentalService rentalService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping
    public ResponseEntity<List<RentalResponse>> listAll(){
        List<RentalResponse> responses = rentalService.getAllRentals()
                .stream()
                .map(RentalResponse::fromEntity)
                .toList();
        return ResponseEntity.ok(responses);
    }

    @PostMapping
    public ResponseEntity<RentalResponse> create(@RequestBody @Valid RentalRequest rentalRequest) {
        Rental rental = rentalRequest.toEntity();

        rental.setCustomer(customerRepository.findById(rentalRequest.customerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found.")));

        rental.setVehicle(vehicleRepository.findById(rentalRequest.vehicleId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle not found.")));

        Rental savedRental = rentalService.addRental(rental);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(RentalResponse.fromEntity(savedRental));
    }

    @GetMapping("{id}")
    public ResponseEntity<RentalResponse> findById(@PathVariable Integer id) {
        log.info("findById: " + id);
        Rental rental = rentalService.getRentalById(id);
        return ResponseEntity.ok(RentalResponse.fromEntity(rental));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        log.info("Deleting rental: " + id);
        rentalService.deleteRentalById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<RentalResponse> update(@PathVariable Integer id, @RequestBody @Valid RentalRequest rentalRequest) {
        log.info("Updating rental: " + id);
        Rental rental = rentalRequest.toEntity();
        
        rental.setCustomer(customerRepository.findById(rentalRequest.customerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found.")));

        rental.setVehicle(vehicleRepository.findById(rentalRequest.vehicleId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle not found.")));
        
        Rental updatedRental = rentalService.updateRental(id, rental);
        return ResponseEntity.ok(RentalResponse.fromEntity(updatedRental));
    }

    @GetMapping("search/cpf")
    public ResponseEntity<List<RentalResponse>> findByCpf(@RequestParam String cpf) {
        log.info("Searching rentals for CPF: " + cpf);
        List<RentalResponse> responses = rentalService.findByCpf(cpf)
                .stream()
                .map(RentalResponse::fromEntity)
                .toList();
        return ResponseEntity.ok(responses);
    }
}
