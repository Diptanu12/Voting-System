package com.example.voting_system.Service;

import com.example.voting_system.Entity.Candidate;
import com.example.voting_system.Entity.Vote;
import com.example.voting_system.Entity.Voter;
import com.example.voting_system.Repository.CandidateRepository;
import com.example.voting_system.Repository.VoteRepository;
import com.example.voting_system.Repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotingService {

    @Autowired
    private VoterRepository voterRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private VoteRepository voteRepository;

    public List<Candidate> getCandidates() {
        return candidateRepository.findAll();
    }

    public void registerVoter(Voter voter) {
        voterRepository.save(voter);
    }

    public void addCandidate(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    public void castVote(Long voterId, Long candidateId) {
        Voter voter = voterRepository.findById(voterId).orElseThrow();
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow();
        Vote vote = new Vote();
        vote.setVoter(voter);
        vote.setCandidate(candidate);
        voteRepository.save(vote);
    }

    public long countVotesForCandidate(Long candidateId) {
        return voteRepository.countByCandidateId(candidateId);
    }
}

