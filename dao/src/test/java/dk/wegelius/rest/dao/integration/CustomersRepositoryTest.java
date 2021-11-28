package dk.wegelius.rest.dao.integration;


import dk.wegelius.rest.dao.entities.Customer;
import dk.wegelius.rest.dao.repositories.CustomersRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomersRepositoryTest {
    @Autowired
    CustomersRepository customersRepository;

    @Test
    public void crudCustomersTest(){
        Customer testCustomer = new Customer();
        testCustomer.setFirstName("Test");
        testCustomer.setLastName("Testingson");
        testCustomer.setEmailAddress("test@test.dk");
        testCustomer.setPhoneNumber("12345678");
        testCustomer.setStartDate(new Date(new java.util.Date().getTime()));
        Customer inserted = customersRepository.save(testCustomer);
        Optional<Customer> customer = customersRepository.findById(inserted.getCustomerId());
        assert(customer.isPresent());
        customersRepository.delete(inserted);
        Optional<Customer> deleted = customersRepository.findById(inserted.getCustomerId());
        assert(!deleted.isPresent());
    }
}
