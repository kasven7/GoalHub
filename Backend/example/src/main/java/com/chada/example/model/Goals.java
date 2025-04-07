package com.chada.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

class Goals {
    @JsonProperty("for")
    private int goalsFor;

    @JsonProperty("against")
    private int goalsAgainst;

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }
}
