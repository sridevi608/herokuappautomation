import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class HerokoAppTest {
    WebDriver driver;

    @BeforeTest
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            waitForElementToBeClickable(driver, "//button[text()='Add Element']");
            driver.findElement(By.xpath("//button[text()='Add Element']")).click();
            waitForPresenceOfElementLocated(driver, "(//button[text()='Delete'])[" + (i + 1) + "]");
            Assert.assertTrue(driver.findElement(By.xpath("(//button[text()='Delete'])[" + (i + 1) + "]")).isDisplayed());
        }
        driver.close();


    }

    public void waitForElementToBeClickable(WebDriver driver, String locator) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public void waitForPresenceOfElementLocated(WebDriver driver, String locator) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }
}
