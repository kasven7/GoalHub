package com.chada.example.client;
import jakarta.persistence.*;

@Entity
@Table(name = "Leagues")
public class Leagues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int year;
    private String name;
    private String country;
    private String logo;

    // Getters and Setters

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getLogo() { return logo; }
    public void setLogo(String logo) { this.logo = logo; }
}
