package com.chada.example.data;

import jakarta.persistence.Embeddable;

@Embeddable
public class Goals {
    private int goalsFor;
    private int goalsAgainst;

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }
}
