package dk.wegelius.rest.controller.controllers;

import dk.wegelius.rest.dao.entities.CustomerEntity;
import dk.wegelius.rest.dto.models.Customer;
import dk.wegelius.rest.service.services.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomersController {
    private final CustomersService customersService;

    @Autowired
    private CustomersController(CustomersService customersService) {this.customersService = customersService;}

    @GetMapping
    public List<Customer> getCustomers() {
        return this.customersService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable long id) {
        return this.customersService.getCustomer(id);
    }
}
