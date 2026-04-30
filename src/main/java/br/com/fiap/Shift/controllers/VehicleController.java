package br.com.fiap.Shift.controllers;

import br.com.fiap.Shift.dto.VehicleSummary;
import br.com.fiap.Shift.models.Vehicle;
import br.com.fiap.Shift.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("vehicles")
@Slf4j
public class VehicleController {
    
    @Autowired
    private VehicleService service;

    @GetMapping
    public ResponseEntity<Page<Vehicle>> listAll(@PageableDefault(size = 5) Pageable pageable) {
        log.info("Listing all vehicles with pagination");
        return ResponseEntity.ok(service.getAllVehicles(pageable));
    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        log.info("Creating vehicle");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.addVehicles(vehicle));
    }

    @GetMapping("{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Integer id) {
        log.info("getVehicleById: " + id);
        return ResponseEntity.ok(service.getVehiclesById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteVehicleById(@PathVariable Integer id) {
        log.info("deleteVehicleById: " + id);
        service.deleteVehicleById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Vehicle> updateVehicleById(@PathVariable Integer id, @RequestBody Vehicle vehicle) {
        log.info("updateVehicleById: " + id);
        return ResponseEntity.ok(service.updateVehicle(id, vehicle));
    }

    @GetMapping("search/manufacturer")
    public List<Vehicle> findByManufacturer(@RequestParam String manufacturer) {
        return service.findByManufacturer(manufacturer);
    }

    @GetMapping("search/model")
    public List<Vehicle> findByModel(@RequestParam String model) {
        return service.findByModel(model);
    }

    @GetMapping("search/price")
    public List<Vehicle> findByPrice(@RequestParam BigDecimal maxPrice) {
        return service.findByPrice(maxPrice);
    }

    @GetMapping("search/year")
    public List<Vehicle> findByYear(@RequestParam Integer year) {
        return service.findByYear(year);
    }

    @GetMapping("summary")
    public List<VehicleSummary> getSummaries() {
        return service.getVehicleSummaries();
    }
}
