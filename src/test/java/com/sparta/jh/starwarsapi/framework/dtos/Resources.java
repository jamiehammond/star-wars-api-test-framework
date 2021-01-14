package com.sparta.jh.starwarsapi.framework.dtos;

public enum Resources {
    FILM("films"),
    PERSON("people"),
    PLANET("planets"),
    SPECIES("species"),
    STARSHIP("starships"),
    VEHICLE("vehicles");

    private final String resourceName;

    Resources(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceName() {
        return resourceName;
    }
}
