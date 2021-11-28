package dk.wegelius.rest.dao.repositories;

import dk.wegelius.rest.dao.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository  extends CrudRepository<CustomerEntity, Long> {
}
