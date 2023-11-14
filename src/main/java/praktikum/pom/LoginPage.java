package praktikum.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public final static String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    private WebDriver driver;

    private By registerLink = By.xpath(".//a[contains(@href, '/register')]");
    private By loginButton = By.xpath(".//button[contains(text(), 'Войти')]");
    private By loginHeader = By.xpath(".//h2[contains(text(), 'Вход')]");
    private By emailInput = By.xpath(".//label[contains(text(), 'Email')]/following-sibling::input");
    private By passwordInput = By.xpath(".//label[contains(text(), 'Пароль')]/following-sibling::input");
    private By passwordInputError = By.xpath(".//p[contains(text(), 'Некорректный пароль')]");
    private By resetPasswordLink = By.xpath(".//a[contains(@href, '/forgot-password')]");




    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void fillInLoginFields(String userEmail, String userPassword) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(emailInput)));
        driver.findElement(emailInput).sendKeys(userEmail);
        driver.findElement(passwordInput).sendKeys(userPassword);
    }

    public void clickRegisterLink() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(registerLink)));

        driver.findElement(registerLink).click();
    }

    public void clickLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(loginButton)));

        driver.findElement(loginButton).click();
    }

    public void clickResetPasswordLink() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(resetPasswordLink)));

        driver.findElement(resetPasswordLink).click();
    }

    public void waitForLoginFailure() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(passwordInputError)));
    }

}
