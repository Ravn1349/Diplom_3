package praktikum.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorPage {
    public final static String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    private static final String CURRENT_TAB_CLASS = "current";
    private WebDriver driver;


    private By loginButton = By.xpath(".//button[contains(text(), 'Войти в аккаунт')]");
    private By orderButton = By.xpath(".//button[contains(text(), 'Оформить заказ')]");
    private By personalAccountLink = By.xpath(".//a[contains(@href, '/account')]");
    public By stuffingsTabItem = By.xpath(".//span[text()='Начинки']/ancestor::div[contains(@class, 'tab')]");
    public By saucesTabItem = By.xpath(".//span[text()='Соусы']/ancestor::div[contains(@class, 'tab')]");
    public By bunsTabItem = By.xpath(".//span[text()='Булки']/ancestor::div[contains(@class, 'tab')]");
    public By stuffingsHeader = By.xpath(".//h2[text()='Начинки']");
    private By saucesHeader = By.xpath(".//h2[text()='Соусы']");
    private By bunsHeader = By.xpath(".//h2[text()='Булки']");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(loginButton)));

        driver.findElement(loginButton).click();
    }

    public void clickPersonalAccountLink() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(personalAccountLink)));

        driver.findElement(personalAccountLink).click();
    }

    public void clickStuffingsNavItem() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(stuffingsTabItem)));

        driver.findElement(stuffingsTabItem).click();
    }
    public void clickSaucesNavItem() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(saucesTabItem)));

        driver.findElement(saucesTabItem).click();
    }
    public void clickBunsNavItem() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(bunsTabItem)));

        driver.findElement(bunsTabItem).click();
    }

    public void waitForLoginSuccess() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(orderButton));
    }

    public void waitForConstructorPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(loginButton));
    }

    public Point getBunsHeaderCoordinates() {
        return driver.findElement(bunsHeader).getLocation();
    }

    public String getBunsHeaderMarginTop() {
        return driver.findElement(bunsHeader).getCssValue("margin-top");
    }

    public Point getStuffingsHeaderCoordinates() {
        return driver.findElement(stuffingsHeader).getLocation();
    }

    public Point getSaucesHeaderCoordinates() {
        return driver.findElement(saucesHeader).getLocation();
    }

    public boolean isCurrent(By by) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(by));
        return driver.findElement(by).getAttribute("class").contains(CURRENT_TAB_CLASS);
    }
}
