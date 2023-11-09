package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import praktikum.pom.*;

public class PersonalAccountTests extends BaseTest {

    @Test
    @DisplayName("personal Account Link Click Scenario")
    @Description("проверка перехода в личный кабинет по клику на ссылку «Личный кабинет»")
    public void personalAccountLinkClickScenario() {
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
    @DisplayName("persona lAccount Page Constructor Link Scenario")
    @Description("проверка перехода из личного кабинета в конструктор по клику на ссылку «Конструктор»")
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
    @DisplayName("personal Account Page Logo Scenario")
    @Description("проверка перехода из личного кабинета в конструктор по клику на логотип Stellar Burgers")
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
    @DisplayName("personal Account Page Logout Scenario")
    @Description("проверка выхода из аккаунта по клику по кнопке «Выйти» в личном кабинете")
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
}
