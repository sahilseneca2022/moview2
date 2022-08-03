package moview.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import moview.backend.model.Customer;
import moview.backend.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	

}

