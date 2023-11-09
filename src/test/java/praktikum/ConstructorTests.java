package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.Point;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class ConstructorTests extends BaseTest {

    @Test
    @DisplayName("sections Transitions check")
    @Description("проверка переходов к разделам «Булки», «Соусы», «Начинки» в разделе «Конструктор»")
    public void sectionsTransitions() {
        objConstructorPage.clickLoginButton();

        userAccessToken = createUserAndGetUserAccessToken(randomUser);

        objLoginPage.fillInLoginFields(randomUser.getEmail(), randomUser.getPassword());
        objLoginPage.clickLoginButton();
        objConstructorPage.waitForLoginSuccess();

        Point topLeftCoordinates = objConstructorPage.getBunsHeaderCoordinates().moveBy(0, -Integer.parseInt(objConstructorPage.getBunsHeaderMarginTop().replace("px", "")));

        objConstructorPage.clickStuffingsNavItem();
        assertEquals(topLeftCoordinates, objConstructorPage.getStuffingsHeaderCoordinates());

        objConstructorPage.clickSaucesNavItem();
        assertEquals(topLeftCoordinates, objConstructorPage.getSaucesHeaderCoordinates());

        objConstructorPage.clickBunsNavItem();
        assertEquals(topLeftCoordinates, objConstructorPage.getBunsHeaderCoordinates());
    }
}

