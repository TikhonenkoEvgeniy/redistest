package com.example.redistest.controller;

import com.example.redistest.model.Movie;
import com.example.redistest.repository.MovieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MainController {
    private final MovieRepo movieRepo;

    @GetMapping("/keys")
    public @ResponseBody Map<Object, Object> keys() {
        return movieRepo.findAllMovies();
    }

    @GetMapping("/values")
    public @ResponseBody Map<String, String> findAll() {
        Map<Object, Object> allMovies = movieRepo.findAllMovies();
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<Object, Object> entry : allMovies.entrySet()) {
            String key = (String) entry.getKey();
            map.put(key, allMovies.get(key).toString());
        }
        return map;
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestParam Long key, @RequestParam String value) {
        movieRepo.add(new Movie(key, value));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{key}")
    public ResponseEntity<String> delete(@PathVariable String key) {
        movieRepo.delete(key);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
