package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import praktikum.pom.ConstructorPage;
import praktikum.pom.LoginPage;
import praktikum.pom.PasswordResetPage;
import praktikum.pom.RegisterPage;

public class LoginTests extends BaseTest {

    @Test
    @DisplayName("constructor Page Login Button Scenario")
    @Description("проверка входа в аккаунт по клику по кнопке «Войти в аккаунт» на главной странице")
    public void constructorPageLoginButtonScenario() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickLoginButton();

        LoginPage objLoginPage = new LoginPage(driver);
        userAccessToken = createUserAndGetUserAccessToken(randomUser);

        objLoginPage.fillInLoginFields(randomUser.getEmail(), randomUser.getPassword());
        objLoginPage.clickLoginButton();
        objConstructorPage.waitForLoginSuccess();
    }

    @Test
    @DisplayName("constructor Page Personal Account Link Scenario")
    @Description("проверка входа в аккаунт по клику по кнопке «Личный кабинет» на главной странице")
    public void constructorPagePersonalAccountLinkScenario() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickPersonalAccountLink();

        LoginPage objLoginPage = new LoginPage(driver);
        userAccessToken = createUserAndGetUserAccessToken(randomUser);

        objLoginPage.fillInLoginFields(randomUser.getEmail(), randomUser.getPassword());
        objLoginPage.clickLoginButton();
        objConstructorPage.waitForLoginSuccess();
    }

    @Test
    @DisplayName("register Page Login Link Scenario")
    @Description("проверка входа в аккаунт по клику по кнопке «Войти» на странице регистрации")
    public void registerPageLoginLinkScenario() {

        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickLoginButton();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickRegisterLink();

        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.clickLoginLink();
        userAccessToken = createUserAndGetUserAccessToken(randomUser);

        objLoginPage.fillInLoginFields(randomUser.getEmail(), randomUser.getPassword());
        objLoginPage.clickLoginButton();
        objConstructorPage.waitForLoginSuccess();
    }

    @Test
    @DisplayName("password Reset Page Login Link Scenario")
    @Description("проверка входа в аккаунт по клику по кнопке «Войти» на странице восстановления пароля")
    public void passwordResetPageLoginLinkScenario() {

        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickLoginButton();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickResetPasswordLink();

        PasswordResetPage objPasswordResetPage = new PasswordResetPage(driver);
        objPasswordResetPage.clickLoginLink();

        userAccessToken = createUserAndGetUserAccessToken(randomUser);

        objLoginPage.fillInLoginFields(randomUser.getEmail(), randomUser.getPassword());
        objLoginPage.clickLoginButton();
        objConstructorPage.waitForLoginSuccess();
    }
}
