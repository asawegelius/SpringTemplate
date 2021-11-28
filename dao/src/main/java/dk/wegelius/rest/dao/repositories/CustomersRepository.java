package dk.wegelius.rest.dao.repositories;

import dk.wegelius.rest.dao.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository  extends CrudRepository<Customer, Long> {
}
