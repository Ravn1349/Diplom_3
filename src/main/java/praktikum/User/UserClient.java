package praktikum.User;

import io.restassured.response.Response;
import praktikum.models.User;

import static io.restassured.RestAssured.given;

public class UserClient {
    private static final String CREATE_URL = "/api/auth/register";
    private static final String USER_URL = "/api/auth/user";

    public Response createUser(User user) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(CREATE_URL);
    }

    public Response deleteUser(String userAccessToken) {
        return given()
                .header("Content-type", "application/json")
                .auth().oauth2(userAccessToken)
                .and()
                .when()
                .delete(USER_URL);
    }
}
