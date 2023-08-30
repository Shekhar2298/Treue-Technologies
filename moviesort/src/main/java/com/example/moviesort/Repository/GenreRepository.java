package com.example.moviesort.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.moviesort.Model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {

    List<Genre> findByNameIn(List<String> asList);

    Set<Genre> findById(Set<Integer> preferredGenreIds);

}
