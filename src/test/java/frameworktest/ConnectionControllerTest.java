package frameworktest;

import com.sparta.jh.starwarsapi.framework.ConnectionController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionControllerTest {

    @Test
    @DisplayName("getConnection returns correct string")
    void getConnectionReturnsCorrectString() {
        Assertions.assertEquals("https://swapi.dev/api/", ConnectionController.getConnection());
    }

    @Test
    @DisplayName("getUrl returns correct url")
    void getUrlReturnsCorrectUrl() {
        fail("Not implemented");
    }

    @Test
    @DisplayName("getStatusCode returns valid http status code")
    void getStatusCodeReturnsValidHttpStatusCode() {
        int statusCode = ConnectionController.getStatusCode();
        Assertions.assertTrue((statusCode >= 100 && statusCode <= 103) ||
                (statusCode >= 200 && statusCode <= 226) ||
                (statusCode >= 300 && statusCode <= 308) ||
                (statusCode >= 400 && statusCode <= 451) ||
                (statusCode >= 500 && statusCode <= 511));
    }
}