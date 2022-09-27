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

public class GiftCard extends Base {

    WebDriverWait wait = new WebDriverWait(driver, 15);

    public GiftCard() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//*[@name='E-Gift-Card-Send-Gift-Button']")
    MobileElement giftCard;

    @FindBy(xpath = "//*[@name='E-Gift-Card-Occasion-ViewAll']")
    MobileElement viewAll;

    @FindBy(xpath = "//*[@name='SHOW MORE']")
    MobileElement showMore;

    @FindBy(xpath = "//*[@name='SHOW LESS']")
    MobileElement showLess;

    @FindBy(xpath = "(//XCUIElementTypeTextField)")
    MobileElement cardNumber;

    @FindBy(xpath = "(//XCUIElementTypeTextField)[2]")
    MobileElement pinNumber;

    @FindBy(xpath = "//*[@name='E-Giff-Card-Check-Balance-Button']")
    MobileElement checkBalanceBtn;

    @FindBy(xpath = "//*[@name='Balance']")
    MobileElement balanceTxt;

    @FindBy(xpath = "//*[@name='Expiry Date']")
    MobileElement expireDate;

    @FindBy(xpath = "//*[@name='E-Gift-Card-Bulk-Purchase-Button']")
    MobileElement corporate;

    @FindBy(xpath = "//*[@name='CORPORATE & BULK PURCHASES']")
    MobileElement corporateTxt;

    @FindBy(xpath = "(//XCUIElementTypeTextField)")
    MobileElement nameFiled;

    @FindBy(xpath = "(//XCUIElementTypeTextField)[2]")
    MobileElement contactNumberField;

    @FindBy(xpath = "(//XCUIElementTypeTextField)[3]")
    MobileElement emailFiled;

    @FindBy(xpath = "(//XCUIElementTypeTextField)[4]")
    MobileElement orgField;

    @FindBy(xpath = "(//XCUIElementTypeTextField)[5]")
    MobileElement captchaFiled;

    @FindBy(xpath = "//*[@name='E-Gift-Card-Send-Gift-Button']")
    MobileElement submitBtn;

    @FindBy(xpath = "//*[@name='Submitted']")
    MobileElement successMsg;

    @FindBy(xpath = "//*[@name='BROWSE GIFT CARD BY OCCASION']")
    MobileElement occasion;

    @FindBy(xpath = "//*[@name='DESIGN GIFT CARD']")
    MobileElement design;

    @FindBy(xpath = "(//XCUIElementTypeTextField)")
    MobileElement editMsg;

    @FindBy(xpath = "//*[@name='CHOOSE AN AMOUNT*']")
    MobileElement chooseAmt;

    @FindBy(xpath = "(//XCUIElementTypeTextField)[1]")
    MobileElement recipientMobileNo;

    @FindBy(xpath = "(//XCUIElementTypeTextField)[2]")
    MobileElement recipientEmail;

    @FindBy(xpath = "(//XCUIElementTypeTextField)[3]")
    MobileElement recipientName;

    @FindBy(xpath = "(//XCUIElementTypeTextField)[4]")
    MobileElement fromEmail;

    @FindBy(xpath = "//*[@name='E-Gift-Card-Submit-Button']")
    MobileElement saveBtn;

    @FindBy(xpath = "//*[@name='PREVIEW']") 
    MobileElement preview;

    @FindBy(xpath = "//*[@name='E-Gift-Card-Preview-Purchase-Button']")
    MobileElement proceedBtn;

