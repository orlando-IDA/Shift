package br.com.fiap.Shift.service;

import br.com.fiap.Shift.models.Vehicle;
import br.com.fiap.Shift.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class VehicleService {
    @Autowired
    private VehicleRepository repository;

    public List<Vehicle> getAllVehicles() {
        return repository.findAll();
    }

    public Vehicle addVehicles (Vehicle vehicle){
        return repository.save(vehicle);
    }

    public Vehicle getVehiclesById(Integer id){
        return findVechicleById(id);
    }

    public void deleteVehicleById(Integer id){
        findVechicleById(id);
        repository.deleteById(id);
    }

    public Vehicle updateVehicle (Integer id, Vehicle newVehicle){
        findVechicleById(id);
        newVehicle.setId(id);
        return repository.save(newVehicle);
    }

    private Vehicle findVechicleById(Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Vehicle with ID" +id +"not founded"));
    }
}
