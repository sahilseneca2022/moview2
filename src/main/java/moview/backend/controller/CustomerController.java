package moview.backend.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import moview.backend.model.Customer;
import moview.backend.model.Movie;
import moview.backend.services.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/registerCustomer")
	public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
		try {
			if(customer.getEmail()==null && customer.getPassword()==null) {
				throw new Exception("Bad Request");
			}
			 String newPassword = new String(Base64.getEncoder().encode(customer.getPassword().getBytes()));
			 customer.setPassword(newPassword);
			 customerService.save(customer);
			return new ResponseEntity<>("customer registered successfully", HttpStatus.OK);
		} catch (Exception e) {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/getCustomerById")
	public ResponseEntity<Customer> getCustomerById(@RequestBody String customerId) {
		try {
			if(customerId==null) {
				throw new Exception("Bad Request");
			}
			Customer customer = customerService.getCustomerById(customerId).get();
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} catch (Exception e) {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
