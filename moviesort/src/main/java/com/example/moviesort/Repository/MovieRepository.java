package com.example.moviesort.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.moviesort.Model.Genre;
import com.example.moviesort.Model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findByGenresContains(Genre genre);

    List<Movie> findBy(String keyword, String keyword2);

    List<Movie> findTopMoviesByAverageRating(int count);

    List<Movie> findLatestMovies(int count);
   
    // List<Movie> findByAll(String titleKeyword, String actorKeyword, String directorKeyword);
}

