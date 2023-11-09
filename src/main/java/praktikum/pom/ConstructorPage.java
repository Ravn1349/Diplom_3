package praktikum.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorPage {
    public final static String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    private WebDriver driver;


    private By loginButton = By.xpath(".//button[contains(text(), 'Войти в аккаунт')]");
    private By orderButton = By.xpath(".//button[contains(text(), 'Оформить заказ')]");
    private By personalAccountLink = By.xpath(".//a[contains(@href, '/account')]");
    private By stuffingsNavItem = By.xpath(".//span[text()='Начинки']");
    private By saucesNavItem = By.xpath(".//span[text()='Соусы']");
    private By bunsNavItem = By.xpath(".//span[text()='Булки']");
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
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(stuffingsNavItem)));

        driver.findElement(stuffingsNavItem).click();
    }
    public void clickSaucesNavItem() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(saucesNavItem)));

        driver.findElement(saucesNavItem).click();
    }
    public void clickBunsNavItem() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(bunsNavItem)));

        driver.findElement(bunsNavItem).click();
    }

    public void waitForLoginSuccess() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(orderButton));
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
}
