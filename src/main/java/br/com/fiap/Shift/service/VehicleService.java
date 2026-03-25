package br.com.fiap.Shift.service;

import br.com.fiap.Shift.models.Vehicle;
import br.com.fiap.Shift.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository repository;

    public List<Vehicle> getVehicles() {
        return repository.findAll();
    }

    public Vehicle addVehicles (Vehicle vehicle){
        return repository.save(vehicle);
    }

    public Optional<Vehicle> getVehiclesById(Integer id){
        return repository.findById(id);
    }

    public void deleteVehicle(Integer id){
        var optionalVehicle = getVehiclesById(id);
        if(optionalVehicle.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle not founded.");
        }
        repository.deleteById(id);
    }

    public Vehicle updateVehicle (Integer id, Vehicle newVehicles){
        var optionalVehicle = getVehiclesById(id);
        if(optionalVehicle.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle not founded.");
        }
        newVehicles.setId(id);
        return repository.save(newVehicles);
    }
}
