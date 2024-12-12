package TestCases;

import Pages.addToCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class addToCartTC {

public final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();
@BeforeMethod
@Parameters(value = "Browser")
    public void setUp(@Optional("firefox") String browser)
    {
        switch (browser)
        {
            case "firefox":
                threadLocal.set(new FirefoxDriver());
                break;
            case "edge":
                threadLocal.set(new EdgeDriver());
                break;

            default:
                threadLocal.set(new ChromeDriver());
        }

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
