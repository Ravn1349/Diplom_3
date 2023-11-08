package praktikum;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import praktikum.User.UserClient;
import praktikum.models.User;
import praktikum.pom.ConstructorPage;
import praktikum.pom.LoginPage;
import praktikum.pom.RegisterPage;

import static org.junit.Assert.assertEquals;
import static praktikum.User.UserGenerator.*;


public class RegisterTests extends BaseTest {
    private static final String BASE_URI = "https://stellarburgers.nomoreparties.site";
    private static UserClient userClient = new UserClient();

    private static User randomUser = randomUser();
    private static String userAccessToken;
    @Step("delete user")
    static void deleteUser(String userAccessToken) {
        Response courierDeletionResponse = userClient.deleteUser(userAccessToken);
        assertEquals("Не удалось удалить пользователя", 202, courierDeletionResponse.statusCode()); // удаление пользователя
    }

    @Step("get User's Access Token")
    static String getUserAccessToken() {
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        if (localStorage.getItem("accessToken") != null) {
            return localStorage.getItem("accessToken").substring(7);
        }
        return null;
    }

    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URI;
    }

    @Test
    public void successfulRegistration() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickLoginButton();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickRegisterLink();

        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.fillInRegistrationFields(randomUser.getName(), randomUser.getEmail(), randomUser.getPassword().substring(0,6)); // пароль — шесть символов.
        objRegisterPage.clickRegisterButton();
        objRegisterPage.waitForRegistrationSuccess();

        objLoginPage.fillInLoginFields(randomUser.getEmail(), randomUser.getPassword().substring(0,6));
        objLoginPage.clickLoginButton();
        objConstructorPage.waitForLoginSuccess();
        userAccessToken = getUserAccessToken();
    }

    @Test
    public void registrationWithShortPasswordShowsError() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickLoginButton();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickRegisterLink();

        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.fillInRegistrationFields(randomUser.getName(), randomUser.getEmail(), randomUser.getPassword().substring(0,5)); // пароль — 5 символов.
        objRegisterPage.clickRegisterButton();
        objRegisterPage.waitForRegistrationFailure();

        objRegisterPage.clickLoginLink();
        objLoginPage.fillInLoginFields(randomUser.getEmail(), randomUser.getPassword().substring(0,5));
        objLoginPage.clickLoginButton();
        objLoginPage.waitForLoginFailure();
        userAccessToken = getUserAccessToken();
    }

    @After
    public void tearDown() {
        if (userAccessToken != null) {
            deleteUser(userAccessToken);
        }
    }
}
