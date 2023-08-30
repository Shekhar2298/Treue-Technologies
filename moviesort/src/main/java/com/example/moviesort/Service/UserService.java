package com.example.moviesort.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.moviesort.Model.Feedback;
import com.example.moviesort.Model.Genre;
import com.example.moviesort.Model.Movie;
import com.example.moviesort.Model.Rating;
import com.example.moviesort.Model.User;
import com.example.moviesort.Repository.UserRepository;
import com.example.moviesort.Repository.FeedbackRepository;
import com.example.moviesort.Repository.GenreRepository;

import jakarta.transaction.Transactional;
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    FeedbackRepository feedrepo;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

   
    @Transactional
    public Rating rateMovie(User user, Movie movie, int score) {
        Rating rating = new Rating();
        rating.setUser(user);
        rating.setMovie(movie);
        rating.stscore(score);
        userRepository.save(rating);
        return rating;
    }

    @Transactional
    public void updateGenrePreferences(User user, List<Genre> preferences) {
        user.setGenrePreferences(preferences);
        userRepository.save(user);
    }

   
    public void submitFeedback(User user, Movie movie, String comments) {
        Feedback feedback = new Feedback();
        feedback.setUser(user);
        feedback.setMovie(movie);
        feedback.setComments(comments);

        feedrepo.save(feedback);
    }
     
    @Autowired
    private GenreRepository genreRepository;

    public void updatePreferredGenres(Integer userId, Set<Integer> preferredGenreIds) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            // Handle user not found
            return;
        }

        Set<Genre> preferredGenres = genreRepository.findById(preferredGenreIds);
        user.setPreferredGenres(preferredGenres);

        userRepository.save(user);
    }



    public Map<Genre, Double> calculateGenrePreference(User user) {
        Map<Genre, Double> genrePreferenceScores = new HashMap<>();

        Set<Genre> userGenrePreferences = user.getGenrePreferences();
        int totalGenres = userGenrePreferences.size();

        for (Genre genre : userGenrePreferences) {
            double score = 1.0 / totalGenres; // Equal score for each genre
            genrePreferenceScores.put(genre, score);
        }

        return genrePreferenceScores;
    }
}







