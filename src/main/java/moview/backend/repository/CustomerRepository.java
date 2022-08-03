package moview.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import moview.backend.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
	
	

}
