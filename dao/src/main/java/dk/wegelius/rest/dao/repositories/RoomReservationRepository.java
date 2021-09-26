package dk.wegelius.rest.dao.repositories;

import dk.wegelius.rest.dao.entities.RoomReservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface RoomReservationRepository  extends CrudRepository<RoomReservation, Long> {

    Iterable<RoomReservation> findReservationByReservationDate(@Param("date")Date date);

}
