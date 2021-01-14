package frameworktest;

import com.sparta.jh.starwarsapi.framework.connection.APIConnection;
import com.sparta.jh.starwarsapi.framework.connection.APIConnectionController;
import com.sparta.jh.starwarsapi.framework.dtos.Resources;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class APIConnectionControllerTest {

    @Test
    @DisplayName("getConnection returns a connection")
    void getConnectionReturnsAConnection() {
        APIConnection APIConnection = APIConnectionController.getConnection(Resources.PERSON, 1);
        Assertions.assertNotNull(APIConnection);
    }
}