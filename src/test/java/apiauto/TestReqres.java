package apiauto;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class TestReqres {

    @Test
    public void testGetListUsers() {
        given().when()
                .get("https://reqres.in/api/users?page=2")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("per_page", Matchers.equalTo(6))
                .assertThat().body("page", Matchers.equalTo(2));
    }

    @Test
    public void testPostCreateUser() {
        String valueName = "WRAP";
        String valueJob = "QA";

        JSONObject bodyObj = new JSONObject();

        bodyObj.put("name", valueName);
        bodyObj.put("job", valueJob);

        given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .body(bodyObj.toString())
                .when()
                .post("https://reqres.in/api/users")
                .then().log().all()
                .assertThat().statusCode(201)
                .assertThat().body("name", Matchers.equalTo(valueName));

    }
    @Test
    public void testPatchUser() {
        RestAssured.baseURI = "https://reqres.in/";

        int userId = 3;
        String newName = "updatedUser";

        String fname = given().when().get("api/users/"+userId)
                .getBody().jsonPath().get("data.first_name");
        System.out.println("name before = "+fname);

        HashMap<String, String> bodyMap = new HashMap<>();
        bodyMap.put("first_name", newName);
        JSONObject jsonObject = new JSONObject(bodyMap);

        given().log().all()
                .header("Content-Type", "application/json")
                .body(jsonObject.toString())
                .patch("api/users/"+userId)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("first_name", Matchers.equalTo(newName));

    }
    @Test
    public void testDeleteUser(){

        RestAssured.baseURI = "https://reqres.in/";
        int userToDelete = 4;

        given().log().all()
                .when().delete("api/users/" + userToDelete)
                .then()
                .log().all()
                .assertThat().statusCode(204);

    }

}
