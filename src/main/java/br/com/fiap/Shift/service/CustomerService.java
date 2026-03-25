package br.com.fiap.Shift.service;
import br.com.fiap.Shift.models.Vehicle;
import br.com.fiap.Shift.service.CustomerService;
import br.com.fiap.Shift.models.Customer;
import br.com.fiap.Shift.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public List<Customer> getAllCustomers(){
        return repository.findAll();
    }

    public Customer addCustomers (Customer customer){
        return repository.save(customer);
    }

    public Customer getCustomerById (Integer id){
        return findCustomerById(id);
    }

    public void deleteCustomerById(Integer id){
        findCustomerById(id);
        repository.deleteById(id);
    }

    public Customer updateCustomer (Integer id, Customer newCustomer){
        findCustomerById(id);
        newCustomer.setId(id);
        return repository.save(newCustomer);
    }

    private Customer findCustomerById(Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer with ID" +id +"not founded"));
    }
}
