package dk.wegelius.rest.service.services;

import dk.wegelius.rest.dao.entities.CustomerEntity;
import dk.wegelius.rest.dao.repositories.CustomersRepository;
import dk.wegelius.rest.dto.models.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomersService {
    private final CustomersRepository customersRepository;

    @Autowired
    public CustomersService(CustomersRepository customersRepository) {this.customersRepository = customersRepository;}

    public List<Customer> getAllCustomers() {
        List<CustomerEntity> customerEntities = new ArrayList<>();
        this.customersRepository.findAll().forEach(customerEntities::add);
        ModelMapper modelMapper = new ModelMapper();
        List<Customer> customers = customerEntities.stream()
                .map(customerEntity -> modelMapper.map(customerEntity, Customer.class))
                .collect(Collectors.toList());;
        return customers;
    }

    public Customer getCustomer(long id) {
        Optional<CustomerEntity> optionalCustomer = customersRepository.findById(id);
        CustomerEntity customerEntity = null;
        if(optionalCustomer.isPresent()){
            customerEntity = optionalCustomer.get();
        }
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = modelMapper.map(customerEntity, Customer.class);
        return customer;
    }
}
