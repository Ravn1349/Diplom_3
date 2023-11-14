package praktikum.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static praktikum.pom.LoginPage.LOGIN_PAGE_URL;

public class RegisterPage {
    public final static String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    private WebDriver driver;

    private By nameInput = By.xpath(".//label[contains(text(), 'Имя')]/following-sibling::input");
    private By emailInput = By.xpath(".//label[contains(text(), 'Email')]/following-sibling::input");
    private By passwordInput = By.xpath(".//label[contains(text(), 'Пароль')]/following-sibling::input");
    private By registerButton = By.xpath(".//button[contains(text(), 'Зарегистрироваться')]");
    private By passwordInputError = By.xpath(".//p[contains(text(), 'Некорректный пароль')]");
    private By loginLink = By.xpath(".//a[contains(@href, '/login')]");



    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInRegistrationFields(String userName, String userEmail, String userPassword) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(nameInput)));
        driver.findElement(nameInput).sendKeys(userName);
        driver.findElement(emailInput).sendKeys(userEmail);
        driver.findElement(passwordInput).sendKeys(userPassword);
    }
    public void clickRegisterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(registerButton)));

        driver.findElement(registerButton).click();
    }

    public void clickLoginLink() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(loginLink)));

        driver.findElement(loginLink).click();
    }

    public void waitForRegistrationSuccess() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
    }

    public void waitForRegistrationFailure() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(passwordInputError)));
    }


}
