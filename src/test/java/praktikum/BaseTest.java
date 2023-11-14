package praktikum;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import praktikum.User.UserClient;
import praktikum.models.User;
import praktikum.pom.*;

import static org.junit.Assert.assertEquals;
import static praktikum.User.UserGenerator.randomUser;
import static praktikum.driver.WebDriverCreator.createWebDriver;
import static praktikum.pom.ConstructorPage.MAIN_PAGE_URL;

public class BaseTest {

    static WebDriver driver;
    static final String BASE_URI = "https://stellarburgers.nomoreparties.site";
    static ConstructorPage objConstructorPage;
    static LoginPage objLoginPage;
    static PasswordResetPage objPasswordResetPage;
    static PersonalAccountPage objPersonalAccountPage;
    static RegisterPage objRegisterPage;
    static UserClient userClient = new UserClient();
    static User randomUser = randomUser();
    static String userAccessToken;

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

    @Step("create user And Get User Access Token")
    static String createUserAndGetUserAccessToken(User user) {
        Response CreationResponse = userClient.createUser(user);
        assertEquals("Неверный статус код создания курьера", 200, CreationResponse.statusCode()); // пользователя можно создать передав в ручку все обязательные поля, запрос возвращает правильный код ответа
        assertEquals("Неверное тело ответа", true, CreationResponse.path("success")); // успешный запрос возвращает success: true;
        return CreationResponse.path("accessToken").toString().substring(7);
    }

    @Before
    public void startUp() {
        driver = createWebDriver();

        objConstructorPage = new ConstructorPage(driver);
        objLoginPage = new LoginPage(driver);
        objPasswordResetPage = new PasswordResetPage(driver);
        objPersonalAccountPage = new PersonalAccountPage(driver);
        objRegisterPage = new RegisterPage(driver);

        driver.get(MAIN_PAGE_URL);
        RestAssured.baseURI = BASE_URI;
    }

    @After
    public void quit() {
        if (userAccessToken != null) {
            deleteUser(userAccessToken);
        }
        userAccessToken = null;
        driver.quit();
    }
}
