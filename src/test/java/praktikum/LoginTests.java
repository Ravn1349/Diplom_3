package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
public class LoginTests extends BaseTest {

    @Test
    @DisplayName("constructor Page Login Button Scenario")
    @Description("проверка входа в аккаунт по клику по кнопке «Войти в аккаунт» на главной странице")
    public void constructorPageLoginButtonScenario() {
        objConstructorPage.clickLoginButton();

        userAccessToken = createUserAndGetUserAccessToken(randomUser);

        objLoginPage.fillInLoginFields(randomUser.getEmail(), randomUser.getPassword());
        objLoginPage.clickLoginButton();
        objConstructorPage.waitForLoginSuccess();
    }

    @Test
    @DisplayName("constructor Page Personal Account Link Scenario")
    @Description("проверка входа в аккаунт по клику по кнопке «Личный кабинет» на главной странице")
    public void constructorPagePersonalAccountLinkScenario() {
        objConstructorPage.clickPersonalAccountLink();

        userAccessToken = createUserAndGetUserAccessToken(randomUser);

        objLoginPage.fillInLoginFields(randomUser.getEmail(), randomUser.getPassword());
        objLoginPage.clickLoginButton();
        objConstructorPage.waitForLoginSuccess();
    }

    @Test
    @DisplayName("register Page Login Link Scenario")
    @Description("проверка входа в аккаунт по клику по кнопке «Войти» на странице регистрации")
    public void registerPageLoginLinkScenario() {

        objConstructorPage.clickLoginButton();

        objLoginPage.clickRegisterLink();

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

        objConstructorPage.clickLoginButton();

        objLoginPage.clickResetPasswordLink();

        objPasswordResetPage.clickLoginLink();

        userAccessToken = createUserAndGetUserAccessToken(randomUser);

        objLoginPage.fillInLoginFields(randomUser.getEmail(), randomUser.getPassword());
        objLoginPage.clickLoginButton();
        objConstructorPage.waitForLoginSuccess();
    }
}
