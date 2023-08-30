// package com.example.moviesort.Controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.moviesort.Model.Movie;
// import com.example.moviesort.Service.RecommendationService;

// @RestController
// @RequestMapping("/api/recommendations")
// public class RecommendationController {
//     @Autowired
//     private RecommendationService recommendationService;

//     @GetMapping("/collaborative")
//     public List<Movie> getCollaborativeRecommendations(@RequestParam Integer userId, @RequestParam int count) {
//         return recommendationService.getCollaborativeRecommendations(userId, count);
//     }

//     @GetMapping("/content-based")
//     public List<Movie> getContentBasedRecommendations(@RequestParam Integer movieId, @RequestParam int count) {
//         return recommendationService.getContentBasedRecommendations(movieId, count);
//     }
    
//     // Other recommendation-related endpoints
// }

