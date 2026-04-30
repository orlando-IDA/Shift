package br.com.fiap.Shift.repositories;

import br.com.fiap.Shift.models.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    List<Rental> findByCustomerCpf(String cpf);
}
