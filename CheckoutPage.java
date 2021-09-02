package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    private WebDriver driver;
    private By QTY = By.xpath("//input[@title='Qty']");
    private By updateBtn = By.xpath("//button[@title='Update']");
    private By emptyBtn = By.xpath("//span[contains(text(),'Empty Cart')]");
    private By statusEmptyCart = By.cssSelector("div[class='page-title'] h1");
    private By errMsgCart = By.cssSelector("li[class='error-msg'] ul li span");
    private By totalPrice = By.cssSelector("td[class='product-cart-total'] span[class='price']");
    private By mobileBtn = By.xpath("//a[normalize-space()='Mobile']");
//    WebDriverWait wait = new WebDriverWait(driver,30);

    public CheckoutPage (WebDriver driver){
        this.driver = driver;
    }

    private void inputQTY (String num){
        driver.findElement(QTY).sendKeys(num);
    }
    private void clickUpdate(){
        driver.findElement(updateBtn).click();
    }
    public String emptyMess(){
        return driver.findElement(statusEmptyCart).getText();
    }
    public void emptyClick(){
        driver.findElement(emptyBtn).click();
    }
    public String getErrorMsg(){
        return driver.findElement(errMsgCart).getText();
    }

    public void inputQuality(String numQuality){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(QTY));
        inputQTY(numQuality);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(updateBtn));
        clickUpdate();
    }

    public void mobileClick()
    {
        driver.findElement(mobileBtn).click();
    }



}
