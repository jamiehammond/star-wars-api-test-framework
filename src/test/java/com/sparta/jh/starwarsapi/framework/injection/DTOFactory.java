package com.sparta.jh.starwarsapi.framework.injection;

import com.sparta.jh.starwarsapi.framework.dtos.*;

public class DTOFactory {

    private static final String BASE_REGEX = "https://swapi\\.dev/api/";
    private static final String END_REGEX = "/0*\\d{1,2}/?";

    public static StarWarsDTO StarWarsDTOFactory(String url) {
        if (url.matches(BASE_REGEX + "people" + END_REGEX)) {
            return new PersonDTO();
        }
        else if (url.startsWith(BASE_REGEX + "films" + END_REGEX)) {
            return new FilmDTO();
        }
        else if (url.startsWith(BASE_REGEX + "starships" + END_REGEX)) {
            return new StarshipDTO();
        }
        else if (url.startsWith(BASE_REGEX + "vehicles" + END_REGEX)) {
            return new VehicleDTO();
        }
        else if (url.startsWith(BASE_REGEX + "species" + END_REGEX)) {
            return new SpeciesDTO();
        }
        else if (url.startsWith(BASE_REGEX + "planets" + END_REGEX)) {
            return new PlanetDTO();
        }
        else {
            return null;
        }
    }
}