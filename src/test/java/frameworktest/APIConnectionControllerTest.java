package frameworktest;

import com.sparta.jh.starwarsapi.framework.connection.APIConnection;
import com.sparta.jh.starwarsapi.framework.connection.APIConnectionController;
import com.sparta.jh.starwarsapi.framework.dtos.Resources;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class APIConnectionControllerTest {

    private static APIConnection person1Connection;
    private static APIConnection person100Connection;
    private static APIConnection person001Connection;

    @BeforeAll
    static void setup() {
        person1Connection = APIConnectionController.getConnection(Resources.PERSON, 1);
        person100Connection = APIConnectionController.getConnection(Resources.PERSON, 100);
        person001Connection = APIConnectionController.getConnection(Resources.PERSON, 001);
    }

    @Test
    @DisplayName("getConnection returns a connection")
    void getConnectionReturnsAConnection() {
        Assertions.assertNotNull(person1Connection);
    }

    @Test
    @DisplayName("getConnection returns a connection when ID has leading zeroes")
    void getConnectionReturnsAConnectionWhenIDHasLeadingZeroes() {
        Assertions.assertNotNull(person001Connection);
    }

    @Test
    @DisplayName("getConnection returns null when invalid resourceID provided")
    void getConnectionReturnsNullWhenInvalidResourceIdProvided() {
        Assertions.assertNull(person100Connection);
    }

    @Test
    @DisplayName("getConnection returns null when null resources provided")
    void getConnectionReturnsNullWhenNullResourcesProvided() {
        APIConnection connection = APIConnectionController.getConnection(null, 1);
        Assertions.assertNull(connection);
    }
}