package br.com.fiap.Shift.repositories;

import br.com.fiap.Shift.dto.VehicleSummary;
import br.com.fiap.Shift.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    List<Vehicle> findByManufacturer(String manufacturer);
    List<Vehicle> findByModelContainingIgnoreCase(String model);
    List<Vehicle> findByDailyPriceLessThanEqual(BigDecimal price);
    List<Vehicle> findByReleaseYear(Integer year);
    List<VehicleSummary> findAllProjectedBy();
}
