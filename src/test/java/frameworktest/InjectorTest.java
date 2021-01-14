package frameworktest;

import com.sparta.jh.starwarsapi.framework.connection.APIConnection;
import com.sparta.jh.starwarsapi.framework.connection.APIConnectionController;
import com.sparta.jh.starwarsapi.framework.dtos.PersonDTO;
import com.sparta.jh.starwarsapi.framework.dtos.Resources;
import com.sparta.jh.starwarsapi.framework.injection.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InjectorTest {

    private static APIConnection person1Connection;

    @BeforeAll
    static void setup() {
        person1Connection = APIConnectionController.getConnection(Resources.PERSON, 1);
    }

    @Test
    @DisplayName("Null connection returns null")
    void nullConnectionReturnsNull() {
        Assertions.assertNull(Injector.injectDTO(null));
    }

    @Test
    @DisplayName("Good connection inserts fields")
    void goodConnectionInsertsFields() {
        PersonDTO person1 = (PersonDTO) Injector.injectDTO(person1Connection);
        Assertions.assertEquals("Luke Skywalker", person1.getName());
    }
}