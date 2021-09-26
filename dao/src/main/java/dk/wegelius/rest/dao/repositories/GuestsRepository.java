package dk.wegelius.rest.dao.repositories;

import dk.wegelius.rest.dao.entities.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestsRepository extends CrudRepository<Guest, Long> {
}
