package moview.backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import moview.backend.model.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

	@Query("SELECT mc FROM movie mc WHERE mc.isMovie = false and mc.isFeatured = true")
	List<Movie> getFeaturedTvShows();

	@Query("SELECT mc FROM movie mc WHERE mc.isMovie = true and mc.isFeatured = true")
	List<Movie> getFeaturedMovie();

	@Query("SELECT mc FROM movie mc WHERE mc.name like '%?1%'")
	List<Movie> getMovieByName(String name);

	@Query("SELECT mc FROM movie mc WHERE mc.isMovie = ?1")
	List<Movie> getAllMovie(String string);

	}