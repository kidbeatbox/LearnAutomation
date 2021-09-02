package Test;

import common.Wait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class Testcase {
    private WebDriver driver;
    private indexPage indexPage;
    private MobilePage mobilePage;
    private InforPage inforPage;
    private CheckoutPage checkoutPage;
    private ComparePopUp comparePopUp;
    private int screenShoot = 0;
    private String baseUrl;

    @BeforeTest
    public void setUp()throws Exception{
        System.setProperty("webdriver.gecko.driver","/Users/macintoshhd/Desktop/ecommerce_Auto/resource/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        baseUrl = "http://live.demoguru99.com/";
//        driver.get("http://live.demoguru99.com/index.php/");
    }
    @Test(priority = 1)
    public void testcase_1(){
        driver.get(baseUrl);
        indexPage = new indexPage(driver);
        System.out.println(indexPage.getTitlePage());
//        Assert.assertEquals(indexPage.getTiSage().contains("THIS IS DEMO SITE"));
        indexPage.clickMobile();
        mobilePage = new MobilePage(driver);
        System.out.println(mobilePage.getTitlePage());
        Assert.assertTrue(mobilePage.getTitlePage().contains("MOBILE"));
        mobilePage.selectDropDown("Name");
        System.out.println(mobilePage.itemsCount());
        screenShoot = screenShoot + 1 ;
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String nameFile = ("/Users/macintoshhd/Desktop/ecommerce_Auto/pic/Mobile Products are sorted" + screenShoot + ".png");
        try {
            FileUtils.copyFile(srcFile,new File(nameFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 2)
    public void testcase_2(){
        mobilePage = new MobilePage(driver);
        inforPage = new InforPage(driver);
        mobilePage.selectDropDown("Position");
        System.out.println(mobilePage.itemsCount());
        screenShoot = screenShoot + 1 ;
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String nameFile = ("/Users/macintoshhd/Desktop/ecommerce_Auto/pic/Mobile Products are sorted" + screenShoot + ".png");
        try {
            FileUtils.copyFile(srcFile,new File(nameFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Price of product: "+mobilePage.getPriceProduct());
        mobilePage.clickProduct();
        System.out.println("Price of product in information page "+inforPage.getPrice());
        inforPage.getPrice();
        Assert.assertEquals(mobilePage.getPriceProduct(),inforPage.getPrice());
    }
    @Test(priority = 3)
    public void testcase_3(){
        indexPage = new indexPage(driver);
        mobilePage = new MobilePage(driver);
        indexPage.clickMobile();
        mobilePage.clickAddToCart();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.inputQuality("1000");
        checkoutPage.getErrorMsg();
        System.out.println(checkoutPage.getErrorMsg());
        checkoutPage.emptyClick();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String nameFile = ("/Users/macintoshhd/Desktop/ecommerce_Auto/pic/Mess status Empty cart" + screenShoot + ".png");
        try {
            FileUtils.copyFile(srcFile,new File(nameFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Mess status Empty cart: "+checkoutPage.emptyMess());
    }
//    @Test(priority = 1)
//    public void testcase_4() throws Exception{
////        go to Web
//        driver.get(baseUrl);
//        indexPage = new indexPage(driver);
//        checkoutPage = new CheckoutPage(driver);
//        mobilePage = new MobilePage(driver);
//        comparePopUp = new ComparePopUp(driver);
//        System.out.println("Clicking on Mobile button");
//        indexPage.clickMobile();
////        mobilePage.selectDropDown("Price");
//        Thread.sleep(1000);
////        Get value title of IPhone and   @Test(priority = 1)
////    public void testcase_4() throws Exception{
//////        go to Web
////        driver.get(baseUrl);
////        indexPage = new indexPage(driver);
////        checkoutPage = new CheckoutPage(driver);
////        mobilePage = new MobilePage(driver);
////        comparePopUp = new ComparePopUp(driver);
////        System.out.println("Clicking on Mobile button");
////        indexPage.clickMobile();
//////        mobilePage.selectDropDown("Price");
////        Thread.sleep(1000);
//////        Get value title of IPhone and Sony
////        System.out.println("Product 1: "+ mobilePage.getMainMobile1());
////        System.out.println("Product 2: "+ mobilePage.getMainMobile2());
////        String main1 = mobilePage.getMainMobile1();
////        String main2 = mobilePage.getMainMobile2();
//////        Clicking on compare
////        System.out.println("Clicking on Add to Compare of Iphone");
////        System.out.println("Clicking on Add to Compare of Sony");
////        mobilePage.compareClick();
////        Thread.sleep(1000);
////        // switching to new window
////        for (String handle : driver.getWindowHandles()){
////            driver.switchTo().window(handle);
////        }
////        Thread.sleep(2000);
////        String strHead = ("COMPARE PRODUCTS");
////        System.out.println("Header of Popup "+comparePopUp.Header());
////        System.out.println("Product Iphone " + comparePopUp.Product_Name1());
////        System.out.println("Product Sony " +comparePopUp.Product_Name2());
////        try {
////            assertEquals(strHead,comparePopUp.Header());
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        try {
////            assertEquals(main1,comparePopUp.Product_Name1());
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        try {
////            assertEquals(main2,comparePopUp.Product_Name2());
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////
////        comparePopUp.closeBtn();
////        // switching to new window
////        for (String handle : driver.getWindowHandles()){
////            driver.switchTo().window(handle);
////        }
////    } Sony
//        System.out.println("Product 1: "+ mobilePage.getMainMobile1());
//        System.out.println("Product 2: "+ mobilePage.getMainMobile2());
//        String main1 = mobilePage.getMainMobile1();
//        String main2 = mobilePage.getMainMobile2();
////        Clicking on compare
//        System.out.println("Clicking on Add to Compare of Iphone");
//        System.out.println("Clicking on Add to Compare of Sony");
//        mobilePage.compareClick();
//        Thread.sleep(1000);
//        // switching to new window
//        for (String handle : driver.getWindowHandles()){
//            driver.switchTo().window(handle);
//        }
//        Thread.sleep(2000);
//        String strHead = ("COMPARE PRODUCTS");
//        System.out.println("Header of Popup "+comparePopUp.Header());
//        System.out.println("Product Iphone " + comparePopUp.Product_Name1());
//        System.out.println("Product Sony " +comparePopUp.Product_Name2());
//        try {
//            assertEquals(strHead,comparePopUp.Header());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            assertEquals(main1,comparePopUp.Product_Name1());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            assertEquals(main2,comparePopUp.Product_Name2());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        comparePopUp.closeBtn();
//        // switching to new window
//        for (String handle : driver.getWindowHandles()){
//            driver.switchTo().window(handle);
//        }
//    }
    @AfterTest
    public void tearDown() throws Exception {
//        Thread.sleep(2000);
        driver.quit();
    }
}
