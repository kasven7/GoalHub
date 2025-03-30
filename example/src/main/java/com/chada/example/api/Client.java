package com.chada.example.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.chada.example.data.League;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
@Entity
@Table(name = "standingsy")
class Standingsy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer points;
    private Integer goaldiff;
    private Integer form;


    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public Integer getPoints() {return points;}
    public void setPoints(Integer points) {this.points = points;}
    public Integer getGoaldiff() {return goaldiff;}
    public void setGoaldiff(Integer goaldiff) {this.goaldiff = goaldiff;}
    public Integer getForm() {return form;}
    public void setForm(Integer form) {this.form = form;}
}

@Repository
interface TeamRepository extends JpaRepository<League, Long> {}

/*@Repository
interface StandsRepository extends JpaRepository<Team, Long> {}*/

@Component
public class Client implements CommandLineRunner {

    @Autowired
    private TeamRepository teamRepository;

/*
   @Autowired
    private StandsRepository standsRepository;
*/

    @Override
    public void run(String... args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api-football-v1.p.rapidapi.com/v3/standings?league=39&season=2020"))
                .header("x-rapidapi-key", "f95062b646msh501f47ec3b95547p129498jsnfcd363840490")
                .header("x-rapidapi-host", "api-football-v1.p.rapidapi.com")
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonResponse = response.body();

            // Use Jackson's ObjectMapper to deserialize the JSON into your Java model.
            ObjectMapper mapper = new ObjectMapper();
            ApiResponse apiResponse = mapper.readValue(jsonResponse, ApiResponse.class);

            if (apiResponse.getResponse() != null && !apiResponse.getResponse().isEmpty()) {
                apiResponse.getResponse().forEach(Liga -> {
                    League league = new League();
                    league.setName(Liga.getLeague().getName());
                    league.setCountry(Liga.getLeague().getCountry());
                    league.setLogo(Liga.getLeague().getLogo());
                    teamRepository.save(league);
                });
                /*apiResponse.getResponse().forEach(Standing -> {
                    Standing stand = new Standing();
                    stand.setTeam(Standing.getLeague().getStandings());
                    team.setLogo(team.getLogo());
                    team.setId(team.getId());
                    standsRepository.save(team);
                });*/

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}