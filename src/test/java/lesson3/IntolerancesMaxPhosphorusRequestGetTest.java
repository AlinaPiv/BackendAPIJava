package lesson3;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class IntolerancesMaxPhosphorusRequestGetTest extends AbstractTest {

    @Test
    void getIntolerancesMaxPhosphorusTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("intolerances", "Seafood")
                .queryParam("maxPhosphorus", 500)
                .queryParam("sort", "calories")
                .response()
                .contentType(ContentType.JSON)
                //  .time(lessThan(2000L))
                .header("Connection", "keep-alive")
                .expect()
                .body("offset", equalTo(0))
                .body("number", equalTo(10))
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200);
    }
}
