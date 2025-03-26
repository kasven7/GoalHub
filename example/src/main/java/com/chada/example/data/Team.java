package com.chada.example.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Team {
    @Id
    private int id;
    private String name;
    private String logo;

    public Team() {
    }

    public Team(int id, String name, String logo) {
        this.id = id;
        this.name = name;
        this.logo = logo;
    }
    // Gettery i settery

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
