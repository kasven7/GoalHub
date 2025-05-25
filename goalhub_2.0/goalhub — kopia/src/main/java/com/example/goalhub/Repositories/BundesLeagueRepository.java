package com.example.goalhub.Repositories;

import com.example.goalhub.Entity.BundesLeague;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BundesLeagueRepository extends JpaRepository<BundesLeague, Integer> {
}