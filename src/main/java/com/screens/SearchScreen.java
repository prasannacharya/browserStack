package com.screens;

import com.base.Base;
import com.util.ReusableMethod;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class SearchScreen extends Base {

    WebDriverWait wait = new WebDriverWait(driver, 15);

    public  SearchScreen()
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//*[@name='qrcode']")
    MobileElement searchBtn;

    @FindBy(xpath = "//*[@name='Search']")
    MobileElement searchField;

    @FindBy(xpath = "//*[@name='Clear All']")
    MobileElement clearAllTxt;

    @FindBy(xpath = "//*[@name='RECENT SEARCH']")
    MobileElement recentTxt;

    @FindBy(xpath = "//*[@*='TRENDING']")
    MobileElement trending;

    @FindBy(xpath = "(//XCUIElementTypeOther)[33]")
    MobileElement closeSearch;

    @FindBy(xpath = "//*[@name='PDP-AddToBag']")
    MobileElement addToBag;

    @FindBy(xpath = "//*[@name='Added to bag']")
    MobileElement addedToBag;

    @FindBy(xpath = "//*[@name='Something went wrong! Please try again.']")
    MobileElement somethingwentWrongMsg;

    @FindBy(xpath = "//*[@name='VIEW BAG']")
    MobileElement viewBag;

    @FindBy(xpath = "//*[contains(@name,'BAG')]")
    MobileElement bagScrn;

    @FindBy(xpath = "//*[@name='QUICK FILTER']")
    MobileElement quickFilter;

    @FindBy(xpath = "//*[@name='BESTSELLER']")
    MobileElement bestSeller;

    @FindBy(xpath = "//*[@name='Lipstick']")
    MobileElement lipstick;

    @FindBy(xpath = "(//XCUIElementTypeOther)[73]")
    MobileElement product;
    
    public void  verify_Global_Search()
    {
        wait.until(ExpectedConditions.visibilityOf(trending));
        Assert.assertEquals(trending.getText(),"TRENDING");
      //  wait.until(ExpectedConditions.visibilityOf(recentTxt));
      //  Assert.assertEquals(recentTxt.getText(),"RECENT SEARCH");
        try
        {
        searchField.sendKeys("Face Wash");
        }
        catch (Exception e) {
        	driver.getKeyboard();
            searchField.sendKeys("Face Wash");

		}
        closeSearch.click();
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        //wait.until(ExpectedConditions.visibilityOf(recentTxt));
      //  Assert.assertEquals(recentTxt.getText(),"RECENT SEARCH");
        searchField.sendKeys("Lipstick");
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){
            e.getStackTrace();
        }
        List<MobileElement> searchResult = driver.findElements(By.className("XCUIElementTypeStaticText"));

        for(int i=1;i<searchResult.size();i++)
        {
            searchResult.get(i).isEnabled();
        }

//        for(int i=0;i<searchResult.size();i++)
//        {
//        if(i==0)
//            {
//                Assert.assertEquals(driver.findElement(By.xpath("//*[@name='Lipstick In All Brands']")).getText(),"Lipstick In All Brands");
//            }
//            else if(i==1)
//            {
//                Assert.assertEquals(driver.findElement(By.xpath("//*[@name='Lipstick In Lakme']")).getText(),"Lipstick In Lakme");
//            }
//            else if(i==2)
//            {
//                Assert.assertEquals(driver.findElement(By.xpath("//*[@name='Lipstick In Maybelline']")).getText(),"Lipstick In Maybelline");
//            }
//        }
//        try {
//           driver.findElement(By.xpath("//*[@name='Lipstick In All Brands']")).click();
//           driver.findElement(By.xpath("//*[@name='Lipstick In All Brands']")).click();
//
//        }
//        catch (Exception e)
//        {
//            e.getMessage();
//            driver.findElement(By.xpath("//*[@name='Lipstick In Lakme']")).click();
//        }

        try {
            Thread.sleep(1000);
            driver.findElement(By.xpath("(//XCUIElementTypeOther)[49]/XCUIElementTypeStaticText")).click();
            }
        catch (Exception e)
        {
            e.getMessage();
            driver.findElement(By.xpath("(//XCUIElementTypeOther)[61]/XCUIElementTypeStaticText")).click();
        }

        try {
            Thread.sleep(2000);
        }
        catch (Exception e){
            e.getStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOf(quickFilter));
        wait.until(ExpectedConditions.visibilityOf(bestSeller));
        product.click();
        product.click();
        
        addToBag.click();
        driver.findElement(By.xpath("(//XCUIElementTypeButton)[40]")).click();
//        try
//        {
//            wait.until(ExpectedConditions.visibilityOf(addedToBag));
//            Assert.assertEquals(addedToBag.getText(),"Added to bag");
//        }
//
//        catch (Exception e)
//        {
//            e.getMessage();
//            Assert.assertEquals(somethingwentWrongMsg.getText(),"Something went wrong! Please try again.");
//        }
//        viewBag.click();
//        try {
//            Thread.sleep(2000);
//        }
//        catch (Exception e){
//            e.getStackTrace();
//        }
//        wait.until(ExpectedConditions.visibilityOf(bagScrn));
//        Assert.assertTrue(bagScrn.getText().contains("BAG"));
//
//        List<MobileElement> label = driver.findElements(By.className("android.widget.TextView"));
//
//        for (MobileElement txt:label) {
//            if(txt.getText().contains("Lipstick")) {
//                Assert.assertTrue(txt.getText().contains("Lipstick"));
//                break;
//            }
//            else
//            {
//                Reporter.log("Item not added to bag==========",true);
//            }
//        }


    }


}
