package lesson3;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class NordicCuisineTitlePostTest extends AbstractTest {
    @Test
    void getNordicCuisineTitleTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language","en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Baked Swedish Pancake")
               // .formParam("ingredientList", " ")
                .response()
                .contentType(ContentType.JSON)
                .time(lessThan(6000L))
                .header("Connection", "keep-alive")
                .expect()
                .body("cuisine", equalTo("Nordic"))
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }
    @Test
    void getResponseData() {

        Response response = given()
                .when()
                .get(getBaseUrl() +"recipes/cuisine"+ "?language=en&apiKey=" + getApiKey());


        Headers allHeaders = response.getHeaders();
        System.out.println("Content-Encoding: " + response.getHeader("Content-Encoding"));
        // Get status line
        System.out.println("StatusLine: " + response.getStatusLine());
        // Get status code
        System.out.println("Code: " + response.getStatusCode());

        String confidence = given()
                .when()
                .post(getBaseUrl()+"recipes/cuisine" + "?language=en&apiKey=" + getApiKey())
                .then().extract()
                .jsonPath()
                .get("confidence")
                .toString();

        System.out.println("confidence: " + confidence);

        String cuisine = given()
                .queryParam("apiKey", getApiKey())
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .path("cuisine");

        System.out.println("cuisine: " + cuisine);



    }

}
