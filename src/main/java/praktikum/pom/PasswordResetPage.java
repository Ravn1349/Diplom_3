package praktikum.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasswordResetPage {
    public final static String PASSWORD_RESET_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    private WebDriver driver;


    private By resetPasswordButton = By.xpath(".//button[contains(text(), 'Восстановить')]");
    private By loginLink = By.xpath(".//a[contains(@href, '/login')]");


    public PasswordResetPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickResetPasswordButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(resetPasswordButton)));

        driver.findElement(resetPasswordButton).click();
    }

    public void clickLoginLink() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(loginLink)));

        driver.findElement(loginLink).click();
    }

//    public void waitForLoginSuccess() {
//        new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(orderButton));
//    }


}
