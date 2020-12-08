package com.mycompany.dvdStore.repository.memory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycompany.dvdStore.entity.Movie;
import com.mycompany.dvdStore.repository.MovieRepositoryInterface;

@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {
	public static List<Movie> movies = new ArrayList<>();
	
	public void add (Movie movie) {
	       movies.add(movie);
	       System.out.println("The movie "+movie.getTitle()+" has been added to memory.");
		
	}

}
