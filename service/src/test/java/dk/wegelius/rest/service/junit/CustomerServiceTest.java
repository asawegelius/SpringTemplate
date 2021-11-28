package dk.wegelius.rest.service.junit;

import dk.wegelius.rest.dao.entities.Customer;
import dk.wegelius.rest.dao.repositories.CustomersRepository;
import dk.wegelius.rest.service.services.CustomersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @Mock
    private CustomersRepository customersRepository;
    @InjectMocks
    private CustomersService customersService;

    @BeforeEach
    public void setUp() {

        Customer testCustomer = new Customer();
        testCustomer.setCustomerId(1L);
        testCustomer.setFirstName("Test");
        testCustomer.setLastName("Testingson");
        testCustomer.setEmailAddress("test@test.dk");
        testCustomer.setPhoneNumber("12345678");
        testCustomer.setStartDate(new Date(new java.util.Date().getTime()));

        Mockito.when(customersRepository.findById(testCustomer.getCustomerId())).thenReturn(Optional.of(testCustomer));
    }

    @Test
    void testGetCustomer() {

        String firstName = "Test";
        Customer customer = customersService.getCustomer(1L);
        assertNotNull(customer);
        assertEquals(firstName, customer.getFirstName());

    }
}
