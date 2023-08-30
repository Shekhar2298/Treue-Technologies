package com.example.voting.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.voting.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

  
   

}
