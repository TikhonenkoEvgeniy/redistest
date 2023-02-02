package com.example.redistest.repository.impl;

import com.example.redistest.model.Movie;
import com.example.redistest.repository.MovieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@RequiredArgsConstructor
public class MovieRepoImpl implements MovieRepo {
    private static final String KEY = "Movie";
    private final RedisTemplate<Object, Object> redisTemplate;

    @Override
    public Map<Object, Object> findAllMovies() {
        return redisTemplate.opsForHash().entries(KEY);
    }

    @Override
    public void add(Movie movie) {
        redisTemplate.opsForHash().put(KEY, movie.getId(), movie.getName());
    }

    @Override
    public void delete(String id) {
        redisTemplate.opsForHash().delete(KEY, id);
    }

    @Override
    public Movie findMovie(String id) {
        return (Movie) redisTemplate.opsForHash().get(KEY, id);
    }
}
