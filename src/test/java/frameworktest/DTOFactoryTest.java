package frameworktest;

import com.sparta.jh.starwarsapi.framework.injection.DTOFactory;
import com.sparta.jh.starwarsapi.framework.dtos.PersonDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DTOFactoryTest {

    @Test
    @DisplayName("Person URL returns personDTO")
    void personURLReturnsPersonDTO() {
        PersonDTO luke = (PersonDTO) DTOFactory.StarWarsDTOFactory("https://swapi.dev/api/people/1/");
        Assertions.assertNotNull(luke);
    }
}