package moview.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import moview.backend.model.Movie;
import moview.backend.repository.MovieRepository;

@Service
public class DashboardService {
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public Movie saveMovie(Movie movie){
		return movieRepository.save(movie);
	}

	public void deleteById(String id) {
		movieRepository.deleteById(id);
		
	}

	public void updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		movieRepository.save(movie);
	}

	public Optional<Movie> getMovieById(String type) {
		// TODO Auto-generated method stub
		return movieRepository.findById(type);
	}

	public List<Movie> getFeaturedTvShows(String type) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("isMovie").is(Boolean.FALSE));
		query.addCriteria(Criteria.where("isFeatured").is(Boolean.TRUE));
		List<Movie> movies = mongoTemplate.find(query, Movie.class);
		return movies;
	}

	public List<Movie> getFeaturedMovie(String type) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("isMovie").is(Boolean.TRUE));
		query.addCriteria(Criteria.where("isFeatured").is(Boolean.TRUE));
		List<Movie> movies = mongoTemplate.find(query, Movie.class);
		return movies;
	}

	public List<Movie> getMovieByName(String name) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("name").regex("^"+name));
		List<Movie> movies = mongoTemplate.find(query, Movie.class);
		return movies;
	}

	public List<Movie> getAllTvShows() {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("isMovie").is(Boolean.FALSE));
		List<Movie> movies = mongoTemplate.find(query, Movie.class);
		return movies;
	}

	public List<Movie> getAllMovie() {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("isMovie").is(Boolean.TRUE));
		List<Movie> movies = mongoTemplate.find(query, Movie.class);
		return movies;
	}

}
