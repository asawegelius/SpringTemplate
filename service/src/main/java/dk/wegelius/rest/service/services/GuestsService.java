package dk.wegelius.rest.service.services;


import dk.wegelius.rest.dao.entities.Guest;
import dk.wegelius.rest.dao.repositories.GuestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestsService {
    private final GuestsRepository guestsRepository;

    @Autowired
    public GuestsService(GuestsRepository guestsRepository) {
        this.guestsRepository = guestsRepository;
    }

    public List<Guest> getAllGuests() {
        List<Guest> guests = new ArrayList<>();
        this.guestsRepository.findAll().forEach(guests::add);
        guests.sort((o1, o2) -> {
            if (o1.getLastName().equals(o2.getLastName())){
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
            return o1.getLastName().compareTo(o2.getLastName());
        });
        return guests;
    }

    public Guest getGuest(long id) {
        return guestsRepository.findById(id).orElse(null);
    }
}
