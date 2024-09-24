package com.example.voting_system.controller;

import com.example.voting_system.Entity.Candidate;
import com.example.voting_system.Entity.Voter;
import com.example.voting_system.Service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voting")
public class VotingController {

    @Autowired
    private VotingService votingService;

    @PostMapping("/register")
    public ResponseEntity<String> registerVoter(@RequestBody Voter voter) {
        votingService.registerVoter(voter);
        return ResponseEntity.ok("Voter registered successfully");
    }

    @PostMapping("/addCandidate")
    public ResponseEntity<String> addCandidate(@RequestBody Candidate candidate) {
        votingService.addCandidate(candidate);
        return ResponseEntity.ok("Candidate added successfully");
    }

    @PostMapping("/vote")
    public ResponseEntity<String> castVote(@RequestParam Long voterId, @RequestParam Long candidateId) {
        votingService.castVote(voterId, candidateId);
        return ResponseEntity.ok("Vote casted successfully");
    }

    @GetMapping("/candidates")
    public List<Candidate> getAllCandidates() {
        return votingService.getCandidates();
    }

    @GetMapping("/countVotes")
    public long countVotes(@RequestParam Long candidateId) {
        return votingService.countVotesForCandidate(candidateId);
    }
}
