package com.example.moviesort.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.moviesort.Model.Genre;
import com.example.moviesort.Model.Movie;
import com.example.moviesort.Service.GenreService;
import com.example.moviesort.Service.MovieService;

@Controller
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
   

    @Autowired
    public MovieController(MovieService movieService, GenreService genreService) {
        this.movieService = movieService;
       
    }
    @Autowired
    MovieService movieServ;
    @Autowired
    GenreService GenreServ;

    @GetMapping
    public String listMovies(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "movie/list"; // Thymeleaf template name
    }

    @GetMapping("/{id}")
    public String viewMovie(@PathVariable int id, Model model) {
        Movie movie = movieServ.getMovieById(id);
        model.addAttribute("movie", movie);
        return "movie/view"; // Thymeleaf template name
    }

    @GetMapping("/byGenre/{genreId}")
    public String listMoviesByGenre(@PathVariable int genreId, Model model) {
        Genre genre = GenreServ.getGenreById(genreId);
        List<Movie> movies = movieService.getMoviesByGenre(genre);
        model.addAttribute("movies", movies);
        return "movie/list"; // Thymeleaf template name
    }

 
  

    @GetMapping("/search")
    public List<Movie> searchMovies(@RequestParam String keyword) {
        return movieService.searchMovies(keyword);
    }

   
      
    
        @GetMapping("/filterByGenre")
        public List<Movie> filterMoviesByGenre(@RequestParam Integer genreId) {
            return movieService.filterMoviesByGenre(genreId);
        }
    
     
            @GetMapping("/search")
            public String searchMovies(@RequestParam String keyword, Model model) {
                List<Movie> searchResults = movieService.searchMovies(keyword);
                model.addAttribute("searchResults", searchResults);
                return "index"; 
            }
        
            @GetMapping("/filter")
            public String filterMoviesByGenre(@RequestParam Integer genreId, Model model) {
                List<Movie> filteredMovies = movieService.filterMoviesByGenre(genreId);
                model.addAttribute("filteredMovies", filteredMovies);
                return "index"; 
            }
        
       
    
    

}
