package lesson3;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CuisineIndianByTitlePostTest extends AbstractTest {


    @Test
    void getIndianByTitleTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language","de")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Authentic Jamaican Curry Chicken")
                .response()
                .contentType(ContentType.JSON)
                .header("Connection", "keep-alive")
                .expect()
                .body("cuisine", equalTo("Indian"))
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }
}
