package com.example.goalhub.Repositories;

import com.example.goalhub.Entity.LaLeague;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaLeagueRepository extends JpaRepository<LaLeague, Integer> {
}