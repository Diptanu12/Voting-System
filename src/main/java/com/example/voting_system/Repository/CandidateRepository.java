package com.example.voting_system.Repository;

import com.example.voting_system.Entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {}
