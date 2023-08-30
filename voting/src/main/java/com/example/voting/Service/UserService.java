package com.example.voting.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.voting.Model.User;
import com.example.voting.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    public List<User> findAvailableSpotslocation;

    public void AddAll(User u) {
        repo.save(u);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public List<User> Adding() {
        return repo.findAll();
    }


    // public User registerUser(String username, String password, String email)
    // throws Exception {
    // // Check if the username is already taken
    // if (userRepository.findAll() != null) {
    // throw new Exception("Username is already taken.");
    // }

    // User user = new User();
    // user.setUsername(username);
    // user.setPassword(password);
    // user.setEmail(email);

    // return userRepository.save(user);
    // }

}
