package praktikum;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import praktikum.User.UserClient;
import praktikum.models.User;
import praktikum.pom.*;

import static org.junit.Assert.assertEquals;
import static praktikum.RegisterTests.deleteUser;
import static praktikum.User.UserGenerator.*;



public class PersonalAccountTests extends BaseTest {
    private static final String BASE_URI = "https://stellarburgers.nomoreparties.site";
    private static UserClient userClient = new UserClient();
    private static User randomUser = randomUser();
    private static String userAccessToken;

    @Step("create user")
    static String createUserAndGetUserAccessToken(User user) {
        Response CreationResponse = userClient.createUser(user);
        assertEquals("Неверный статус код создания курьера", 200, CreationResponse.statusCode()); // пользователя можно создать передав в ручку все обязательные поля, запрос возвращает правильный код ответа
        assertEquals("Неверное тело ответа", true, CreationResponse.path("success")); // успешный запрос возвращает success: true;
        return CreationResponse.path("accessToken").toString().substring(7);
    }


    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URI;
    }

    @Test
    public void constructorPageLoginButtonScenario() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickLoginButton();

        LoginPage objLoginPage = new LoginPage(driver);
        userAccessToken = createUserAndGetUserAccessToken(randomUser);

        objLoginPage.fillInLoginFields(randomUser.getEmail(), randomUser.getPassword());
        objLoginPage.clickLoginButton();
        objConstructorPage.waitForLoginSuccess();
        objConstructorPage.clickPersonalAccountLink();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.waitForPersonalAccountLinkClickSuccess();
    }

    @Test
    public void personalAccountPageConstructorLinkScenario() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickLoginButton();

        LoginPage objLoginPage = new LoginPage(driver);
        userAccessToken = createUserAndGetUserAccessToken(randomUser);

        objLoginPage.fillInLoginFields(randomUser.getEmail(), randomUser.getPassword());
        objLoginPage.clickLoginButton();
        objConstructorPage.waitForLoginSuccess();
        objConstructorPage.clickPersonalAccountLink();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.waitForPersonalAccountLinkClickSuccess();
        personalAccountPage.clickConstructorLink();
        personalAccountPage.waitForConstructorPageSuccess();
    }

    @Test
    public void personalAccountPageLogoScenario() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickLoginButton();

        LoginPage objLoginPage = new LoginPage(driver);
        userAccessToken = createUserAndGetUserAccessToken(randomUser);

        objLoginPage.fillInLoginFields(randomUser.getEmail(), randomUser.getPassword());
        objLoginPage.clickLoginButton();
        objConstructorPage.waitForLoginSuccess();
        objConstructorPage.clickPersonalAccountLink();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.waitForPersonalAccountLinkClickSuccess();
        personalAccountPage.clickLogo();
        personalAccountPage.waitForConstructorPageSuccess();
    }

    @Test
    public void personalAccountPageLogoutScenario() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickLoginButton();

        LoginPage objLoginPage = new LoginPage(driver);
        userAccessToken = createUserAndGetUserAccessToken(randomUser);

        objLoginPage.fillInLoginFields(randomUser.getEmail(), randomUser.getPassword());
        objLoginPage.clickLoginButton();
        objConstructorPage.waitForLoginSuccess();
        objConstructorPage.clickPersonalAccountLink();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.waitForPersonalAccountLinkClickSuccess();
        personalAccountPage.clickLogoutButton();

        personalAccountPage.waitForLoginPageSuccess();
    }

    @After
    public void tearDown() {
        if (userAccessToken != null) {
            deleteUser(userAccessToken);
        }
    }
}