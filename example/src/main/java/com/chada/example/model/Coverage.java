package com.chada.example.model;

import com.chada.example.model.Fixtures;

public class Coverage {
    private Fixtures fixtures;
    private boolean standings;
    private boolean players;
    private boolean top_scorers;
    private boolean top_assists;
    private boolean top_cards;
    private boolean injuries;
    private boolean predictions;
    private boolean odds;

    public Fixtures getFixtures() {
        return fixtures;
    }

    public void setFixtures(Fixtures fixtures) {
        this.fixtures = fixtures;
    }

    public boolean isStandings() {
        return standings;
    }

    public void setStandings(boolean standings) {
        this.standings = standings;
    }

    public boolean isPlayers() {
        return players;
    }

    public void setPlayers(boolean players) {
        this.players = players;
    }

    public boolean isTop_scorers() {
        return top_scorers;
    }

    public void setTop_scorers(boolean top_scorers) {
        this.top_scorers = top_scorers;
    }

    public boolean isTop_assists() {
        return top_assists;
    }

    public void setTop_assists(boolean top_assists) {
        this.top_assists = top_assists;
    }

    public boolean isTop_cards() {
        return top_cards;
    }

    public void setTop_cards(boolean top_cards) {
        this.top_cards = top_cards;
    }

    public boolean isInjuries() {
        return injuries;
    }

    public void setInjuries(boolean injuries) {
        this.injuries = injuries;
    }

    public boolean isPredictions() {
        return predictions;
    }

    public void setPredictions(boolean predictions) {
        this.predictions = predictions;
    }

    public boolean isOdds() {
        return odds;
    }

    public void setOdds(boolean odds) {
        this.odds = odds;
    }
}
