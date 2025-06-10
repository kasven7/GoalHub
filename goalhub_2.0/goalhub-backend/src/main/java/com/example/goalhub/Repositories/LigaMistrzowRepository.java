package com.example.goalhub.Repositories;

import com.example.goalhub.Entity.LigaMistrzow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigaMistrzowRepository extends JpaRepository<LigaMistrzow, Integer> {
}