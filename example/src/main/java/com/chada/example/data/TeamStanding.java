package com.chada.example.data;

import jakarta.persistence.*;

@Entity
public class TeamStanding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rank;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    private int points;
    private int goalsDiff;
    private String group;
    private String form;
    private String status;
    private String description;
    private String update;

    @ManyToOne
    @JoinColumn(name = "standing_id")
    private Standing standing;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "played", column = @Column(name = "all_played")),
            @AttributeOverride(name = "win", column = @Column(name = "all_win")),
            @AttributeOverride(name = "draw", column = @Column(name = "all_draw")),
            @AttributeOverride(name = "lose", column = @Column(name = "all_lose")),
            @AttributeOverride(name = "goals.goalsFor", column = @Column(name = "all_goals_for")),
            @AttributeOverride(name = "goals.goalsAgainst", column = @Column(name = "all_goals_against"))
    })
    private Games allGames;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "played", column = @Column(name = "home_played")),
            @AttributeOverride(name = "win", column = @Column(name = "home_win")),
            @AttributeOverride(name = "draw", column = @Column(name = "home_draw")),
            @AttributeOverride(name = "lose", column = @Column(name = "home_lose")),
            @AttributeOverride(name = "goals.goalsFor", column = @Column(name = "home_goals_for")),
            @AttributeOverride(name = "goals.goalsAgainst", column = @Column(name = "home_goals_against"))
    })
    private Games homeGames;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "played", column = @Column(name = "away_played")),
            @AttributeOverride(name = "win", column = @Column(name = "away_win")),
            @AttributeOverride(name = "draw", column = @Column(name = "away_draw")),
            @AttributeOverride(name = "lose", column = @Column(name = "away_lose")),
            @AttributeOverride(name = "goals.goalsFor", column = @Column(name = "away_goals_for")),
            @AttributeOverride(name = "goals.goalsAgainst", column = @Column(name = "away_goals_against"))
    })
    private Games awayGames;


}
