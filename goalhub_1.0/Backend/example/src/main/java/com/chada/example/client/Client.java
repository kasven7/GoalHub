package com.chada.example.client;

import com.chada.example.dto.ApiResponse;
import com.chada.example.api.League;
import com.chada.example.repositories.StandsRepository;
import com.chada.example.repositories.TeamRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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


                apiResponse.getResponse().forEach(responses -> {
                    responses.getLeague().getStandings().forEach(standingList -> {
                        standingList.forEach(standing -> {
                            Standingsy stand = new Standingsy();
                            stand.setName(standing.getTeam().getName());
                            stand.setPoints(standing.getPoints());
                            stand.setGoaldiff(standing.getGoalsDiff());
                            stand.setForm(standing.getForm());

                            standsRepository.save(stand);
                        });
                    });
                });


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

