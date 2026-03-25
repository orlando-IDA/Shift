package br.com.fiap.Shift.repositories;

import br.com.fiap.Shift.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
