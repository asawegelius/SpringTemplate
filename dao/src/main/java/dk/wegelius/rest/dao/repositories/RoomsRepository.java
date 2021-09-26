package dk.wegelius.rest.dao.repositories;

import dk.wegelius.rest.dao.entities.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomsRepository extends CrudRepository<Room, Long> {
}
