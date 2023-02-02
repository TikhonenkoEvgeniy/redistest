package com.example.redistest.repository;

import com.example.redistest.model.Movie;

import java.util.Map;

public interface MovieRepo {
    Map<Object, Object> findAllMovies();
    void add(Movie movie);
    void delete(String id);
    Movie findMovie(String id);
}
