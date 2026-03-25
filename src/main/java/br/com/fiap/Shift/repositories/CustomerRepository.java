package br.com.fiap.Shift.repositories;

import br.com.fiap.Shift.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
