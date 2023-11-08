package praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static praktikum.pom.ConstructorPage.MAIN_PAGE_URL;

public class BaseTest {

    static WebDriver driver;

    @Before
    public void startUp() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();

/*        driver = new FirefoxDriver();
        WebDriverManager.firefoxdriver().setup();*/

        driver.get(MAIN_PAGE_URL);
    }

    @After
    public void quit() {
        driver.quit();
    }
}
