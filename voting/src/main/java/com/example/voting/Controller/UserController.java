package com.example.voting.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.voting.Model.User;
import com.example.voting.Service.UserService;

@Controller
public class UserController {

@Autowired
UserService voteserv;


    @GetMapping("/register")
    public String showRegistrationForm() {
        return "index";
    }

    @GetMapping("/database")
    public String Home(Model model) {
        List<User> us =  voteserv.Adding();
        model.addAttribute("data", us);
        return "Database";
    }

    @PostMapping("/park")
    public String Park(@ModelAttribute User use, Model model) {
        voteserv.AddAll(use);
        return "vote";
    }
   @GetMapping("/sign")
   public String Sign(){
    return "login";
   }

    // @PostMapping("/register")
    // public String registerUser(
    // @RequestParam Integer id,
    // @RequestParam String username,
    // @RequestParam String password,
    // @RequestParam String email,
    // Model model) {
    // // Check if the username already exists
    // if (userRepository.findById(id) != null) {
    // model.addAttribute("error", "Username already exists");
    // return "index"; // Show the registration form again with an error message
    // }

    // User user = new User();
    // user.setUsername(username);
    // user.setPassword(password);
    // user.setEmail(email);

    // userRepository.save(user);

    // return "redirect:/login"; // Redirect to login page after successful
    // registration
    // }
}
