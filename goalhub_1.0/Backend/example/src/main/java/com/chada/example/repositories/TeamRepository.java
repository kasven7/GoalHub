package com.chada.example.repositories;

import com.chada.example.api.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TeamRepository extends JpaRepository<League, Long> {
}
