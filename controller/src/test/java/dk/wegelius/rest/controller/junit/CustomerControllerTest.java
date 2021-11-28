package dk.wegelius.rest.controller.junit;


import dk.wegelius.rest.controller.controllers.CustomersController;
import dk.wegelius.rest.dao.entities.Customer;
import dk.wegelius.rest.service.services.CustomersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CustomersController.class)
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomersService customersService;

    @BeforeEach
    void setup() {

        Customer testCustomer = new Customer();
        testCustomer.setCustomerId(1L);
        testCustomer.setFirstName("Test");
        testCustomer.setLastName("Testingson");
        testCustomer.setEmailAddress("test@test.dk");
        testCustomer.setPhoneNumber("12345678");
        testCustomer.setStartDate(new Date(new java.util.Date().getTime()));

        Mockito.when(customersService.getCustomer(testCustomer.getCustomerId())).thenReturn(testCustomer);
    }

    @Test
    void getCustomer() throws Exception {
        this.mockMvc.perform(get("/customers/1"))
                .andExpect(status().isOk());
    }
}
