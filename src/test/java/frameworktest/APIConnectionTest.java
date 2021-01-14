package frameworktest;

import com.sparta.jh.starwarsapi.framework.connection.APIConnection;
import com.sparta.jh.starwarsapi.framework.connection.APIConnectionController;
import com.sparta.jh.starwarsapi.framework.dtos.Resources;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class APIConnectionTest {

    private static APIConnection person1Connection;

    @BeforeAll
    static void setup() {
        person1Connection = APIConnectionController.getConnection(Resources.PERSON, 1);
    }

    @Test
    @DisplayName("getStatusCode returns valid http status code")
    void getStatusCodeReturnsValidHttpStatusCode() {
        int statusCode = person1Connection.getStatusCode();
        Assertions.assertTrue((statusCode >= 100 && statusCode <= 103) ||
                (statusCode >= 200 && statusCode <= 226) ||
                (statusCode >= 300 && statusCode <= 308) ||
                (statusCode >= 400 && statusCode <= 451) ||
                (statusCode >= 500 && statusCode <= 511));
    }

    @Test
    @DisplayName("getURL returns correct url")
    void getUrlReturnsValidUrl() {
        Assertions.assertEquals("https://swapi.dev/api/people/1/", person1Connection.getURL());
    }
}