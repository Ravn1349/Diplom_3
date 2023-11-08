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
import praktikum.pom.PersonalAccountPage;
import praktikum.pom.RegisterPage;

import static org.junit.Assert.assertEquals;
import static praktikum.LoginTests.createUserAndGetUserAccessToken;
import static praktikum.RegisterTests.deleteUser;
import static praktikum.User.UserGenerator.*;


public class ConstructorTests extends BaseTest {
    private static final String BASE_URI = "https://stellarburgers.nomoreparties.site";
    private static UserClient userClient = new UserClient();

    private static User randomUser = randomUser();
    private static String userAccessToken;

    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URI;
    }

    @Test
    public void bunsPartition() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickLoginButton();

        LoginPage objLoginPage = new LoginPage(driver);
        userAccessToken = createUserAndGetUserAccessToken(randomUser);

        objLoginPage.fillInLoginFields(randomUser.getEmail(), randomUser.getPassword());
        objLoginPage.clickLoginButton();
        objConstructorPage.waitForLoginSuccess();

        objConstructorPage.clickStuffingsNavItem();
        objConstructorPage.waitForStuffings();

        objConstructorPage.clickSaucesNavItem();
        objConstructorPage.waitForSauces();

        objConstructorPage.clickBunsNavItem();
        objConstructorPage.waitForBuns();

    }

    @After
    public void tearDown() {
        if (userAccessToken != null) {
            deleteUser(userAccessToken);
        }
    }
}

