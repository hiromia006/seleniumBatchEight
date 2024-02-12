package test.selenium.class4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class NewTabAndWindow {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        System.out.println(driver.findElement(By.className("main-header")).getText());

        //Store the ID of the original window
        String originalWindow = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://demoqa.com/sample");
        Thread.sleep(2000);
        System.out.println("New Tab : " + driver.findElement(By.id("sampleHeading")).getText());
        driver.close();
        driver.switchTo().window(originalWindow);
        Thread.sleep(2000);


        //Store the ID of the original window
        String originalWindow2 = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://demoqa.com/sample");
        Thread.sleep(2000);
        System.out.println("New Window : " + driver.findElement(By.id("sampleHeading")).getText());
        driver.close();
        driver.switchTo().window(originalWindow2);
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.className("main-header")).getText());


        driver.quit();
//        System.out.println("New Window : " + driver.findElement(By.id("sampleHeading")).getText());

    }
}
