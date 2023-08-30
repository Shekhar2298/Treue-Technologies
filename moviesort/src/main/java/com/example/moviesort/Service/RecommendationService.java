package com.example.moviesort.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.moviesort.Model.Genre;
import com.example.moviesort.Model.Movie;
import com.example.moviesort.Model.User;
import com.example.moviesort.Repository.MovieRepository;

@Service
public class RecommendationService {

    @Autowired
    private MovieRepository movieRepository;

  
    // private String getUserPreferences(User user) {
    
    //     return user.getGetGenres();
    // }

    public List<Movie> getContentBasedRecommendations(Movie targetMovie, int count) {
        List<Genre> targetGenres = targetMovie.getGenres();
        List<Movie> allMovies = movieRepository.findAll();

        // Calculate scores for each movie based on genre overlap
        Map<Movie, Double> movieScores = new HashMap<>();
        
        for (Movie movie : allMovies) {
            Set<Genre> commonGenres = new HashSet<>(movie.getGenres());
            commonGenres.retainAll(targetGenres);
            double score = (double) commonGenres.size() / targetGenres.size(); // Simple overlap ratio
            movieScores.put(movie, score);
        }

        // Sort movies based on scores and return the top 'count' recommendations
        List<Movie> recommendedMovies = movieScores.entrySet().stream()
                .sorted(Map.Entry.<Movie, Double>comparingByValue(Comparator.reverseOrder()))
                .limit(count)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return recommendedMovies;
    }

   
    
   
    

    
//     public List<Movie> getCollaborativeFilteringRecommendations(User user, int count) {
//         List<Movie> recommendedMovies = new ArrayList<>();

     
//         return recommendedMovies;
//     }

   
//     public List<Movie> getHybridRecommendations(User user, int count) {
//         List<Movie> recommendedMovies = new ArrayList<>();

//         return recommendedMovies;
//     }

   
//     public List<Movie> getTopRatedMovies(int count) {
   
//         return movieRepository.findTopMoviesByAverageRating(count);
//     }

//     public List<Movie> getLatestMovies(int count) {
       
//         return movieRepository.findLatestMovies(count);
//     }

//     public List<Movie> getCollaborativeRecommendations(Integer userId, int count) {
//         return null;
//     }

//     public List<Movie> getContentBasedRecommendations(Integer movieId, int count) {
//         return null;
//     }
// }

    


}