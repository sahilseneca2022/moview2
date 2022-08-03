package moview.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import moview.backend.model.User;
import moview.backend.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@PostMapping("/registerUser")
	public ResponseEntity<String> registerCustomer(@RequestBody User user) {
		try {
			if(user.getEmail()==null && user.getPassword()==null) {
				throw new Exception("Bad Request");
			}
			 userService.save(user);
			return new ResponseEntity<>("user added successfully", HttpStatus.OK);
		} catch (Exception e) {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/authenticateUser")
	public ResponseEntity<String> authenticateUser(@RequestBody User user) {
		try {
			if(user.getEmail()==null && user.getPassword()==null) {
				throw new Exception("Bad Request");
			}
			User userSaved = userService.authenticate(user);
			if(userSaved!=null) {
			 return new ResponseEntity<>("user authenticated successfully", HttpStatus.OK);
			}else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
		} catch (Exception e) {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
