package com.chada.example.client;
import jakarta.persistence.*;

@Entity
@Table(name = "teams")
class Teamy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String logo;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getLogo() { return logo; }
    public void setLogo(String logo) { this.logo = logo; }
}
