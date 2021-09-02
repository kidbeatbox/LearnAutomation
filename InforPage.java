package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InforPage {
    private WebDriver driver;
    private By priceProduct = By.className("price");

    public InforPage (WebDriver driver){
        this.driver = driver;
    }
    public String getPrice(){
        return driver.findElement(priceProduct).getText();
    }
}
