package com.mycompany.dvdStore.repository.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.mycompany.dvdStore.entity.Movie;
import com.mycompany.dvdStore.repository.MovieRepositoryInterface;

@Repository
public class FileMovieRepository implements MovieRepositoryInterface{
	//public static List<Movie> movies = new ArrayList<>();
	
	@Value("${movies.file.location}")
	private File file; 
	
	
	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}


	public void add (Movie movie) {
	      // movies.add(movie);
	       
	       FileWriter writer;
	       try{
	            writer=new FileWriter(file,true);           
	            writer.write(movie.getTitle() + " " + movie.getGenre() +"\n");
	           
	            writer.close();
	       }
	       catch (IOException e){
	            e.printStackTrace();
	       }
	       System.out.println("The movie "+movie.getTitle()+" has been added to file.");
	}

}
