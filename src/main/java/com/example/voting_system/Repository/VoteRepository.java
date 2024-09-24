package com.example.voting_system.Repository;

import com.example.voting_system.Entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
public interface VoteRepository extends JpaRepository<Vote, Long> {

    // Custom method to count votes for a specific candidate
    long countByCandidateId(Long candidateId);
}
