package lesson3;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CuisineMaxProteinRequestGetTest extends AbstractTest {

    @Test
    void getCuisineMaxProteinRequestTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "Indian")
                .queryParam("maxProtein", 200)
                .response()
                .contentType(ContentType.JSON)
                //  .time(lessThan(2000L))
                .header("Connection", "keep-alive")
                // .pathParam("id", 716429)
                .expect()
                //.body("vegetarian" , is(true))
                .body("offset", equalTo(0))
                .body("number", equalTo(10))
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200);
    }

}
