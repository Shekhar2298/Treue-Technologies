package com.example.moviesort.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.moviesort.Model.Movie;
import com.example.moviesort.Model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

    List<Rating> findByMovie(Movie movie);
    // Custom query methods can be added here if needed
}
