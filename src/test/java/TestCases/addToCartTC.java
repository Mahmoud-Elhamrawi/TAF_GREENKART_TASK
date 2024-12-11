package TestCases;

import Pages.addToCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class addToCartTC {

public final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();
@BeforeMethod
    public void setUp()
    {
        threadLocal.set(new ChromeDriver());
        threadLocal.get().manage().window().maximize();
        threadLocal.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        threadLocal.get().get("https://rahulshettyacademy.com/seleniumPractise/#/");

    }


    @Test
    public void addToCartTC()  {
       new addToCartPage(threadLocal.get())
               .adding();
        Assert.assertTrue(new addToCartPage(threadLocal.get()).compareNumberItemSelected());
        Assert.assertTrue(new addToCartPage(threadLocal.get()).comparePricesItemSelected());

    }




    @AfterMethod
    public void tearDown()
    {
        threadLocal.get().quit();
        threadLocal.remove();
    }





}
