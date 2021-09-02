package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComparePopUp {
    private WebDriver driver;
    private By compHeader = By.xpath(".//*[@id='top']/body/div[1]/div[1]/h1");
    private By compProduct1 = By.xpath("//a[normalize-space()='IPhone']");
    private By compProduct2 = By.xpath("//a[normalize-space()='Sony Xperia']");
    private By closeBtn = By.xpath("//button[@title='Close Window']");

    public ComparePopUp(WebDriver driver){
        this.driver = driver;
    }
    public String Product_Name1(){
        return driver.findElement(compProduct1).getText();
    }
    public String Product_Name2(){
        return driver.findElement(compProduct2).getText();
    }
    public String Header(){
        return driver.findElement(compHeader).getText();
    }
    public void closeBtn(){
        driver.findElement(closeBtn).click();
    }



}
