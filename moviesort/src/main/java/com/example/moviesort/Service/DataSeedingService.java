package com.example.moviesort.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.moviesort.Model.Genre;
import com.example.moviesort.Model.Movie;
import com.example.moviesort.Repository.GenreRepository;
import com.example.moviesort.Repository.MovieRepository;

import jakarta.transaction.Transactional;

@Service
public class DataSeedingService {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Transactional
    public void seedData() {
        seedGenres();
        seedMovies();
    }

    private void seedGenres() {
        List<Genre> genres = new ArrayList<>();
        genres.add(new Genre("Action"));
        genres.add(new Genre("Comedy"));
        genres.add(new Genre("Drama"));
       
        
        genreRepository.saveAll(genres);
    }

    private void seedMovies() {
     
        List<Genre> actionAndComedyGenres = genreRepository.findByNameIn(Arrays.asList("Action", "Comedy"));

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Movie 1", "Director 1", actionAndComedyGenres));
        movies.add(new Movie("Movie 2", "Director 2", actionAndComedyGenres));
         movies.add(new Movie("Movie 3", "Director 1", actionAndComedyGenres));
        movies.add(new Movie("Movie 4", "Director 2", actionAndComedyGenres));
         movies.add(new Movie("Movie 5", "Director 1", actionAndComedyGenres));
        movies.add(new Movie("Movie 6", "Director 2", actionAndComedyGenres));
         movies.add(new Movie("Movie 7", "Director 1", actionAndComedyGenres));
        movies.add(new Movie("Movie 7", "Director 2", actionAndComedyGenres));
         movies.add(new Movie("Movie 8", "Director 1", actionAndComedyGenres));
        movies.add(new Movie("Movie 9", "Director 2", actionAndComedyGenres));
         movies.add(new Movie("Movie 10", "Director 1", actionAndComedyGenres));
        movies.add(new Movie("Movie 11", "Director 2", actionAndComedyGenres));
        
        
        movieRepository.saveAll(movies);
    }
}

