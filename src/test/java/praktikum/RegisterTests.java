package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import praktikum.pom.ConstructorPage;
import praktikum.pom.LoginPage;
import praktikum.pom.RegisterPage;

public class RegisterTests extends BaseTest {

    @Test
    @DisplayName("successful Registration check")
    @Description("проверка успешной регистрации пользователя")
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
    @DisplayName("registration With Short Password Shows Error")
    @Description("попытка регистрации пользователя с паролем меньше 6 символов приводит к ошибке")
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
}
