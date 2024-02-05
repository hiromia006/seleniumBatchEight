package test.selenium.class2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class SelectorsTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Relative Xpath
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("sadasdasdsad");
        Thread.sleep(2000);

        //name
        driver.findElement(By.name("password")).sendKeys("sadasdasdsad");
        Thread.sleep(2000);

        //linkText
        driver.findElement(By.linkText("Register")).click();
        Thread.sleep(2000);

        //partialLinkText
        driver.findElement(By.partialLinkText("n info?")).click();
        Thread.sleep(2000);

        //CSS Selector
        driver.findElement(By.cssSelector("input[id='firstName']")).sendKeys("dlkfndnf");
        driver.findElement(By.id("lastName")).sendKeys("dlsddskfndnf");
        driver.findElement(By.id("address.street")).sendKeys("dlsddskfn dfddnf");

        List<WebElement> webElements = driver.findElements(By.tagName("a"));
        for (WebElement webElement : webElements) {
            System.out.println(webElement.getText() + " " +webElement.getAttribute("href"));
        }

        driver.quit();

    }
}
