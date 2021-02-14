package com.mycompany.dvdStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.dvdStore.entity.Movie;
import com.mycompany.dvdStore.repository.MovieRepositoryInterface;
import java.util.List;

@Service
public class DefaultMovieService implements MovieServiceInterface {
	
	@Autowired
	MovieRepositoryInterface movieRepository ;
	
	public MovieRepositoryInterface getMovieRepository() {
		return movieRepository;
	}

	public void setMovieRepository(MovieRepositoryInterface movieRepository) {
		this.movieRepository = movieRepository;
	}

	public void registerMovie(Movie movie) {
		movieRepository.add(movie);
	}

	@Override
	public List<Movie> getMovieList(){
		return movieRepository.list();
	}

	@Override
	public Movie getMovieById(long id){
		return movieRepository.getById(id);
	}

}
