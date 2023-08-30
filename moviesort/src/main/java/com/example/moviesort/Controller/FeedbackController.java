package com.example.moviesort.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.moviesort.Model.Movie;
import com.example.moviesort.Model.User;
import com.example.moviesort.Repository.MovieRepository;
import com.example.moviesort.Repository.UserRepository;
import com.example.moviesort.Service.UserService;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    @Autowired
    private UserService userService;
@Autowired
UserRepository userRepository;
@Autowired
MovieRepository movieRepository;
    @PostMapping("/submit")
    public ResponseEntity<String> submitFeedback(
            @RequestParam Integer userId,
            @RequestParam Integer movieId,
            @RequestParam String comments) {
        User user = userRepository.findById(userId).orElse(null);
        Movie movie = movieRepository.findById(movieId).orElse(null);

        if (user == null || movie == null) {
            return ResponseEntity.badRequest().body("User or movie not found.");
        }

        userService.submitFeedback(user, movie, comments);
        return ResponseEntity.ok("Feedback submitted successfully.");
    }
}
