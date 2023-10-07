package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public abstract class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait25;
    private WebDriverWait wait20;
    private WebDriverWait wait10;
    private WebDriverWait wait5;
    private WebDriverWait wait3;

    @BeforeMethod
    protected void beforeMethod() {
        driver = BaseUtils.createDriver();
    }

    @AfterMethod
    protected void afterMethod() {
        driver.quit();
        wait25 = null;
        wait20 = null;
        wait10 = null;
        wait5 = null;
        wait3 = null;
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait25() {
        if (wait25 == null) {
            wait25 = new WebDriverWait(getDriver(), Duration.ofSeconds(25));
        }

        return wait25;
    }

    protected WebDriverWait getWait20() {
        if (wait20 == null) {
            wait20 = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        }

        return wait20;
    }

    protected WebDriverWait getWait10() {
        if (wait10 == null) {
            wait10 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        }

        return wait10;
    }

    protected WebDriverWait getWait5() {
        if (wait5 == null) {
            wait5 = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        }

        return wait5;
    }

    protected WebDriverWait getWait3() {
        if (wait3 == null) {
            wait3 = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        }

        return wait3;
    }
}
