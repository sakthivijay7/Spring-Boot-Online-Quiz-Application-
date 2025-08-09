package com.onlineassesment.onlineassesment.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineassesment.onlineassesment.Model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Long>
{
   Optional<Candidate> findByEmail(String email);

   void save(int score);
}