package lesson3;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class QueryNumberRequestGetTest extends AbstractTest {


    @Test
    void getQueryNumberTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "pasta")
                .queryParam("number", 20)
                .response()
                .contentType(ContentType.JSON)
                //  .time(lessThan(2000L))
                .header("Connection", "keep-alive")
                .expect()
                .body("offset", equalTo(0))
                .body("number", equalTo(20))
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200);
    }

        @Test

        void getResponseData() {

            Response response = given()
                    .when()
                    .get(getBaseUrl() +"recipes/complexSearch"+ "?query=pasta&number=20&apiKey=" + getApiKey());


            Headers allHeaders = response.getHeaders();
           System.out.println("Content-Encoding: " + response.getHeader("Content-Encoding"));
            // Get status line
            System.out.println("StatusLine: " + response.getStatusLine());
            // Get status code
            System.out.println("Code: " + response.getStatusCode());

            String totalResults = given()
                    .when()
                    .get(getBaseUrl()+"recipes/complexSearch" + "?query=pasta&number=20&apiKey=" + getApiKey())
                    .then().extract()
                    .jsonPath()
                    .get("totalResults")
                    .toString();

            System.out.println("totalResults: " + totalResults);

        }

         }

