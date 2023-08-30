package com.example.moviesort.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moviesort.Model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    
}

