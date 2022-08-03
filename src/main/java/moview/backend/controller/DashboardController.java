package moview.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import moview.backend.model.Movie;
import moview.backend.services.DashboardService;

@RestController
public class DashboardController {

	@Autowired
	DashboardService dashboardService;

//	1.	Create a endpoint that will create movies/tv shows to be added 
//	to the database.The below is the data that must be added when a movie is created:
	@PostMapping("/addMovie")
	public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
		try {
			if(movie.getName()==null && movie.getIsMovie()==null) {
				throw new Exception("Bad Request");
			}
			
			Movie addedMovie = dashboardService.saveMovie(movie);
			return new ResponseEntity<>(addedMovie.getName()+ "added", HttpStatus.OK);
		} catch (Exception e) {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
//	2.	Create an endpoint that retrieves all the movies in the database.
	@GetMapping("/getAllMovie")
	public ResponseEntity<List<Movie>> getAllMovie(){
		try {
		return new ResponseEntity<>(dashboardService.getAllMovie(), HttpStatus.OK);
		} catch (Exception e) {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
//	3.	Create an endpoint that retrieves  all the tv shows in the database.
	@GetMapping("/getAllTvShows")
	public ResponseEntity<List<Movie>> getAllTvShows(){
		try {
			return new ResponseEntity<>(dashboardService.getAllTvShows(), HttpStatus.OK);
			} catch (Exception e) {
				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
	}
	
//	4.	Create an end point that allows a user to supply a title of
//	a movie and/or tv show and allow the API to return a list of
//			movies and/or tv shows that CONTAINS the supplied title
	@PostMapping("/getMovieByName")
	public ResponseEntity<List<Movie>> getMovieByName(@RequestBody String name) {
		try {
			if(name==null) {
				throw new Exception("Bad Request");
			}
			return new ResponseEntity<>(dashboardService.getMovieByName(name), HttpStatus.OK);
			} catch (Exception e) {
				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
	}
	
//	5.	Create an endpoint that will retrieve the featured movies in 
//	the database. Your end point MUST contain a query string	
	@PostMapping("/getFeaturedMovie")
	public ResponseEntity<List<Movie>> getFeaturedMovie(@RequestBody String type) {
		try {
			if(type==null) {
				throw new Exception("Bad Request");
			}
			return new ResponseEntity<>(dashboardService.getFeaturedMovie(type), HttpStatus.OK);
			} catch (Exception e) {
				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
	}
	
//	6.	Create an endpoint that will retrieve the featured tv shows in the database.
//	Your end point MUST contain a query string
	@PostMapping("/getFeaturedTvShows")
	public ResponseEntity<List<Movie>> getFeaturedTvShows(@RequestBody String type) {
		try {
			if(type==null) {
				throw new Exception("Bad Request");
			}
			return new ResponseEntity<>(dashboardService.getFeaturedTvShows(type), HttpStatus.OK);
			} catch (Exception e) {
				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
	}
	
//	7.	Create an endpoint that will retrieve a specific movie or tv show 
//	in the database. This endpoint should  also provide validation logic,
//	specifically for endpoints that do not contain a valid movie id.
	@PostMapping("/getMovieById")
	public ResponseEntity<Movie> getMovieById(@RequestBody String id) {
		try {
			if(id==null) {
				throw new Exception("Bad Request");
			}
			return new ResponseEntity<>(dashboardService.getMovieById(id).get(), HttpStatus.OK);
			} catch (Exception e) {
				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
	}
	
//	8.	Create an endpoint that will update and change an existing movie 
//	in the database. For example, changing movie rent prices, etc. This 
//	endpoint should  also provide validation logic, specifically for 
//	endpoints that do not contain a valid movie id and missing incoming data.
	@PutMapping("/updateMovie")
	public ResponseEntity<String> updateMovie(@RequestBody Movie movie) {
		try {
			if(movie.getName()==null && movie.getIsMovie()==null) {
				throw new Exception("Bad Request");
			}
			dashboardService.updateMovie(movie);
			return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	
//	9.	Create an endpoint that will delete  an existing movie or tv show in the database.
//	This endpoint should  also provide validation logic, specifically for endpoints
//	that do not contain a valid movie id.
	@DeleteMapping("/deleteById")
	public ResponseEntity<String> deleteById(@RequestBody String id) {
		try {
			if(id==null) {
				throw new Exception("Bad Request");
			}
			dashboardService.deleteById(id);
			return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
		      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		    }		
	}
}
