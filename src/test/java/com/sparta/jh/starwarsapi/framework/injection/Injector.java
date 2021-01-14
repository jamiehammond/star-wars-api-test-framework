package com.sparta.jh.starwarsapi.framework.injection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.jh.starwarsapi.framework.connection.APIConnection;
import com.sparta.jh.starwarsapi.framework.dtos.StarWarsDTO;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Injector {

    public static StarWarsDTO injectDTO(APIConnection connection) {
        if (connection == null) {
            System.err.println("Null connection provided. Returning null.");
            return null;
        }
        StarWarsDTO starWarsDTO = DTOFactory.starWarsDTOFactory(connection.getURL());
        if (starWarsDTO == null) {
            System.err.println("Failed to create DTO from connection provided. Returning null.");
            return null;
        }
        String URL = connection.getURL();
        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient httpClient = connection.getHttpClient();
        HttpRequest httpRequest = connection.getHttpRequest();
        HttpResponse<String> httpResponse = connection.getHttpResponse();
        try {
            starWarsDTO = objectMapper.readValue(httpResponse.body(), starWarsDTO.getClass());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return starWarsDTO;
    }
}
