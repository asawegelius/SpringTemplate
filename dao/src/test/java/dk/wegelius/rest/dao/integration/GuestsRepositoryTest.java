package dk.wegelius.rest.dao.integration;

import dk.wegelius.rest.dao.entities.Guest;
import dk.wegelius.rest.dao.repositories.GuestsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class GuestsRepositoryTest {
    @Autowired
    GuestsRepository guestsRepository;

    @Test
    public void myTest() {
        Guest testGuest = new Guest();
        testGuest.setFirstName("Test");
        testGuest.setLastName("Guest");
        testGuest.setEmailAddress("test@test.dk");
        testGuest.setPhoneNumber("12345678");
        testGuest.setAddress("Testgade 2");
        testGuest.setState("TestState");
        testGuest.setCountry("Langtbortistan");
        Guest inserted = guestsRepository.save(testGuest);
        Optional<Guest> guest = guestsRepository.findById(inserted.getGuestId());
        assert(guest.isPresent());
        guestsRepository.delete(inserted);
        Optional<Guest> deleted = guestsRepository.findById(inserted.getGuestId());
        assert(!deleted.isPresent());

    }
}
