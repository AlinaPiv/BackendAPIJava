package lesson3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static io.restassured.RestAssured.given;

public class AddToMealToShoppingListTest extends AbstractTest {
    //String id;


    @Test
    void generateShoppingListTest() {

        given()
                .queryParam("hash", "235839fe0531d0a702b688b4d6d1542f6c3a2cec")
                .queryParam("apiKey", getApiKey())
                .when()
                .post("https://api.spoonacular.com/mealplanner/sabrina-schroeder88/shopping-list/2023-07-24/2023-07-27")
                .then()
                .statusCode(200);
    }

    @Test
    void addMealToShoppingListTest() {
        String id = given()
                .queryParam("hash", "235839fe0531d0a702b688b4d6d1542f6c3a2cec")
                .queryParam("apiKey", getApiKey())
                .body("{\n"
                        + " \"item\": \"1 package baking powder\",\n"
                        + " \"aisle\": \"Baking\",\n"
                        + " \"parse\": true,\n"
                        + "}")
                .when()
                .post("https://api.spoonacular.com/mealplanner/sabrina-schroeder88/shopping-list/items")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id")
                .toString();
        System.out.println("id: " + id);

    }




        // @AfterAll

    void tearDown() {

        String id = given()
                .queryParam("hash", "235839fe0531d0a702b688b4d6d1542f6c3a2cec")
                .queryParam("apiKey", getApiKey())
                .when()
                .get("https://api.spoonacular.com/mealplanner/sabrina-schroeder88/shopping-list")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id")
                .toString();
        System.out.println("id: " + id);

        given()
                .queryParam("hash", "235839fe0531d0a702b688b4d6d1542f6c3a2cec")
                .queryParam("apiKey", getApiKey())
                .when()
                .delete("https://api.spoonacular.com/mealplanner/sabrina-schroeder88/shopping-list/items" + id)
                .then()
                .statusCode(200);
    }
}



