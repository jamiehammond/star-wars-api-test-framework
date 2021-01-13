package com.sparta.jh.starwarsapi.framework;

public class ConnectionController {
    private static final String BASE_URL = "https://swapi.dev/api/";
    private static String endPoint;
    private String url;

    public static String getConnection() {
        return BASE_URL;
    }

    public String getUrl() {
        return BASE_URL + endPoint;
    }
}
