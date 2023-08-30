package com.example.voting.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.voting.Model.UserVote;
import com.example.voting.Repository.voteRepository;

@Service
public class voteService {

    @Autowired
    private voteRepository VoteRepo;

    public void Adddata(UserVote us) {
        VoteRepo.save(us);
    }

    public List<UserVote> Addingvote() {
        return VoteRepo.findAll();
    }

    // @Autowired
    // private voteRepository voteRepo;

    // public void AddAlldata(UserVote u) {
    // voteRepo.save(u);
    // }

    // public List<UserVote> Addingdata() {
    // return voteRepo.findAll();
    // }
}
