package com.sparta.jh.starwarsapi.framework.examples;

import com.sparta.jh.starwarsapi.framework.connection.APIConnection;
import com.sparta.jh.starwarsapi.framework.connection.APIConnectionController;
import com.sparta.jh.starwarsapi.framework.dtos.DTOController;
import com.sparta.jh.starwarsapi.framework.dtos.FilmDTO;
import com.sparta.jh.starwarsapi.framework.dtos.PersonDTO;
import com.sparta.jh.starwarsapi.framework.dtos.Resources;
import com.sparta.jh.starwarsapi.framework.injection.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.fail;

public class ExampleTests {

    private static APIConnection person1Connection;
    private static PersonDTO person1;

    @BeforeAll
    static void setup() {
        person1Connection = APIConnectionController.getConnection(Resources.PERSON, 1);
        person1 = (PersonDTO) Injector.injectDTO(person1Connection);
    }

    @Test
    @DisplayName("Person1 name is correct")
    void person1NameIsCorrect() {
        Assertions.assertEquals("Luke Skywalker", person1.getName());
    }

    @Test
    @DisplayName("Number of people with null or empty fields is 0")
    void numberOfPeopleWithNullOrEmptyFieldsIs0() {
        int count = 0;
        ArrayList<PersonDTO> people = DTOController.getAllPeople();
        for (PersonDTO person : people) {
            if (person.hasNullOrEmptyFields()) {
                count++;
            }
        }
        Assertions.assertEquals(0, count);
    }

    @Test
    @DisplayName("Person 1 has the correct homeworld")
    void person1HasTheCorrectHomeworld() {
        Assertions.assertEquals("Tatooine", person1.getHomeworldAsDTO().getName());
    }

    @Test
    @DisplayName("Person 1 has correct films")
    void person1HasCorrectFilms() {
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
    @DisplayName("Person 1 has no null or empty fields")
    void person1HasNoNullOrEmptyFields() {
        Assertions.assertEquals(0, person1.getNullOrEmptyFields().size());
    }

    @Test
    @DisplayName("Person 1 height is between 170 and 175")
    void person1HeightIsBetween170And175() {
        Assertions.assertTrue(person1.isHeightInRange(170, 175));
    }
}
