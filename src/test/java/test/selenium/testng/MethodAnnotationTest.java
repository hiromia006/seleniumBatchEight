package test.selenium.testng;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MethodAnnotationTest extends BaseMethodTest {

    @Test
    public void loginShouldSucceed() throws InterruptedException {
        //id
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();
        String login = driver.findElement(By.id("logout_sidebar_link")).getText().trim();
        Assert.assertEquals(login, "Logout");

    }


    @Test
    public void checkFirstProduct() throws InterruptedException {
        //id
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();

        String productTittle = driver.findElement(By.className("inventory_item_name")).getText().trim();
        Assert.assertEquals(productTittle, "Sauce Labs Backpack");


    }

    @Test
    public void checkTittle(){
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }
}
