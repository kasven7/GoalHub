package com.chada.example.model;

public class Standing {
    private int rank;
    public Team team;
    private int points;
    private int goalsDiff;
    private String group;
    private String form;
    private String status;
    private String description;
    private Stats all;
    private Stats home;
    private Stats away;
    private String update;  // ISO date string


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

    public Stats getAll() {
        return all;
    }

    public void setAll(Stats all) {
        this.all = all;
    }

    public Stats getHome() {
        return home;
    }

    public void setHome(Stats home) {
        this.home = home;
    }

    public Stats getAway() {
        return away;
    }

    public void setAway(Stats away) {
        this.away = away;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }
}
