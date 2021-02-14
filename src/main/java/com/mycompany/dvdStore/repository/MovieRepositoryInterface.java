package com.mycompany.dvdStore.repository;

import com.mycompany.dvdStore.entity.Movie;

import java.util.List;

public interface MovieRepositoryInterface {
  public void add(Movie movie);
  public List<Movie> list();
  public Movie getById(long id);
}
