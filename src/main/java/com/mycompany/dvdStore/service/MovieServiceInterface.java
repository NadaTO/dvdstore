package com.mycompany.dvdStore.service;

import com.mycompany.dvdStore.entity.Movie;

import java.util.List;

public interface MovieServiceInterface {
	public void registerMovie(Movie movie) ;
	public List<Movie> getMovieList();
	public Movie getMovieById(long id);
}
