package com.sparta.jh.starwarsapi.framework.connection;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConnection {

    private final String URL;
    private HttpClient httpClient;
    private HttpRequest httpRequest;
    private HttpResponse<String> httpResponse;

    public APIConnection(String URL) {
        this.URL = URL;
        httpClient = HttpClient.newHttpClient();
        httpRequest = HttpRequest.newBuilder().uri(URI.create(URL)).build();
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            System.err.println("Connection failed. See below for error.");
            e.printStackTrace();
        }
    }

    public int getStatusCode() {
        return httpResponse.statusCode();
    }

    public String getURL() {
        return URL;
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public HttpRequest getHttpRequest() {
        return httpRequest;
    }

    public HttpResponse<String> getHttpResponse() {
        return httpResponse;
    }
}
