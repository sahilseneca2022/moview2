package moview.backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import moview.backend.model.Customer;
import moview.backend.model.Movie;
import moview.backend.repository.CustomerRepository;
import moview.backend.repository.MovieRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;

	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	public Optional<Customer> getCustomerById(String customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerId);
	}
	
	

}
