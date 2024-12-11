package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class addToCartPage {

    public WebDriver driver ;

    public addToCartPage(WebDriver driver)
    {
        this.driver = driver ;
    }

    List<WebElement> productSelected ;
    String []itemNeed = {"Brocolli","Cauliflower","Cucumber","Beetroot"};
   public static int  p= 0 ;
    private final  By itemsNames = By.xpath("//h4[@class=\"product-name\"]") ;
    private final By cartIconNumbers = By.xpath("(//div/table//tr/td/strong)[1]");
    private final By cartIconPrice = By.xpath("(//div/table//tr/td/strong)[2]");
    private final By priceItemOnPordCard = By.cssSelector("div[class=\"product\"] p");
    public addToCartPage adding()
    {
        productSelected = driver.findElements(itemsNames); //30
        for(int i = 0 ; i<productSelected.size() ; i++)
        {
            String [] names = productSelected.get(i).getText().split("-");
            String itemText = names[0].trim();
            List itemList = Arrays.asList(itemNeed);
      if(itemList.contains(itemText))
            {
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                p+=Integer.parseInt(driver.findElements(priceItemOnPordCard).get(i).getText());
            }
        }
        return  this;
    }



    //assert on number of prod selected with the price in cart icon

    public String cartIconNumberss()
    {
        return driver.findElement(cartIconNumbers).getText();
    }

    public String arrSize()
    {
        return String.valueOf(itemNeed.length);
    }

    public boolean compareNumberItemSelected()
    {
     return cartIconNumberss().equals(arrSize());

    }



//assert on price in prod selected with the price in cart icon

    public String cartIconPrice()
    {
        return driver.findElement(cartIconPrice).getText();
    }
    public boolean comparePricesItemSelected()
    {
        System.out.println(p);
        return cartIconPrice().equals(String.valueOf(p));
    }



}
