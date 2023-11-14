package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
public class RegisterTests extends BaseTest {

    @Test
    @DisplayName("successful Registration check")
    @Description("проверка успешной регистрации пользователя")
    public void successfulRegistration() {
        objConstructorPage.clickLoginButton();

        objLoginPage.clickRegisterLink();

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
        objConstructorPage.clickLoginButton();

        objLoginPage.clickRegisterLink();

        objRegisterPage.fillInRegistrationFields(randomUser.getName(), randomUser.getEmail(), randomUser.getPassword().substring(0,5)); // пароль — 5 символов.
        objRegisterPage.clickRegisterButton();
        objRegisterPage.waitForRegistrationFailure();
    }
}
