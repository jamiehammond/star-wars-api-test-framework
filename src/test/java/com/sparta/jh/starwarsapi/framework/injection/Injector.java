package com.sparta.jh.starwarsapi.framework.injection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.jh.starwarsapi.framework.connection.APIConnection;
import com.sparta.jh.starwarsapi.framework.dtos.PersonDTO;
import com.sparta.jh.starwarsapi.framework.dtos.StarWarsDTO;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Injector {

    public static StarWarsDTO injectDTO(APIConnection APIConnection) {
        StarWarsDTO starWarsDTO = DTOFactory.StarWarsDTOFactory(APIConnection.getURL());
        if (starWarsDTO == null) {
            System.err.println("Failed to create DTO from connection provided. Returning null.");
            return null;
        }
        String URL = APIConnection.getURL();
        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient httpClient = APIConnection.getHttpClient();
        HttpRequest httpRequest = APIConnection.getHttpRequest();
        HttpResponse<String> httpResponse = APIConnection.getHttpResponse();
        try {
            starWarsDTO = objectMapper.readValue(httpResponse.body(), starWarsDTO.getClass());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return starWarsDTO;
    }
}
