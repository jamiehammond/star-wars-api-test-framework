package frameworktest;

import com.sparta.jh.starwarsapi.framework.connection.APIConnectionController;
import com.sparta.jh.starwarsapi.framework.dtos.Resources;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class APIConnectionTest {

    @Test
    @DisplayName("getStatusCode returns valid http status code")
    void getStatusCodeReturnsValidHttpStatusCode() {
        int statusCode = APIConnectionController.getConnection(Resources.PERSON, 1).getStatusCode();
        Assertions.assertTrue((statusCode >= 100 && statusCode <= 103) ||
                (statusCode >= 200 && statusCode <= 226) ||
                (statusCode >= 300 && statusCode <= 308) ||
                (statusCode >= 400 && statusCode <= 451) ||
                (statusCode >= 500 && statusCode <= 511));
    }
}