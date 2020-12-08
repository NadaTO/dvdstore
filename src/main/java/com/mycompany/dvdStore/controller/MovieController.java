package com.mycompany.dvdStore.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mycompany.dvdStore.entity.Movie;
import com.mycompany.dvdStore.service.MovieServiceInterface;

@Controller
public class MovieController {
	
	@Autowired
	private MovieServiceInterface movieService;
	
	
	public MovieServiceInterface getMovieService() {
		return movieService;
	}


	public void setMovieService(MovieServiceInterface movieService) {
		this.movieService = movieService;
	}


	public void addUsingConsole() {
		System.out.println( "What is film title ?" );
        Scanner sc = new  Scanner(System.in); 
        String filmTitle =sc.nextLine();
        System.out.println( "What is film genre ?" );
        String filmGenre =sc.nextLine();
        Movie movie= new Movie();
        movie.setGenre(filmGenre);
        movie.setTitle(filmTitle);       
        movieService.registerMovie(movie);
	}

}
