package lesson4;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class AddToShoppingListTest extends AbstractTest {

    @Test
    void AddToListTest(){
        ResponseAdd response =  given().spec(requestSpecification)
                .body("{\n"
                        + " \"item\": \"1 package baking powder\",\n"
                        + " \"aisle\": \"Baking\",\n"
                        + " \"parse\": true,\n"
                        + "}")
                .when()
                .post("https://api.spoonacular.com/mealplanner/sabrina-schroeder88/shopping-list/items").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(ResponseAdd.class);
        assertThat(response.getName(), containsString("baking"));
        assertThat(response.getAisle(), containsString("Baking"));
    }

    // @AfterAll

    @Test
    void getListAndDeleteFromShoppingList() {
        AddToShoppingListResponse responseAdd = given().spec(requestSpecification)
                .when()
                .get("https://api.spoonacular.com/mealplanner/sabrina-schroeder88/shopping-list")
                .then()
                .extract()
                .response()
                .body()
                .as(AddToShoppingListResponse.class);

        //   assertThat(response.getAisles() containsString("Baking"));


            given().spec(requestSpecification)
                    .when()
                    .delete("https://api.spoonacular.com/mealplanner/sabrina-schroeder88/shopping-list" + responseAdd.getId())
                    .then()
                    .extract()
                    .response()
                    .body()
                    .as(AddToShoppingListResponse.class);
            System.out.println("id: "+ responseAdd.getId());
        }
    }

