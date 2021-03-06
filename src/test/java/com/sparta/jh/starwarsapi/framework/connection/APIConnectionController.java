package com.sparta.jh.starwarsapi.framework.connection;

import com.sparta.jh.starwarsapi.framework.dtos.Resources;

public class APIConnectionController {

    private static final String BASE_URL = "https://swapi.dev/api/";

    public static APIConnection getConnection(Resources resource, int resourceID) {
        if (resource == null) {
            System.err.println("Null resource provided - Returning null.");
            return null;
        }
        APIConnection connection = new APIConnection(URLBuilder(resource, resourceID));
        if (connection.getStatusCode() != 200) {
            System.err.println("Connection failed - HTTP Status code: " + connection.getStatusCode());
            return null;
        }
        return connection;
    }

    public static APIConnection getConnection(Resources resource, String query, int resourceID) {
        if (resource == null || query == null) {
            System.err.println("Null resource or modifier provided - Returning null.");
            return null;
        }
        APIConnection connection = new APIConnection(URLBuilder(resource, query, resourceID));
        if (connection.getStatusCode() != 200) {
            System.err.println("Connection failed - HTTP Status code: " + connection.getStatusCode());
            return null;
        }
        return connection;
    }

    public static APIConnection getConnection(String URL) {
        if (URL == null) {
            System.err.println("Null URL provided - Returning null.");
            return null;
        }
        APIConnection connection = new APIConnection(URL);
        if (connection.getStatusCode() != 200) {
            System.err.println("Connection failed - HTTP Status code: " + connection.getStatusCode());
            return null;
        }
        return connection;
    }

    private static String URLBuilder(Resources resource, int resourceID) {
        return BASE_URL + resource.getResourceName() + "/" + resourceID + "/";
    }

    private static String URLBuilder(Resources resource, String query, int resourceID) {
        return BASE_URL + resource.getResourceName() + "/" + query + resourceID;
    }
}
