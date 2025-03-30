package com.chada.example.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

// Main response container
public class ApiResponse {
    private String get;
    private Map<String, String> parameters;
    private List<String> errors;
    private int results;
    private Paging paging;
    private List<ResponseItem> response;

    // Getters and setters
    public String getGet() {
        return get;
    }
    public void setGet(String get) {
        this.get = get;
    }
    public Map<String, String> getParameters() {
        return parameters;
    }
    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
    public List<String> getErrors() {
        return errors;
    }
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
    public int getResults() {
        return results;
    }
    public void setResults(int results) {
        this.results = results;
    }
    public Paging getPaging() {
        return paging;
    }
    public void setPaging(Paging paging) {
        this.paging = paging;
    }
    public List<ResponseItem> getResponse() {
        return response;
    }
    public void setResponse(List<ResponseItem> response) {
        this.response = response;
    }
}

class Paging {
    private int current;
    private int total;

    public int getCurrent() {
        return current;
    }
    public void setCurrent(int current) {
        this.current = current;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
}

class ResponseItem {
    private League league;
    private Country country;
    private List<Season> seasons;

    public League getLeague() {
        return league;
    }
    public void setLeague(League league) {
        this.league = league;
    }
    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }
    public List<Season> getSeasons() {
        return seasons;
    }
    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }
}

class League {
    private int id;
    private String name;
    private String type;
    private String logo;
    // New fields added based on the JSON response
    private String country;
    private String flag;
    private int season;
    // The standings is represented as a list of lists of Standing objects
    private List<List<Standing>> standings;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getLogo() {
        return logo;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getFlag() {
        return flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }
    public int getSeason() {
        return season;
    }
    public void setSeason(int season) {
        this.season = season;
    }
    public List<List<Standing>> getStandings() {
        return standings;
    }
    public void setStandings(List<List<Standing>> standings) {
        this.standings = standings;
    }
}

class Country {
    private String name;
    private String code;
    private String flag;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getFlag() {
        return flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }
}

class Season {
    private int year;
    private String start;
    private String end;
    private boolean current;
    private Coverage coverage;

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getStart() {
        return start;
    }
    public void setStart(String start) {
        this.start = start;
    }
    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }
    public boolean isCurrent() {
        return current;
    }
    public void setCurrent(boolean current) {
        this.current = current;
    }
    public Coverage getCoverage() {
        return coverage;
    }
    public void setCoverage(Coverage coverage) {
        this.coverage = coverage;
    }
}

class Coverage {
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

class Fixtures {
    private boolean events;
    private boolean lineups;
    private boolean statistics;
    private boolean players;

    public boolean isEvents() {
        return events;
    }
    public void setEvents(boolean events) {
        this.events = events;
    }
    public boolean isLineups() {
        return lineups;
    }
    public void setLineups(boolean lineups) {
        this.lineups = lineups;
    }
    public boolean isStatistics() {
        return statistics;
    }
    public void setStatistics(boolean statistics) {
        this.statistics = statistics;
    }
    public boolean isPlayers() {
        return players;
    }
    public void setPlayers(boolean players) {
        this.players = players;
    }
}

// New classes for the standings information

class Standing {
    private int rank;
    private Team team;
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

class Team {
    private int id;
    private String name;
    private String logo;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLogo() {
        return logo;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }
}

class Stats {
    private int played;
    private int win;
    private int draw;
    private int lose;
    private Goals goals;

    public int getPlayed() {
        return played;
    }
    public void setPlayed(int played) {
        this.played = played;
    }
    public int getWin() {
        return win;
    }
    public void setWin(int win) {
        this.win = win;
    }
    public int getDraw() {
        return draw;
    }
    public void setDraw(int draw) {
        this.draw = draw;
    }
    public int getLose() {
        return lose;
    }
    public void setLose(int lose) {
        this.lose = lose;
    }
    public Goals getGoals() {
        return goals;
    }
    public void setGoals(Goals goals) {
        this.goals = goals;
    }
}

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
