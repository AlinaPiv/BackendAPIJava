package lesson3;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MediterraneanCuisineByTitleIngrPostTest extends AbstractTest {

    @Test
    void getMediterraneanCuisineByTitleIngrTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language","en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Pesto Fresh Caprese Sandwich")
                .formParam("ingredientList", "3 oz pork shoulder potato")
                .response()
                .contentType(ContentType.JSON)
                .header("Connection", "keep-alive")
                .expect()
                .body("cuisine", equalTo("Italian"))
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }
}
