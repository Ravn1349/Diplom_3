package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class PersonalAccountTests extends BaseTest {

    @Test
    @DisplayName("personal Account Link Click Scenario")
    @Description("проверка перехода в личный кабинет по клику на ссылку «Личный кабинет»")
    public void personalAccountLinkClickScenario() {
        objConstructorPage.clickLoginButton();

        userAccessToken = createUserAndGetUserAccessToken(randomUser);

        objLoginPage.fillInLoginFields(randomUser.getEmail(), randomUser.getPassword());
        objLoginPage.clickLoginButton();
        objConstructorPage.waitForLoginSuccess();
        objConstructorPage.clickPersonalAccountLink();

        objPersonalAccountPage.waitForPersonalAccountLinkClickSuccess();
    }

    @Test
    @DisplayName("persona lAccount Page Constructor Link Scenario")
    @Description("проверка перехода из личного кабинета в конструктор по клику на ссылку «Конструктор»")
    public void personalAccountPageConstructorLinkScenario() {
        objConstructorPage.clickLoginButton();

        userAccessToken = createUserAndGetUserAccessToken(randomUser);

        objLoginPage.fillInLoginFields(randomUser.getEmail(), randomUser.getPassword());
        objLoginPage.clickLoginButton();
        objConstructorPage.waitForLoginSuccess();
        objConstructorPage.clickPersonalAccountLink();

        objPersonalAccountPage.waitForPersonalAccountLinkClickSuccess();
        objPersonalAccountPage.clickConstructorLink();
        objPersonalAccountPage.waitForConstructorPageSuccess();
    }

    @Test
    @DisplayName("personal Account Page Logo Scenario")
    @Description("проверка перехода из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void personalAccountPageLogoScenario() {
        objConstructorPage.clickLoginButton();

        userAccessToken = createUserAndGetUserAccessToken(randomUser);

        objLoginPage.fillInLoginFields(randomUser.getEmail(), randomUser.getPassword());
        objLoginPage.clickLoginButton();
        objConstructorPage.waitForLoginSuccess();
        objConstructorPage.clickPersonalAccountLink();

        objPersonalAccountPage.waitForPersonalAccountLinkClickSuccess();
        objPersonalAccountPage.clickLogo();
        objPersonalAccountPage.waitForConstructorPageSuccess();
    }

    @Test
    @DisplayName("personal Account Page Logout Scenario")
    @Description("проверка выхода из аккаунта по клику по кнопке «Выйти» в личном кабинете")
    public void personalAccountPageLogoutScenario() {
        objConstructorPage.clickLoginButton();

        userAccessToken = createUserAndGetUserAccessToken(randomUser);

        objLoginPage.fillInLoginFields(randomUser.getEmail(), randomUser.getPassword());
        objLoginPage.clickLoginButton();
        objConstructorPage.waitForLoginSuccess();
        objConstructorPage.clickPersonalAccountLink();

        objPersonalAccountPage.waitForPersonalAccountLinkClickSuccess();
        objPersonalAccountPage.clickLogoutButton();

        objPersonalAccountPage.waitForLoginPageSuccess();
    }
}
