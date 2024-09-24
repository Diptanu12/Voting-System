package com.example.voting_system.Repository;

import com.example.voting_system.Entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<Voter, Long> {}
