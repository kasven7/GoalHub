package com.chada.example.model;

import java.util.List;

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
