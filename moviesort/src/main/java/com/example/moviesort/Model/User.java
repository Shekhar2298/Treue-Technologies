package com.example.moviesort.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.print.DocFlavor.STRING;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String email;
    private String password;
    private String getGenrePreferences;
    private String getGenres;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", email=" + email + "]";
    }

    private String RatedMovies;
    private String Ratings;

    public String getRatedMovies() {
        return RatedMovies;
    }

    public void setRatedMovies(String ratedMovies) {
        RatedMovies = ratedMovies;
    }

    public void setRatings(String ratings) {
        Ratings = ratings;
    }

    public void setGenrePreferences(Set<Genre> genrePreferences) {
        this.genrePreferences = genrePreferences;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany
    @JoinTable(name = "user_genre_preference", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genrePreferences = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rating> ratings = new ArrayList<>();

    public void setGenrePreferences(List<Genre> preferences) {
    }

    public void setPreferredGenres(Set<Genre> preferredGenres) {
    }

    public String getGetGenrePreferences() {
        return getGenrePreferences;
    }

    public void setGetGenrePreferences(String getGenrePreferences) {
        this.getGenrePreferences = getGenrePreferences;
    }

    public String getGetGenres() {
        return getGenres;
    }

    public void setGetGenres(String getGenres) {
        this.getGenres = getGenres;
    }

    public Set<Genre> getGenrePreferences() {
        return genrePreferences;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    // public Set<Genre> getGenrePreferences() {
    // return null;
    // }

    // public Set<Genre> getGenres() {
    // return null;
    // }

}
