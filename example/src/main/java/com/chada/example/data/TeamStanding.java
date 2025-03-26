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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoalsDiff() {
        return goalsDiff;
    }

    public void setGoalsDiff(int goalsDiff) {
        this.goalsDiff = goalsDiff;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public Standing getStanding() {
        return standing;
    }

    public void setStanding(Standing standing) {
        this.standing = standing;
    }

    public Games getAllGames() {
        return allGames;
    }

    public void setAllGames(Games allGames) {
        this.allGames = allGames;
    }

    public Games getHomeGames() {
        return homeGames;
    }

    public void setHomeGames(Games homeGames) {
        this.homeGames = homeGames;
    }

    public Games getAwayGames() {
        return awayGames;
    }

    public void setAwayGames(Games awayGames) {
        this.awayGames = awayGames;
    }
}
