package com.sparta.jh.starwarsapi.framework.connection;

import com.sparta.jh.starwarsapi.framework.dtos.Resources;

public class APIConnectionController {

    private static final String BASE_URL = "https://swapi.dev/api/";

    public static APIConnection getConnection(Resources resource, int resourceID) {
        return new APIConnection(URLBuilder(resource, resourceID));
    }

    private static String URLBuilder(Resources resource, int resourceID) {
        return BASE_URL + resource.getResourceName() + "/" + resourceID + "/";
    }
}
