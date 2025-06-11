package com.example.goalhub.Repositories;

import com.example.goalhub.Entity.Mecze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeczRepository extends JpaRepository<Mecze, Long> {
    List<Mecze> findByLeagueIgnoreCaseOrderByMatchDateAsc(String league);
}
