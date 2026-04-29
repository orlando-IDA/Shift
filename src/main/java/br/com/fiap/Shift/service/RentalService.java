package br.com.fiap.Shift.service;

import br.com.fiap.Shift.models.Rental;
import br.com.fiap.Shift.repositories.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalService {
    private RentalRepository repository;

    public List<Rental> getAllRentals() {
        return repository.findAll();
    }

    public Rental addRental (Rental rental) {
        return repository.save(rental);
    }

    public Rental getRentalById(Integer id) {
        return repository.findById(id).get();
    }

    public void deleteRentalById(Integer id) {
        repository.deleteById(id);
    }

    private Rental findVehicleById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Rental with ID" + id +"not found"));
    }

    public Rental updateRental(Integer id, Rental newRental) {
        findVehicleById(id);
        newRental.setId(id);
        return repository.save(newRental);

    }



}
