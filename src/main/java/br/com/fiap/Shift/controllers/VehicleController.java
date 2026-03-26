package br.com.fiap.Shift.controllers;


import br.com.fiap.Shift.models.Vehicle;
import br.com.fiap.Shift.repositories.VehicleRepository;
import br.com.fiap.Shift.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehicles")
@Slf4j
public class VehicleController {
    @Autowired
    private VehicleService service;

    @GetMapping
    public List<Vehicle> listAll() { return service.getAllVehicles();}

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.addVehicles(vehicle));
    }

    @GetMapping("{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Integer id) {
        log.info("getVehicleById" + id);
        return ResponseEntity.ok(service.getVehiclesById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteVehicleById(@PathVariable Integer id) {
        log.info("deleteVehicleById" + id);
        service.deleteVehicleById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Vehicle> updateVehicleById(@PathVariable Integer id, @RequestBody Vehicle vehicle) {
        log.info("updateVehicleById" + id);
        return ResponseEntity.ok(service.updateVehicle(id, vehicle));
    }

    
}
