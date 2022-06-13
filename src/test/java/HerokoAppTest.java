import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
            driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        }
        for (int i = 1; i <= 10; i++) {
            Assert.assertTrue(driver.findElement(By.xpath("(//button[text()='Delete'])[" + i + "]")).isDisplayed());
        }
        driver.close();


    }
}
