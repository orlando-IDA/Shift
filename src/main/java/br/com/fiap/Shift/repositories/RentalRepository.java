package br.com.fiap.Shift.repositories;

import br.com.fiap.Shift.models.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
}
