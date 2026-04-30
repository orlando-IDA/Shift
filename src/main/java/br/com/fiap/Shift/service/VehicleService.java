package br.com.fiap.Shift.service;

import br.com.fiap.Shift.models.Vehicle;
import br.com.fiap.Shift.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public Page<Vehicle> getAllVehicles(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Vehicle> getAllVehicles() {
        return repository.findAll();
    }

    public Vehicle addVehicles(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    public Vehicle getVehiclesById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle not found"));
    }

    public void deleteVehicleById(Integer id) {
        repository.deleteById(id);
    }

    public Vehicle updateVehicle(Integer id, Vehicle newVehicle) {
        getVehiclesById(id);
        newVehicle.setId(id);
        return repository.save(newVehicle);
    }

    public List<Vehicle> findByManufacturer(String manufacturer) {
        return repository.findByManufacturer(manufacturer);
    }

    public List<Vehicle> findByModel(String model) {
        return repository.findByModelContainingIgnoreCase(model);
    }

    public List<Vehicle> findByPrice(BigDecimal maxPrice) {
        return repository.findByDailyPriceLessThanEqual(maxPrice);
    }

    public List<Vehicle> findByYear(Integer year) {
        return repository.findByReleaseYear(year);
    }
}
