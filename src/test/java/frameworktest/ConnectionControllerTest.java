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
}