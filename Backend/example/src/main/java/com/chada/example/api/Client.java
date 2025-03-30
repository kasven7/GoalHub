package com.chada.example.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Client {
    public static void main() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api-football-v1.p.rapidapi.com/v3/standings?league=782&season=2024"))
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

            // Example: Print the name of the first league
            if (apiResponse.getResponse() != null && !apiResponse.getResponse().isEmpty()) {
                System.out.println("League Name: " + apiResponse.getResponse().get(0).getLeague().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}