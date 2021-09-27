package dk.wegelius.rest.service.junit;

import dk.wegelius.rest.dao.entities.Guest;
import dk.wegelius.rest.dao.entities.Reservation;
import dk.wegelius.rest.dao.entities.Room;
import dk.wegelius.rest.dao.repositories.RoomReservationRepository;
import dk.wegelius.rest.dao.repositories.RoomsRepository;
import dk.wegelius.rest.dto.models.RoomReservation;
import dk.wegelius.rest.dto.utils.DateUtils;
import dk.wegelius.rest.service.services.RoomReservationsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.doReturn;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReservationsServiceTest {

    private RoomReservationsService reservationsService;

    @MockBean
    private RoomReservationRepository reservationsRepository;


    @MockBean
    private RoomsRepository roomsRepository;


    @BeforeEach
    void setUp() {
        reservationsService = new RoomReservationsService(roomsRepository, reservationsRepository);
    }

    @Test
    void testReservation() {

        String dateString = "2020-01-01";
        Date date = DateUtils.createDateFromDateString(dateString);
        List<Reservation> reservations = new ArrayList<>();
        Reservation roomReservation = new Reservation();
        roomReservation.setReservationDate(new java.sql.Date(date.getTime()));
        reservations.add(roomReservation);
        doReturn(reservations).when(reservationsRepository).findReservationByReservationDate(new java.sql.Date(date.getTime()));
        Guest guest = new Guest();
        guest.setFirstName("Test");
        guest.setLastName("Junit");
        List<Room> rooms = new ArrayList<>();
        Room room = new Room();
        room.setRoomNumber("P1");
        room.setRoomName("Piccadilly");
        rooms.add(room);
        doReturn(rooms).when(roomsRepository).findAll();

        List<RoomReservation> returned = reservationsService.getRoomsAndReservationsForDate(date);

        Assertions.assertEquals(reservations.size(), returned.size(), "found all");
    }
}
