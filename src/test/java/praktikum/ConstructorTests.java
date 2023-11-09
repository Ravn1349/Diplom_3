package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import praktikum.pom.ConstructorPage;
import praktikum.pom.LoginPage;

public class ConstructorTests extends BaseTest {

    @Test
    @DisplayName("sections Transitions check")
    @Description("проверка переходов к разделам «Булки», «Соусы», «Начинки» в разделе «Конструктор»")
    public void sectionsTransitions() {
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
}

