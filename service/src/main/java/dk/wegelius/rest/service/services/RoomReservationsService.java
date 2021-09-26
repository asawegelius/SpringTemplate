package dk.wegelius.rest.service.services;

import dk.wegelius.rest.dao.entities.Room;
import dk.wegelius.rest.dao.repositories.RoomReservationRepository;
import dk.wegelius.rest.dao.repositories.RoomsRepository;
import dk.wegelius.rest.dto.models.RoomReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoomReservationsService {

    private final RoomsRepository roomsRepository;
    private final RoomReservationRepository roomReservationsRepository;

    @Autowired
    public RoomReservationsService(RoomsRepository roomRepository, RoomReservationRepository roomReservationsRepository) {
        this.roomsRepository = roomRepository;
        this.roomReservationsRepository = roomReservationsRepository;
    }

    public List<RoomReservation> getRoomsAndReservationsForDate(Date date) {
        Iterable<Room> rooms = this.roomsRepository.findAll();
        Iterable<dk.wegelius.rest.dao.entities.RoomReservation> roomReservations = this.roomReservationsRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomName(room.getRoomName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getRoomId(), roomReservation);
        });
        roomReservations.forEach((reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoom().getRoomId());
            roomReservation.setDate(date);
            roomReservation.setFirstName(reservation.getGuest().getFirstName());
            roomReservation.setLastName(reservation.getGuest().getLastName());
            roomReservation.setGuestId(reservation.getGuest().getGuestId());
        }));
        List<RoomReservation> roomsAndReservations = new ArrayList<>();
        for(Long id: roomReservationMap.keySet()){
            roomsAndReservations.add(roomReservationMap.get(id));
        }
        roomsAndReservations.sort((o1, o2) -> {
            if (Objects.equals(o1.getRoomName(), o2.getRoomName())){
                return o1.getRoomNumber().compareTo(o2.getRoomNumber());
            }
            return o1.getRoomName().compareTo(o2.getRoomName());
        });
        return roomsAndReservations;
    }

}
