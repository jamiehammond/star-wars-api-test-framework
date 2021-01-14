package frameworktest;

import com.sparta.jh.starwarsapi.framework.connection.APIConnection;
import com.sparta.jh.starwarsapi.framework.connection.APIConnectionController;
import com.sparta.jh.starwarsapi.framework.dtos.FilmDTO;
import com.sparta.jh.starwarsapi.framework.dtos.PersonDTO;
import com.sparta.jh.starwarsapi.framework.dtos.PlanetDTO;
import com.sparta.jh.starwarsapi.framework.dtos.Resources;
import com.sparta.jh.starwarsapi.framework.injection.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonDTOTest {

    private static APIConnection person1Connection;

    @BeforeAll
    static void setup() {
        person1Connection = APIConnectionController.getConnection(Resources.PERSON, 1);
    }

    @Test
    @DisplayName("getHomeworldAsDTO returns correct homeworld")
    void getHomeworldAsDtoReturnsCorrectHomeworld() {
        PersonDTO person1 = (PersonDTO) Injector.injectDTO(person1Connection);
        PlanetDTO homeworld = person1.getHomeworldAsDTO();
        Assertions.assertEquals("Tatooine", homeworld.getName());
    }

    @Test
    @DisplayName("getFilmsAsDTOs returns correct list of FilmDTOs")
    void getFilmsAsDtOsReturnsListOfFilmDTOs() {
        PersonDTO person1 = (PersonDTO) Injector.injectDTO(person1Connection);
        ArrayList<FilmDTO> films = person1.getFilmsAsDTOs();
        String[] titles = {"A New Hope", "The Empire Strikes Back", "Return of the Jedi", "Revenge of the Sith"};
        boolean validList = true;
        for (int i = 0; i < films.size(); i++) {
            if (!films.get(i).getTitle().equals(titles[i])) {
                validList = false;
                break;
            }
        }
        Assertions.assertTrue(validList);
    }
}