package com.example.moviesort.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.moviesort.Model.Genre;
import com.example.moviesort.Service.GenreService;

@Controller
@RequestMapping("/genres")
public class GenreController {
    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }
@Autowired
GenreService GenreServ;
    @GetMapping
    public String listGenres(Model model) {
        List<Genre> genres = genreService.getAllGenres();
        model.addAttribute("genres", genres);
        return "genre/list"; 
    }

    @GetMapping("/{id}")
    public String viewGenre(@PathVariable int id, Model model) {
        Genre genre = GenreServ.getGenreById(id);
        model.addAttribute("genre", genre);
        return "genre/view"; 
    }


}
