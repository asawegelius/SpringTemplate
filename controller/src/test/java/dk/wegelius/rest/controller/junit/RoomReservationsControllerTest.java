package dk.wegelius.rest.controller.junit;

import dk.wegelius.rest.controller.controllers.ReservationsController;
import dk.wegelius.rest.dao.repositories.RoomReservationRepository;
import dk.wegelius.rest.dao.repositories.RoomsRepository;
import dk.wegelius.rest.dto.models.RoomReservation;
import dk.wegelius.rest.dto.utils.DateUtils;
import dk.wegelius.rest.service.services.RoomReservationsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ReservationsController.class)
public class RoomReservationsControllerTest {
    @MockBean
    private RoomReservationsService reservationsService;

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private RoomsRepository roomsRepository;
    @MockBean
    private RoomReservationRepository roomReservationRepository;

    @BeforeEach
    void setUp() {

        reservationsService = new RoomReservationsService(roomsRepository, roomReservationRepository);
    }

    @Test
    public void getReservations() throws Exception {
        String dateString = "2020-01-01";
        Date date = DateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservations = new ArrayList<>();
        RoomReservation roomReservation = new RoomReservation();
        roomReservation.setLastName("Unit");
        roomReservation.setFirstName("Junit");
        roomReservation.setDate(date);
        roomReservation.setRoomName("Junit Room");
        roomReservation.setRoomNumber("J1");
        roomReservations.add(roomReservation);
        given(reservationsService.getRoomsAndReservationsForDate(date)).willReturn(roomReservations);

        this.mockMvc.perform(get("/reservations?date=2020-01-01"))
                .andExpect(status().isOk());
    }
}

