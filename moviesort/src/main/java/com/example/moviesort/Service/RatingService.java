package com.example.moviesort.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.moviesort.Model.Movie;
import com.example.moviesort.Model.Rating;
import com.example.moviesort.Repository.RatingRepository;
@Service
public class RatingService {
    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<Rating> getRatingsForMovie(Movie movie) {
        return ratingRepository.findByMovie(movie);
    }

    public void saveRating(Rating rating) {
        ratingRepository.save(rating);
    }

    // Other methods related to rating operations
}

