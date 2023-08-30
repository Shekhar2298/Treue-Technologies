package com.example.moviesort.Service;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.moviesort.Model.Genre;
import com.example.moviesort.Model.Movie;
import com.example.moviesort.Repository.GenreRepository;
import com.example.moviesort.Repository.MovieRepository;
@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Autowired
    GenreRepository genreRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Integer id) {
        return movieRepository.findById(id).orElse(null);
    }

    public List<Movie> getMoviesByGenre(Genre genre) {
        return movieRepository.findByGenresContains(genre);
    }

    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }


    public List<Movie> filterMoviesByGenre(Integer genreId) {
        Genre genre = genreRepository.findById(genreId).orElse(null);
        if (genre != null) {
            return movieRepository.findByGenresContains(genre);
        } else {
            return Collections.emptyList();
        }
    }
    public List<Movie> searchMovies(String keyword) {
     
        return movieRepository.findBy(keyword, keyword);
    }
}

    
   


