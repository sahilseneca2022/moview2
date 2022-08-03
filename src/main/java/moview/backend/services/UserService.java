package moview.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import moview.backend.model.Movie;
import moview.backend.model.User;
import moview.backend.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;

	public void save(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	public User authenticate(User user) {
		// TODO Auto-generated method stub
		
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(user.getEmail()));
		query.addCriteria(Criteria.where("password").is(user.getPassword()));
		return mongoTemplate.findOne(query, User.class);

	}

}
