package lesson3;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class OffsetNotNulGetTest extends AbstractTest{

    @Test
    void getOffsetNotNulTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("type", "dessert")
                .queryParam("minSugar", 20)
                .queryParam("offset", 568)
                .response()
                .contentType(ContentType.JSON)
                .time(lessThan(4000L))
                .header("Connection", "keep-alive")
                .expect()
                .body("offset", equalTo(568))
                .body("number", equalTo(10))
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200);
    }

    @Test

    void getResponseData() {

        Response response = given()
                .when()
                .get(getBaseUrl() +"recipes/complexSearch"+ "?type=dessert&minSugar=20&offset=568&apiKey=" + getApiKey());


        Headers allHeaders = response.getHeaders();
        System.out.println("Content-Encoding: " + response.getHeader("Content-Encoding"));
        // Get status line
        System.out.println("StatusLine: " + response.getStatusLine());
        // Get status code
        System.out.println("Code: " + response.getStatusCode());

        String totalResults = given()
                .when()
                .get(getBaseUrl()+"recipes/complexSearch" + "?type=dessert&minSugar=20&offset=568&apiKey=" + getApiKey())
                .then().extract()
                .jsonPath()
                .get("totalResults")
                .toString();

        System.out.println("totalResults: " + totalResults);

        String offsetResults = given()
                .when()
                .get(getBaseUrl()+"recipes/complexSearch" + "?type=dessert&minSugar=20&offset=568&apiKey=" + getApiKey())
                .then().extract()
                .jsonPath()
                .get("offset")
                .toString();

        System.out.println("offset: " + offsetResults);

    }
}
