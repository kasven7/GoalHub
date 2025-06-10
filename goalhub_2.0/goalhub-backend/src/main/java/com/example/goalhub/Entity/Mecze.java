package com.example.goalhub.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "matches", schema = "fotmob")
public class Mecze {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String league;
    private String team1;
    private String team2;
    private int team1_Goals;
    private int team2_Goals;
    private LocalDate matchDate;
}