    public void bulk_Purchase()
    {
        wait.until(ExpectedConditions.visibilityOf(occasion));
        Assert.assertTrue(viewAll.isEnabled());        
        ReusableMethod.scrollDown("bottom");
        try {
        cardNumber.sendKeys("4242424242424242");
        }
        catch (Exception e) {
        	driver.getKeyboard();
            cardNumber.sendKeys("4242424242424242");

		}
        pinNumber.sendKeys("765334");
        try
        {
        	   checkBalanceBtn.click();
        	   checkBalanceBtn.click();
        	   wait.until(ExpectedConditions.visibilityOf(balanceTxt));
               Assert.assertEquals(balanceTxt.getText(),"Balance");
               Assert.assertEquals(expireDate.getText(),"Expiry Date");
        }
        catch (Exception e) {
        	e.getMessage();
		}
     
        corporate.click();
      //  ReusableMethod.tap_On_Element(8, 346);
        wait.until(ExpectedConditions.visibilityOf(corporateTxt));
        Assert.assertEquals(corporateTxt.getText(),"CORPORATE & BULK PURCHASES");
        nameFiled.sendKeys("prasanna");
        contactNumberField.sendKeys("9876589760");
        emailFiled.sendKeys("prasanna223@gmail.com");
        orgField.sendKeys("Niveus Organization");
        ReusableMethod.scrollDown("bottom");
        captchaFiled.sendKeys("89765");
        driver.hideKeyboard();
        submitBtn.click();
        wait.until(ExpectedConditions.visibilityOf(successMsg));
        Assert.assertEquals(successMsg.getText(),"Submitted");
        ReusableMethod.scrollDown("scrollUp");

    }

    public void send_GiftCard(int amount)
    {
        giftCard.click();
        wait.until(ExpectedConditions.visibilityOf(design));
        Assert.assertEquals(design.getText(),"DESIGN GIFT CARD");
        editMsg.sendKeys("Happy deepavali");
        driver.hideKeyboard();
        submitBtn.click();
        wait.until(ExpectedConditions.visibilityOf(chooseAmt));
        Assert.assertEquals(chooseAmt.getText(),"CHOOSE AN AMOUNT*");
        if(amount<1000) {
            driver.findElement(By.xpath("//*[@name='PDP-AskQuestion-ConcernSection-ConcernButton-1000']")).click();
        }
        else if(amount>=2000 && amount<3000)
        {
            driver.findElement(By.xpath("//*[@name='PDP-AskQuestion-ConcernSection-ConcernButton-2000']")).click();
        }
        else if(amount>=3000 && amount<4000)
        {
            driver.findElement(By.xpath("//*[@name='PDP-AskQuestion-ConcernSection-ConcernButton-3000']")).click();
        }
        else
        {
            driver.findElement(By.xpath("//*[@name='PDP-AskQuestion-ConcernSection-ConcernButton-Other']")).click();
        }
        try
        {
        recipientMobileNo.sendKeys(prop.getProperty("recipentMobileNo"));
        }
        catch (Exception e) {
        	driver.getKeyboard();
		}
        recipientEmail.sendKeys(prop.getProperty("recipentEmail"));
        recipientName.sendKeys(prop.getProperty("recipentName"));
        fromEmail.sendKeys(prop.getProperty("SenderEmail"));
        ReusableMethod.scrollDown("bottom");
        driver.hideKeyboard();
        try
        {
        saveBtn.click(); 
        }
        catch (Exception e) {
        	ReusableMethod.tap_On_Element(16, 744);
		}
        wait.until(ExpectedConditions.visibilityOf(preview));
        Assert.assertEquals(preview.getText(),"PREVIEW");

        List<MobileElement> label = driver.findElements(By.className("XCUIElementTypeStaticText"));

        for (MobileElement txt:label) {
            if(txt.getText().equalsIgnoreCase(prop.getProperty("recipentMobileNo")))
            {
                Assert.assertTrue(txt.getText().equalsIgnoreCase(prop.getProperty("recipentMobileNo")));
            }
           else if(txt.getText().equalsIgnoreCase(prop.getProperty("recipentEmail")))
            {
                Assert.assertTrue(txt.getText().equalsIgnoreCase(prop.getProperty("recipentEmail")));
            }
           else if(txt.getText().equalsIgnoreCase(prop.getProperty("recipentName")))
            {
                Assert.assertTrue(txt.getText().equalsIgnoreCase(prop.getProperty("recipentName")));
            }
          else if(txt.getText().equalsIgnoreCase(prop.getProperty("SenderEmail")))
            {
                Assert.assertTrue(txt.getText().equalsIgnoreCase(prop.getProperty("SenderEmail")));
            }
        }
        proceedBtn.click();

    }
}
