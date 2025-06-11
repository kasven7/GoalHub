package com.chada.example.repositories;

import com.chada.example.api.Standingsy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface StandsRepository extends JpaRepository<Standingsy, Long> {
}
