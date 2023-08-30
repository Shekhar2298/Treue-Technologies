package com.example.voting.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.voting.Model.UserVote;
import com.example.voting.Repository.voteRepository;
import com.example.voting.Service.voteService;

@Controller
public class voteController {

@Autowired
voteService voteserv;



    @Autowired
    voteRepository voteRepo;

    @GetMapping("/votedatabase")
    public String HomeVote(Model model) {
        List<UserVote> u=voteserv.Addingvote();
        model.addAttribute("data", u);
        return "VoteDatabase";
    }

    @PostMapping("/thank")
    public String Voting(@ModelAttribute UserVote use, Model model) {
        voteserv.Adddata(use);
        return "vote";
    }
    @GetMapping("/voting")
    public String Vote(){
        return "vote";
    }
}
