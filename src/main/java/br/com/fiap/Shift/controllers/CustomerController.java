package br.com.fiap.Shift.controllers;

import br.com.fiap.Shift.models.Customer;
import br.com.fiap.Shift.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
@Slf4j
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping
    public List<Customer> listAll(){
        return service.getAllCustomers();
    }

    @PostMapping()
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.addCustomers(customer));
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id){
        log.info("getCustomerById" + id);
        return ResponseEntity.ok(service.getCustomerById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCustomerById (@PathVariable Integer id){
        log.info("deleteCustomerById" + id);
        service.deleteCustomerById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomerById(@PathVariable Integer id, @RequestBody Customer customer){
        log.info("updateCustomerById" + id);
        return ResponseEntity.ok(service.updateCustomer(id,customer));
    }
}
