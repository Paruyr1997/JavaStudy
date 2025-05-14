import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanEchoSimpleTests {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    // 1. GET Request
    @Test
    void testGetRequest() {
        given()
                .queryParam("param1", "value1")
                .queryParam("param2", "value2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.param1", equalTo("value1"))
                .body("args.param2", equalTo("value2"));
    }

    // 2. POST Raw Text
    @Test
    void testPostRawText() {
        given()
                .contentType("text/plain")
                .body("Simple text message")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("Simple text message"));
    }

    // 3. POST Form Data
    @Test
    void testPostFormData() {
        given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("username", "testuser")
                .formParam("password", "pass123")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.username", equalTo("testuser"))
                .body("form.password", equalTo("pass123"));
    }

    // 4. PUT Request
    @Test
    void testPutRequest() {
        given()
                .contentType("application/json")
                .body("{\"id\": 123, \"name\": \"John\"}")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("json.id", equalTo(123))
                .body("json.name", equalTo("John"));
    }

    // 5. PATCH Request
    @Test
    void testPatchRequest() {
        given()
                .contentType("application/json")
                .body("{\"status\": \"active\"}")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("json.status", equalTo("active"));
    }

    // 6. DELETE Request
    @Test
    void testDeleteRequest() {
        given()
                .queryParam("id", "123")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("args.id", equalTo("123"));
    }
}
