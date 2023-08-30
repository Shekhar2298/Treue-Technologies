package com.example.moviesort.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.moviesort.Model.Movie;
import com.example.moviesort.Model.Rating;
import com.example.moviesort.Model.User;
import com.example.moviesort.Service.MovieService;
import com.example.moviesort.Service.RatingService;
import com.example.moviesort.Service.UserService;

@Controller
@RequestMapping("/ratings")
public class RatingController {
    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }
    @Autowired
    UserService useserv;
    @Autowired
    MovieService movieServ;


    @PostMapping("/submit")
    public String submitRating(@RequestParam Integer userId, @RequestParam Integer movieId, @RequestParam Integer rating) {
        User user = useserv.getUserById(userId);
        Movie movie = movieServ.getMovieById(movieId);

        Rating newRating = new Rating();
        newRating.setUser(user);
        newRating.setMovie(movie);
        newRating.setRating(rating);

        ratingService.saveRating(newRating);

        return "redirect:/movies/" + movieId; // Redirect to movie details page
    }

    // Other methods for handling rating-related requests
}

