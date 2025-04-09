package com.chada.example.repositories;

import com.chada.example.client.Standingsy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandsRepository extends JpaRepository<Standingsy, Long> {
}
