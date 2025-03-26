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


}
