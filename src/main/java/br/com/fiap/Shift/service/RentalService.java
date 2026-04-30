package br.com.fiap.Shift.service;

import br.com.fiap.Shift.models.Rental;
import br.com.fiap.Shift.repositories.CustomerRepository;
import br.com.fiap.Shift.repositories.RentalRepository;
import br.com.fiap.Shift.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalService {
    private final RentalRepository repository;
    private final CustomerRepository customerRepository;
    private final VehicleRepository vehicleRepository;

    public List<Rental> getAllRentals() {
        return repository.findAll();
    }

    public Rental addRental(Rental rental) {
        return repository.save(rental);
    }

    public Rental getRentalById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rental not found."));
    }

    public void deleteRentalById(Integer id) {
        repository.deleteById(id);
    }

    public Rental updateRental(Integer id, Rental newRental) {
        getRentalById(id);
        newRental.setId(id);
        return repository.save(newRental);
    }

    public List<Rental> findByCpf(String cpf) {
        return repository.findByCustomerCpf(cpf);
    }
}

