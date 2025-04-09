package com.chada.example.repositories;

import com.chada.example.client.Leagues;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Leagues, Long> {
}
