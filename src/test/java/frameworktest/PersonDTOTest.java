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
    private static APIConnection person12Connection;
    private static APIConnection person13Connection;
    private static PersonDTO person1;
    private static PersonDTO person12;
    private static PersonDTO person13;

    @BeforeAll
    static void setup() {
        person1Connection = APIConnectionController.getConnection(Resources.PERSON, 1);
        person12Connection = APIConnectionController.getConnection(Resources.PERSON, 12);
        person13Connection = APIConnectionController.getConnection(Resources.PERSON, 13);
        person1 = (PersonDTO) Injector.injectDTO(person1Connection);
        person12 = (PersonDTO) Injector.injectDTO(person12Connection);
        person13 = (PersonDTO) Injector.injectDTO(person13Connection);
    }

    @Test
    @DisplayName("getHomeworldAsDTO returns correct homeworld for person 1")
    void getHomeworldAsDtoReturnsCorrectHomeworld() {
        PlanetDTO homeworld = person1.getHomeworldAsDTO();
        Assertions.assertEquals("Tatooine", homeworld.getName());
    }

    @Test
    @DisplayName("getFilmsAsDTOs returns correct list of FilmDTOs for person 1")
    void getFilmsAsDtOsReturnsListOfFilmDTOs() {
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

    @Test
    @DisplayName("getHeightAsInt returns 172 for person 1")
    void getHeightAsIntReturnsCorrectInt() {
        Assertions.assertEquals(172, person1.getHeightAsInt());
    }

    @Test
    @DisplayName("getHeightAsInt returns -1 for non integer height")
    void getHeightAsIntReturns1ForNonIntegerHeight() {
        PersonDTO tempPerson = (PersonDTO) Injector.injectDTO(person1Connection);
        tempPerson.setHeight("tall");
        Assertions.assertEquals(-1, tempPerson.getHeightAsInt());
    }

    @Test
    @DisplayName("getMassAsInt returns -1 for non-int value")
    void getMassAsIntReturns1ForNonIntValue() {
        Assertions.assertEquals(-1, person12.getMassAsInt());
    }

    @Test
    @DisplayName("isHeightInRange returns correct boolean for person 1")
    void isHeightInRangeReturnsCorrectBoolean() {
        Assertions.assertTrue(person1.isHeightInRange(170, 175));
    }

    @Test
    @DisplayName("isMassInRange returns correct boolean for person 1")
    void isMassInRangeReturnsTrueForPerson1() {
        Assertions.assertTrue(person1.isMassInRange(70, 80));
    }

    @Test
    @DisplayName("getNullOrEmptyFields has size 3 for person 12")
    void getNullOrEmptyFieldsHasSize3ForPerson12() {
        Assertions.assertEquals(3, person12.getNullOrEmptyFields().size());
    }

    @Test
    @DisplayName("hasNullOrEmptyFields returns true for person 1")
    void hasNullOrEmptyFieldsReturnsTrueForPerson1() {
        Assertions.assertTrue(person1.hasNullOrEmptyFields());
    }

    @Test
    @DisplayName("hasNullOrEmptyFields returns false for person 13")
    void hasNullOrEmptyFieldsReturnsFalseForPerson13() {
        Assertions.assertFalse(person13.hasNullOrEmptyFields());
    }
}