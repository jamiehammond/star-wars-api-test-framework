package com.sparta.jh.starwarsapi.framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.jh.starwarsapi.framework.dtos.PersonDTO;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Injector {

    public static PersonDTO injectDTO(String url) {
        PersonDTO personDTO = new PersonDTO();
        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            personDTO = objectMapper.readValue(httpResponse.body(), PersonDTO.class);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return personDTO;
    }
}
