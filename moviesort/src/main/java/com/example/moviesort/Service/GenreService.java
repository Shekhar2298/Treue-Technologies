package com.example.moviesort.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.moviesort.Model.Genre;
import com.example.moviesort.Repository.GenreRepository;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Genre getGenreById(Integer id) {
        return genreRepository.findById(id).orElse(null);
    }

    public void saveGenre(Genre genre) {
        genreRepository.save(genre);
    }

    // Other methods related to genre operations
}
