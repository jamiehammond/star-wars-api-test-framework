package frameworktest;

import com.sparta.jh.starwarsapi.framework.connection.APIConnection;
import com.sparta.jh.starwarsapi.framework.connection.APIConnectionController;
import com.sparta.jh.starwarsapi.framework.dtos.Resources;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class APIConnectionControllerTest {

    @Test
    @DisplayName("getConnection returns a connection")
    void getConnectionReturnsAConnection() {
        APIConnection person1Connection = APIConnectionController.getConnection(Resources.PERSON, 1);
        Assertions.assertNotNull(person1Connection);
    }

    @Test
    @DisplayName("getConnection returns a connection when ID has leading zeroes")
    void getConnectionReturnsAConnectionWhenIDHasLeadingZeroes() {
        APIConnection person1Connection = APIConnectionController.getConnection(Resources.PERSON, 00001);
        Assertions.assertNotNull(person1Connection);
    }

    @Test
    @DisplayName("getConnection returns null when invalid resourceID provided")
    void getConnectionReturnsNullWhenInvalidResourceIdProvided() {
        APIConnection connection = APIConnectionController.getConnection(Resources.PERSON, 100);
        Assertions.assertNull(connection);
    }

    @Test
    @DisplayName("getConnection returns null when null resources provided")
    void getConnectionReturnsNullWhenNullResourcesProvided() {
        APIConnection connection = APIConnectionController.getConnection(null, 1);
        Assertions.assertNull(connection);
    }
}