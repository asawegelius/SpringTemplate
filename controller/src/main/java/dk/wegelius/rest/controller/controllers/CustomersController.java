package dk.wegelius.rest.controller.controllers;

import dk.wegelius.rest.dao.entities.CustomerEntity;
import dk.wegelius.rest.dto.models.Customer;
import dk.wegelius.rest.dto.models.DataWrapper;
import dk.wegelius.rest.service.services.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
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
    public ResponseEntity<Customer> getCustomer(@PathVariable long id) {
        DataWrapper<Customer> result = this.customersService.getCustomer(id);
        if(result.getData() != null) {
            return new ResponseEntity<>(result.getData(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
        DataWrapper<Customer> result = this.customersService.updateCustomer(customer, id);
        if(result.getData() != null) {
            return new ResponseEntity<>(result.getData(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
