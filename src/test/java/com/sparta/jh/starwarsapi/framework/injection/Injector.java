package com.sparta.jh.starwarsapi.framework.injection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.jh.starwarsapi.framework.dtos.PersonDTO;
import com.sparta.jh.starwarsapi.framework.dtos.StarWarsDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Injector {

    public static StarWarsDTO injectDTO(String url) {
        StarWarsDTO starWarsDTO = new PersonDTO();
        if (url == null || url.equals("")) {
            System.err.println("URL is be null or empty. Returning empty DTO.");
            return starWarsDTO;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            starWarsDTO = objectMapper.readValue(httpResponse.body(), StarWarsDTO.class);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return starWarsDTO;
    }
}
