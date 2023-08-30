package com.example.moviesort.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.moviesort.Model.Movie;
import com.example.moviesort.Model.Rating;
import com.example.moviesort.Model.User;
//import com.example.moviesort.Repository.MovieRepository;
import com.example.moviesort.Repository.UserRepository;

@Service
public class CollaborativeFilteringService {
    
    @Autowired
    private UserRepository userRepository;
    
    // @Autowired
    // private MovieRepository movieRepository;
    
    public List<Movie> getRecommendedMoviesForUser(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return new ArrayList<>(); // User not found
        }
        
        List<User> allUsers = userRepository.findAll();
        Map<Integer, Double> userSimilarities = new HashMap<>();
        
        // Calculate cosine similarity with other users
        for (User otherUser : allUsers) {
            if (!otherUser.getId().equals(userId)) {
                double similarity = calculateCosineSimilarity(user, otherUser);
                userSimilarities.put(otherUser.getId(), similarity);
            }
        }
        
        // Find top similar users
        List<Integer> similarUserIds = findTopSimilarUsers(userSimilarities, 5); // Get top 5 similar users
        
        Set<Movie> recommendedMovies = new HashSet<>();
        
        // Aggregate movies from similar users
        for (Integer similarUserId : similarUserIds) {
            User similarUser = userRepository.findById(similarUserId).orElse(null);
            if (similarUser != null) {
                recommendedMovies.addAll(similarUser.getRatedMovies());
            }
        }
        
        // Remove movies already rated by the user
        recommendedMovies.removeAll(user.getRatedMovies());
        
        return new ArrayList<>(recommendedMovies);
    }
    
    private double calculateCosineSimilarity(User user1, User user2) {
    // Get the list of ratings for each user
    List<Rating> user1Ratings = user1.getRatings();
    List<Rating> user2Ratings = user2.getRatings();

    // Create vectors for user ratings
    Map<Integer, Integer> user1Vector = new HashMap<>();
    Map<Integer, Integer> user2Vector = new HashMap<>();

    // Populate user vectors based on their rated movies
    for (Rating rating : user1Ratings) {
        user1Vector.put(rating.getMovie().getId(), rating.getscore());
    }

    for (Rating rating : user2Ratings) {
        user2Vector.put(rating.getMovie().getId(), rating.getscore());
    }

    // Calculate dot product
    double dotProduct = 0.0;
    for (Integer movieId : user1Vector.keySet()) {
        if (user2Vector.containsKey(movieId)) {
            dotProduct += user1Vector.get(movieId) * user2Vector.get(movieId);
        }
    }

    // Calculate magnitudes
    double user1Magnitude = Math.sqrt(user1Vector.values().stream()
            .mapToDouble(score -> score * score)
            .sum());

    double user2Magnitude = Math.sqrt(user2Vector.values().stream()
            .mapToDouble(score -> score * score)
            .sum());

    // Calculate cosine similarity
    if (user1Magnitude == 0 || user2Magnitude == 0) {
        return 0.0; // Avoid division by zero
    } else {
        return dotProduct / (user1Magnitude * user2Magnitude);
    }
}

    
    private List<Integer> findTopSimilarUsers(Map<Integer, Double> userSimilarities, int count) {
    List<Integer> topSimilarUsers = userSimilarities.entrySet().stream()
            .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
            .limit(count)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

    return topSimilarUsers;
    
}

    public List<Movie> getRecommendations(Integer userId, int count) {
        return null;
    }

}

