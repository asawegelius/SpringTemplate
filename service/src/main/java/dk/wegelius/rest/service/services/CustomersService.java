package dk.wegelius.rest.service.services;

import dk.wegelius.rest.dao.entities.Customer;
import dk.wegelius.rest.dao.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {
    private final CustomersRepository customersRepository;

    @Autowired
    public CustomersService(CustomersRepository customersRepository) {this.customersRepository = customersRepository;}

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        this.customersRepository.findAll().forEach(customers::add);
        return customers;
    }

    public Customer getCustomer(long id) {
        Optional<Customer> optionalCustomer = customersRepository.findById(id);
        Customer customer = null;
        if(optionalCustomer.isPresent()){
            customer = optionalCustomer.get();
        }
        return customer;
    }
}
