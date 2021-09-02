package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class MobilePage {
    private WebDriver driver;
    private By titlePage = By.xpath("//h1[contains(text(),'Mobile')]");
    private By dropDownSort = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/select[1]");
    private By itemCount = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li");
    private By imgProduct = By.id("product-collection-image-1");
    private By priceProduct = By.cssSelector("#product-price-1 > span.price");
    private By addToCart = By.xpath("//li[2]//div[1]//div[3]//button[1]");
    private By compareSony = By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[2]//a[1]");
    private By compareIphone = By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[2]//a[1]");
    private By compareBtn = By.xpath("//button[@title='Compare']//span//span[contains(text(),'Compare')]");
    private By mainMobile2 = By.xpath("//a[normalize-space()='Sony Xperia']");
    private By mainMobile1 = By.xpath("//a[normalize-space()='IPhone']");

    private int productCount = 0;

    public MobilePage(WebDriver driver){
        this.driver = driver;
    }
    public String getTitlePage(){
        return driver.findElement(titlePage).getText();
    }
    public void selectDropDown(String option){
        Select drpSort = new Select(driver.findElement(dropDownSort));
        drpSort.selectByVisibleText(option);
    }
    public String getPriceProduct(){
        return driver.findElement(priceProduct).getText();
    }
    public void clickProduct(){
        driver.findElement(imgProduct).click();
    }
    public void clickAddToCart(){
        driver.findElement(addToCart).click();
    }
    public int itemsCount(){
        return productCount = driver.findElements(itemCount).size();
    }
    public void compareClick()throws Exception{
        driver.findElement(compareIphone).click();
        Thread.sleep(1000);
        driver.findElement(compareSony).click();
        Thread.sleep(1000);
        driver.findElement(compareBtn).click();
    }
    public String getMainMobile1(){
        return driver.findElement(mainMobile1).getText();
    }
    public String getMainMobile2(){
        return driver.findElement(mainMobile2).getText();
    }
}
