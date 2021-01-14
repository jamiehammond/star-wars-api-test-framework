package frameworktest;

import com.sparta.jh.starwarsapi.framework.connection.APIConnectionController;
import com.sparta.jh.starwarsapi.framework.dtos.FilmDTO;
import com.sparta.jh.starwarsapi.framework.dtos.PersonDTO;
import com.sparta.jh.starwarsapi.framework.dtos.Resources;
import com.sparta.jh.starwarsapi.framework.injection.Injector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonDTOTest {

    @Test
    @DisplayName("getFilmsAsDTOs returns list of FilmDTOs")
    void getFilmsAsDtOsReturnsListOfFilmDTOs() {
        PersonDTO person1 = (PersonDTO) Injector.injectDTO(APIConnectionController.getConnection(Resources.PERSON, 1));
        ArrayList<FilmDTO> films = person1.getFilmsAsDTOs();
        for (FilmDTO film : films) {
            System.out.println(film.getTitle());
        }
    }

}