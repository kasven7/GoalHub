package com.example.goalhub.Repositories;

import com.example.goalhub.Entity.PremierLeague;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremierLeagueRepository extends JpaRepository<PremierLeague, Integer> {
}
