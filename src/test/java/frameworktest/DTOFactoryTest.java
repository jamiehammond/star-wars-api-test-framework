package frameworktest;

import com.sparta.jh.starwarsapi.framework.connection.APIConnectionController;
import com.sparta.jh.starwarsapi.framework.dtos.*;
import com.sparta.jh.starwarsapi.framework.injection.DTOFactory;
import com.sparta.jh.starwarsapi.framework.injection.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.fail;

class DTOFactoryTest {

    @Test
    @DisplayName("Person URL returns personDTO")
    void personURLReturnsPersonDTO() {
        PersonDTO person1 = (PersonDTO) DTOFactory.starWarsDTOFactory("https://swapi.dev/api/people/1/");
        Assertions.assertEquals(PersonDTO.class, person1.getClass());
    }

    @Test
    @DisplayName("Film URL returns FilmDTO")
    void filmUrlReturnsFilmDto() {
        FilmDTO film1 = (FilmDTO) DTOFactory.starWarsDTOFactory("https://swapi.dev/api/films/1/");
        Assertions.assertEquals(FilmDTO.class, film1.getClass());
    }

    @Test
    @DisplayName("Starship URL returns StarshipDTO")
    void starshipUrlReturnsStarshipDto() {
        StarshipDTO starship1 = (StarshipDTO) DTOFactory.starWarsDTOFactory("https://swapi.dev/api/starships/1/");
        Assertions.assertEquals(StarshipDTO.class, starship1.getClass());
    }

    @Test
    @DisplayName("Vehicle URL returns VehicleDTO")
    void vehicleUrlReturnsVehicleDto() {
        VehicleDTO vehicle1 = (VehicleDTO) DTOFactory.starWarsDTOFactory("https://swapi.dev/api/vehicles/1/");
        Assertions.assertEquals(VehicleDTO.class, vehicle1.getClass());
    }

    @Test
    @DisplayName("Species URL returns SpeciesDTO")
    void speciesUrlReturnsSpeciesDto() {
        SpeciesDTO species1 = (SpeciesDTO) DTOFactory.starWarsDTOFactory("https://swapi.dev/api/species/1/");
        Assertions.assertEquals(SpeciesDTO.class, species1.getClass());
    }

    @Test
    @DisplayName("Planets URL returns PlanetDTO")
    void planetsUrlReturnsPlanetDto() {
        PlanetDTO planet1 = (PlanetDTO) DTOFactory.starWarsDTOFactory("https://swapi.dev/api/planets/1/");
        Assertions.assertEquals(PlanetDTO.class, planet1.getClass());
    }

    @Test
    @DisplayName("Leading zeroes ID URL returns correct DTO")
    void leadingZeroesIdUrlReturnsCorrectDto() {
        FilmDTO film1 = (FilmDTO) DTOFactory.starWarsDTOFactory("https://swapi.dev/api/films/000001/");
        Assertions.assertEquals(FilmDTO.class, film1.getClass());
    }

    @Test
    @DisplayName("Invalid URL returns null")
    void invalidUrlReturnsNull() {
        FilmDTO invalidFilm = (FilmDTO) DTOFactory.starWarsDTOFactory("www.google.com");
        Assertions.assertNull(invalidFilm);
    }

    @Test
    @DisplayName("Invalid resource URL returns null")
    void invalidResourceUrlReturnsNull() {
        FilmDTO invalidFilm = (FilmDTO) DTOFactory.starWarsDTOFactory("https://swapi.dev/api/lightsabers/1/");
        Assertions.assertNull(invalidFilm);
    }

    @Test
    @DisplayName("Invalid ID URL returns null")
    void invalidIdUrlReturnsNull() {
        FilmDTO invalidFilm = (FilmDTO) DTOFactory.starWarsDTOFactory("https://swapi.dev/api/films/9001/");
        Assertions.assertNull(invalidFilm);
    }
}