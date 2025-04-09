package com.chada.example.client;

import com.chada.example.dto.ApiResponse;
import com.chada.example.repositories.StandsRepository;
import com.chada.example.repositories.TeamRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class Client implements CommandLineRunner {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private StandsRepository standsRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {

        Integer[] ligi = new Integer[4];
        ligi[0] = 39;
        ligi[1] = 61;
        ligi[2] = 140;
        ligi[3] = 135;


        for (int i = 0; i < ligi.length; i++) {
            int leagueId = ligi[i];

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = (HttpRequest) HttpRequest.newBuilder()

                    .uri(URI.create(String.format(
                            "https://api-football-v1.p.rapidapi.com/v3/standings?league=%d&season=%d",
                            leagueId , 2024))
                        )

                    .header("x-rapidapi-key", "f95062b646msh501f47ec3b95547p129498jsnfcd363840490")
                    .header("x-rapidapi-host", "api-football-v1.p.rapidapi.com")
                    .GET()
                    .build();


            //.uri(URI.create("https://api-football-v1.p.rapidapi.com/v3/standings?league=&season=2024"))
            //.header("x-rapidapi-key", "f95062b646msh501f47ec3b95547p129498jsnfcd363840490")
            //.header("x-rapidapi-host", "api-football-v1.p.rapidapi.com")
            //.GET()
            //.build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String jsonResponse = response.body();

                // Use Jackson's ObjectMapper to deserialize the JSON into your Java model.
                ObjectMapper mapper = new ObjectMapper();
                ApiResponse apiResponse = mapper.readValue(jsonResponse, ApiResponse.class);

                if (apiResponse.getResponse() != null && !apiResponse.getResponse().isEmpty()) {
                    apiResponse.getResponse().forEach(Liga -> {

                        String checkIfExists =
                                "SELECT COUNT(*) FROM leagues WHERE name = ?";
                        Integer count = jdbcTemplate.queryForObject(checkIfExists, new Object[]{Liga.getLeague().getName()}, Integer.class);

                        if (count == null || count == 0) {

                            if (Liga.getLeague().getName() != null && Liga.getLeague().getLogo() != null) {
                                String type = Liga.getLeague().getType() != null ? Liga.getLeague().getType() : "default_type";

                                String insertLeague = "INSERT INTO leagues (name, type, logo) VALUES (?, ?, ?)";
                                jdbcTemplate.update(insertLeague,
                                        Liga.getLeague().getName(),
                                        Liga.getLeague().getType(),
                                        Liga.getLeague().getLogo());


                            }
                        }
                        });


        /*            apiResponse.getResponse().forEach(responses -> {
                        responses.getLeague().getStandings().forEach(standingList -> {
                            standingList.forEach(standing -> {
                                String checkIfExists = String.format(
                                        "SELECT COUNT(*) FROM standingsy_%d WHERE name = ?", leagueId);
                                Integer count = jdbcTemplate.queryForObject(checkIfExists, new Object[]{standing.getTeam().getName()}, Integer.class);

                                if (count == null || count == 0) {
                                    String insertStanding = String.format(

                                            "INSERT INTO standingsy_%d (name, points, goaldiff, form, win, draw, lose, played) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", leagueId);
                                    jdbcTemplate.update(insertStanding,
                                            standing.getTeam().getName(),
                                            standing.getPoints(),
                                            standing.getGoalsDiff(),
                                            standing.getForm(),
                                            standing.getAll().getWin(),
                                            standing.getAll().getDraw(),
                                            standing.getAll().getLose(),
                                            standing.getAll().getPlayed());
                                }
                            });
                        });
                    });*/


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
       // for (int leagueId : ligi) {
         //   String insertData = String.format(
           //         "INSERT INTO leagues (league_id, year, name, country, logo) " +
             //               "SELECT %d, year, name, country, logo FROM leagues_%d", leagueId, leagueId);
           // jdbcTemplate.execute(insertData);
       // }
    }
}

