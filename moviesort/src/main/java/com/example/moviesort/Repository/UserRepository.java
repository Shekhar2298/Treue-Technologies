package com.example.moviesort.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.moviesort.Model.Rating;
import com.example.moviesort.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    void save(Rating rating);

   
    
}
