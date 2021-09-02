package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class indexPage {
    private WebDriver driver;
    private By mobileTitle = By.xpath("//a[contains(.,'Mobile')]");
    private By pageTitle = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]");

    public indexPage(WebDriver driver){
        this.driver = driver;
    }
    public String getTitlePage(){
        return driver.findElement(pageTitle).getText();
    }
    public void clickMobile(){
        driver.findElement(mobileTitle).click();
    }

}
