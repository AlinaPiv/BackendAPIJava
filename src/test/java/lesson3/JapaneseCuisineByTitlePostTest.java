package lesson3;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class JapaneseCuisineByTitlePostTest extends AbstractTest {
    @Test
    void getJapaneseCuisineTitleTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language","en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Ground Pork Ramen")
                // .formParam("ingredientList", " ")
                .response()
                .contentType(ContentType.JSON)
                .time(lessThan(6000L))
                .header("Connection", "keep-alive")
                .expect()
                .body("cuisine", equalTo("Japanese"))
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }
}
