package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.Point;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConstructorTests extends BaseTest {

    @Test
    @DisplayName("sections Transitions check")
    @Description("проверка переходов к разделам «Булки», «Соусы», «Начинки» страницы «Конструктор» на основании изменения координат заголовков по нажатию на соответствующие табы")
    public void sectionsTransitions() {
        objConstructorPage.waitForConstructorPageLoad();

        Point topLeftCoordinates = objConstructorPage.getBunsHeaderCoordinates().moveBy(0, -Integer.parseInt(objConstructorPage.getBunsHeaderMarginTop().replace("px", "")));

        objConstructorPage.clickStuffingsNavItem();
        assertEquals(topLeftCoordinates, objConstructorPage.getStuffingsHeaderCoordinates());

        objConstructorPage.clickSaucesNavItem();
        assertEquals(topLeftCoordinates, objConstructorPage.getSaucesHeaderCoordinates());

        objConstructorPage.clickBunsNavItem();
        assertEquals(topLeftCoordinates, objConstructorPage.getBunsHeaderCoordinates());
    }
    @Test
    @DisplayName("tabs Transitions check")
    @Description("проверка изменения имён классов в верстке у табов «Булки», «Соусы», «Начинки» страницы «Конструктор» по нажатию на них")
    public void tabsTransitions() {
        objConstructorPage.waitForConstructorPageLoad();

        objConstructorPage.clickStuffingsNavItem();
        assertTrue(objConstructorPage.isCurrent(objConstructorPage.stuffingsTabItem));

        objConstructorPage.clickSaucesNavItem();
        assertTrue(objConstructorPage.isCurrent(objConstructorPage.saucesTabItem));

        objConstructorPage.clickBunsNavItem();
        assertTrue(objConstructorPage.isCurrent(objConstructorPage.bunsTabItem));
    }
}

