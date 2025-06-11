package com.example.goalhub.Repositories;

import com.example.goalhub.Entity.SerieA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieARepository extends JpaRepository<SerieA, Integer> {
}