package dk.wegelius.rest.controller.controllers;

import dk.wegelius.rest.dao.entities.Guest;
import dk.wegelius.rest.service.services.GuestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("guests")
public class GuestsController {

    private final GuestsService guestsService;

    @Autowired
    public GuestsController(GuestsService guestsService) {
        this.guestsService = guestsService;
    }

    @GetMapping
    public List<Guest> getGuests() {
        return this.guestsService.getAllGuests();
    }

    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable long id) {
        return guestsService.getGuest(id);
    }
}
