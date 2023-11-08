package praktikum.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static praktikum.pom.ConstructorPage.MAIN_PAGE_URL;
import static praktikum.pom.LoginPage.LOGIN_PAGE_URL;

public class PersonalAccountPage {
    public final static String PERSONAL_ACCOUNT_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    private WebDriver driver;

    private By constructorLink = By.xpath(".//a[@href='/']");
    private By logo = By.xpath(".//a[@href='/']");
    private By logoutButton = By.xpath(".//button[text()='Выход']");


    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConstructorLink() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(constructorLink)));

        driver.findElement(constructorLink).click();
    }

    public void clickLogo() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(logo)));

        driver.findElement(logo).click();
    }

    public void clickLogoutButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(logoutButton)));

        driver.findElement(logoutButton).click();
    }

    public void waitForPersonalAccountLinkClickSuccess() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(PERSONAL_ACCOUNT_PAGE_URL));
    }

    public void waitForConstructorPageSuccess() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(MAIN_PAGE_URL));
    }

    public void waitForLoginPageSuccess() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
    }
}
