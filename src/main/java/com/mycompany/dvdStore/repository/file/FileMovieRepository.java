package com.mycompany.dvdStore.repository.file;

import java.io.*;
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


	@Override
	public List<Movie> list() {

		List<Movie> movies=new ArrayList<>();

		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			for(String line; (line = br.readLine()) != null; ) {
				final Movie movie=new Movie();
				final String[] titreEtGenre = line.split("\\W+");
				movie.setId(Long.parseLong(titreEtGenre[0]));
				movie.setTitle(titreEtGenre[1]);
				movie.setGenre(titreEtGenre[2]);
				movies.add(movie);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return movies;
	}

	@Override
	public Movie getById(long id) {
		final Movie movie = new Movie();
		movie.setId(id);
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			for(String line; (line = br.readLine()) != null; ) {

				final String[] allProperties = line.split("\\;");
				final long nextMovieId=Long.parseLong(allProperties[0]);
				if (nextMovieId==id) {
					movie.setTitle(allProperties[1]);
					movie.setGenre(allProperties[2]);
					movie.setDescription(allProperties[3]);
					return movie;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.err.println("A movie from the file does not have a proper id");
			e.printStackTrace();
		}
		movie.setTitle("UNKNOWN");
		movie.setGenre("UNKNOWN");
		movie.setDescription("UNKNOWN");
		return movie;
	}

}
