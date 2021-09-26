package dk.wegelius.rest.controller.controllers;

import dk.wegelius.rest.dto.models.RoomReservation;
import dk.wegelius.rest.dto.utils.DateUtils;
import dk.wegelius.rest.service.services.RoomReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path="/reservations")
public class ReservationsController {

    private final RoomReservationsService reservationsService;

    @Autowired
    public ReservationsController(RoomReservationsService reservationsService) {
        this.reservationsService = reservationsService;
    }

    @GetMapping
    public List<RoomReservation> getRoomReservations(@RequestParam(name = "date", required = false)String dateString) {
        Date date = DateUtils.createDateFromDateString(dateString);
        return this.reservationsService.getRoomsAndReservationsForDate(date);
    }
}
