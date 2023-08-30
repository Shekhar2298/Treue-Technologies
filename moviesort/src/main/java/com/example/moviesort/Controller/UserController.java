package com.example.moviesort.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.moviesort.Model.Genre;
import com.example.moviesort.Model.Movie;
import com.example.moviesort.Model.Rating;
import com.example.moviesort.Model.User;
import com.example.moviesort.Repository.GenreRepository;
import com.example.moviesort.Repository.MovieRepository;
import com.example.moviesort.Repository.UserRepository;
import com.example.moviesort.Service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
@Autowired
UserRepository userRepository;
@Autowired
MovieRepository movieRepository;
@Autowired
GenreRepository genreRepository;
    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user/list"; 
    }

    @GetMapping("/{id}")
    public String viewUser(@PathVariable Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user/view"; 
    }


    @PostMapping("/{userId}/update-preferred-genres")
    public ResponseEntity<String> updatePreferredGenres(@PathVariable Integer userId, @RequestBody Set<Integer> preferredGenreIds) {
        userService.updatePreferredGenres(userId, preferredGenreIds);
        return ResponseEntity.ok("Preferred genres updated successfully.");
    }
    
@RequestMapping("/api/user")


    @PostMapping("/{userId}/rate/{movieId}")
    public Rating rateMovie(@PathVariable Integer userId, @PathVariable Integer movieId, @RequestParam int score) {
        User user = userRepository.findById(userId).orElse(null);
        Movie movie = movieRepository.findById(movieId).orElse(null);
        
        if (user != null && movie != null) {
            return userService.rateMovie(user, movie, score);
        } else {
          
            return null;
        }
    }

    @PostMapping("/{userId}/updatePreferences")
    public ResponseEntity<String> updatePreferences(@PathVariable Integer userId, @RequestBody Set<Integer> genreIds) {
        User user = userRepository.findById(userId).orElse(null);
        
        if (user != null) {
            List<Genre> preferences = genreRepository.findAllById(genreIds);
            userService.updateGenrePreferences(user, preferences);
            return ResponseEntity.ok("Preferences updated successfully.");
        } else {
            
            return ResponseEntity.badRequest().body("User not found.");
        }
    }

    
}

