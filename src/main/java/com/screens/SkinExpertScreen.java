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
import org.testng.Reporter;

import java.util.List;

public class SkinExpertScreen  extends Base {

    WebDriverWait wait = new WebDriverWait(driver, 10);


    @FindBy(xpath = "//*[@text='Know Your Skin']")
    MobileElement knowYourSkinTxt;

    @FindBy(xpath = "//*[contains(@text(),'Personalised']")
    MobileElement personalised;

    @FindBy(xpath = "//*[@name='START YOUR SKIN ANALYSIS']")
    MobileElement startSkinAnalysisBtn;

    @FindBy(xpath = "//*[@name='Customer Details']")
    MobileElement customerDetails;

    @FindBy(xpath = "//*[@label='analysis-name-val']")
    MobileElement nameFiled;

    @FindBy(xpath = "//*[@label='analysis-phone-val']")
    MobileElement phoneField;

    @FindBy(xpath = "//*[@label='analysis-email-val']")
    MobileElement emailField;

    @FindBy(xpath = "//*[@name='Please select any one of the mode to recieve update']")
    MobileElement selectOption;
//
//    @FindBy(xpath = "//*[@text='Please accept to receive updates.']")
//    MobileElement receiveUpdate;

    @FindBy(xpath = "//*[@name='What is your gender?']")
    MobileElement genderTxt;

    @FindBy(xpath = "//*[@name='What is your Age (in years)?']")
    MobileElement ageTxt;

    @FindBy(xpath = "//*[@name='Nature of work/ Profession?']")
    MobileElement natureTxt;

    @FindBy(xpath = "//*[@name='NEXT']")
    MobileElement nextBtn;

    @FindBy(xpath = "//*[@name='BACK']")
    MobileElement backBtn;

    @FindBy(xpath = "//*[@name='MALE' || @name='FEMALE']")
    MobileElement genderOption;

    @FindBy(xpath = "//*[@name='Do you use makeup?']")
    MobileElement makeUpTxt;

    @FindBy(xpath = "//*[@name='How often do you go under the sun?']")
    MobileElement oftenTxt;

    @FindBy(xpath = "//*[@name='What is your skin type?']")
    MobileElement skinTypeTxt;

    @FindBy(xpath = "//*[@name='How does your skin react to new skincare products?']")
    MobileElement skinProduct;

    @FindBy(xpath = "//*[@name='Skip Selfie']")
    MobileElement skipSelfie;

    @FindBy(xpath = "//*[@name='TAKE SELFIE']")
    MobileElement takeSelfie;

    @FindBy(xpath = "//*[@name='Instructions for good selfie']")
    MobileElement instruction;

    @FindBy(xpath = "//*[@name='What brings you to us?']")
    MobileElement bringUsTxt;

    @FindBy(xpath = "//*[@name='Do you experience any of the following undereye conditions?']")
    MobileElement conditions;

    @FindBy(xpath = "//*[@name='FINISH']")
    MobileElement finishBtn;

    @FindBy(xpath = "//*[@name='What else would you like assistance in?']")
    MobileElement assistanceTxt;

    @FindBy(xpath = "//*[name(@text,'This condition may occur due')]")
    MobileElement reasonsTxt;

    @FindBy(xpath = "//*[@name='Welcome Back']")
    MobileElement welcomeTxt;

    @FindBy(xpath = "//*[@name='Skin Analysis Result']")
    MobileElement resultTxt;

    @FindBy(xpath = "//*[@name='About My Skin']")
    MobileElement aboutSkin;

    @FindBy(xpath = "//*[@name='Skin Summary']")
    MobileElement summary;

    @FindBy(xpath = "//*[@name='How was your over all experience?']")
    MobileElement expr;

    @FindBy(className = "android.widget.EditText")
    MobileElement editBox;

    @FindBy(xpath = "//*[@text='SUBMIT']")
    MobileElement submit;

    @FindBy(xpath = "//*[@text='Choose an answer']")
    MobileElement answer;

    @FindBy(xpath = "//*[contains(@text,'Feedback')]")
    MobileElement successMsg;

    @FindBy(xpath = "//*[@name='MENU']")
    MobileElement menus;

    @FindBy(xpath = "//*[@text='My Skin Type, Conditions and Lifestyle']")
    MobileElement lifeStyleTxt;

    @FindBy(xpath = "//*[@text='Skin Summary']")
    MobileElement skinSummary;

    @FindBy(xpath = "//*[@text='BUY COMPLETE REGIME']")
    MobileElement buyComplete;

    @FindBy(xpath = "//*[@text='Skincare Regime Schedule for You']")
    MobileElement sheduled;

    @FindBy(xpath = "//*[@text='Night Care']")
    MobileElement nightCare;

    @FindBy(xpath = "//*[contains(@text,'sunscreen')]")
    MobileElement tips;


    @FindBy(xpath = "//*[@text='ADD ONS']")
    MobileElement addonceBtn;


    @FindBy(xpath = "//*[@text='CLEANSING']")
    MobileElement cleanBtn;


    @FindBy(xpath = "//*[@text='PROTECTION']")
    MobileElement protectionBtn;

    @FindBy(xpath = "//*[@text='TREATMENT']")
    MobileElement treatmentBtn;

    @FindBy(xpath = "//*[@text='SUNSCREEN']")
    MobileElement sunScreen;
    
    
    @FindBy(xpath = "//*[@name='Family']")
    MobileElement familyBtn;
    
    @FindBy(xpath = "//*[@name='Self']")
    MobileElement selfBtn;
    
    @FindBy(xpath = "//*[@name='Friend']")
    MobileElement friendBtn;
   
    @FindBy(xpath = "//*[@value='checkbox, checked']")
    MobileElement permissionCheckBox;
    
    @FindBy(xpath = "//*[@name='Please accept to receive updates.']")
    MobileElement receiveUpdate;
    
    @FindBy(xpath = "(//XCUIElementTypeButton)[13]")
    MobileElement retestBtn;

    @FindBy(xpath = "//*[@name='RETEST']")
    MobileElement feedback;

    public SkinExpertScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void verify_Skin_Expert_Screen() {
        wait.until(ExpectedConditions.visibilityOf(knowYourSkinTxt));
        Assert.assertEquals(knowYourSkinTxt.getText(), "Know Your Skin");
        //   System.out.println(personalised.getText());
        //  Assert.assertTrue(personalised.getText().contains("Personalised Regime"));
      //  ReusableMethod.performScroll("How it Works", driver);
        List<MobileElement> labels = driver.findElements(By.className("android.widget.TextView"));

        for (MobileElement txt : labels) {
            if (txt.getText().contains("Answer a few questions")) {
                Assert.assertEquals(txt.getText(), "Answer a few questions");
            } else if (txt.getText().contains("Upload Your Selfie")) {
                Assert.assertEquals(txt.getText(), "Upload Your Selfie");
            } else if (txt.getText().contains("Get your personalised skin care routine")) {
                Assert.assertEquals(txt.getText(), "Get your personalised skin care routine");
            } else if (txt.getText().contains("Use recommended regime for best results ")) {
                Assert.assertEquals(txt.getText(), "Use recommended regime for best results ");
            }
        }
      //  ReusableMethod.performScroll("START YOUR SKIN ANALYSIS", driver);
        Assert.assertEquals(startSkinAnalysisBtn.getText(), "START YOUR SKIN ANALYSIS");
        startSkinAnalysisBtn.click();
    }

    public void add_Customer_Details_Screen(String skinTestTakenTo) {
    	
    	  wait.until(ExpectedConditions.visibilityOf(welcomeTxt));
          Assert.assertEquals(welcomeTxt.getText(),"Welcome Back");
          Assert.assertEquals(resultTxt.getText(),"Skin Analysis Result");
          Assert.assertEquals(aboutSkin.getText(),"About My Skin");
          Assert.assertEquals(summary.getText(),"Skin Summary");
          wait.until(ExpectedConditions.visibilityOf(menus));
        //  ReusableMethod.swipeByElements(menus, welcomeTxt);
       //   wait.until(ExpectedConditions.visibilityOf(retestBtn));
          try
          {
        	  Thread.sleep(2000);
          } catch (Exception e) {
							}
          
       //   retestBtn.click();
          
          feedback.click();
         // ReusableMethod.tap_On_Element(62, 622);
        wait.until(ExpectedConditions.visibilityOf(customerDetails));
        Assert.assertEquals(customerDetails.getText(), "Customer Details");
        nameFiled.clear();
        nameFiled.sendKeys(prop.getProperty("customerName"));
        phoneField.clear();
        phoneField.sendKeys(prop.getProperty("customerPhoneNumber"));
       // ReusableMethod.performScroll("Email", driver);
        ReusableMethod.scrollDown("bottom");
        emailField.click();
        emailField.clear();
        emailField.sendKeys(prop.getProperty("customerEmail"));
        driver.hideKeyboard();
       
          Assert.assertEquals(selfBtn.getText(), "Self");
          Assert.assertEquals(familyBtn.getText(), "Family");
           Assert.assertEquals(friendBtn.getText(), "Friend");
            
        
            List<MobileElement> checkBox = driver.findElements(By.className("XCUIElementTypeOther"));

            permissionCheckBox.click();
            startSkinAnalysisBtn.click();
            try {
                Thread.sleep(1000);
                if(receiveUpdate.isEnabled())
                {
                	permissionCheckBox.click();
                	Assert.assertEquals(receiveUpdate.getText(), "Please accept to receive updates.");
                }
                else
                {
                	Reporter.log("permission is already given please continue=========",true);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            for (int i = 76; i < 83;) {
            	if(i==76)
            	{
                checkBox.get(i).click();
            	}
            	else if(i==79)
            	{
                    checkBox.get(i).click();
            	}
            	else if(i==82)
            	{
                    checkBox.get(i).click();
            	}
            	
              }
            startSkinAnalysisBtn.click();

            
            try {
                if (selectOption.isEnabled()) {
                    Reporter.log(selectOption.getText(), true);

                    for (int i = 76; i < 83;) {
                        checkBox.get(i).click();
                        startSkinAnalysisBtn.click();
                        break;
                    }
                }

            } catch (Exception e) {
                e.getMessage();
                }
            }
        

        public void personal_Details(String gender, int age, int index)
        {
            wait.until(ExpectedConditions.visibilityOf(genderTxt));
            Assert.assertEquals(genderTxt.getText(),"What is your gender?");
            Assert.assertEquals(ageTxt.getText(),"What is your Age (in years)?");

            if(gender.equalsIgnoreCase("male"))
            {
                driver.findElement(By.xpath("//*[@name='MALE']")).click();
            }
            else {
                genderOption.click();
            }
            ReusableMethod.scrollDown("bottom");
            Assert.assertEquals(natureTxt.getText(),"Nature of work/ Profession?");

            List<MobileElement> values = driver.findElements(By.className("XCUIElementTypeButton"));

            if(age<30)
            {
            	driver.findElement(By.xpath("//(XCUIElementTypeButton)[3]")).click();
            }
            else if(age>31 && age<41)
            {
            	driver.findElement(By.xpath("//(XCUIElementTypeButton)[4]")).click();
            }
            else if(age>41 && age<50)
            {
            	driver.findElement(By.xpath("//(XCUIElementTypeButton)[5]")).click();
            }
            else if(age>51 && age<60)
            {
            	driver.findElement(By.xpath("//(XCUIElementTypeButton)[6]")).click();
            }
            else if(age>60)
            {
            	driver.findElement(By.xpath("//(XCUIElementTypeButton)[7]")).click();
            }


            try {
                Thread.sleep(1500);
            }
            catch (Exception e)
            {
                e.getMessage();
            }
            if(index==1)
            {
            	driver.findElement(By.xpath("//(XCUIElementTypeButton)[8]")).click();
            }
            else  if(index==2){
            	driver.findElement(By.xpath("//(XCUIElementTypeButton)[9]")).click();
            }
            else if(index==3)
            {
            	driver.findElement(By.xpath("//(XCUIElementTypeButton)[10]")).click();

            }
            else
            {
            	driver.findElement(By.xpath("//(XCUIElementTypeButton)[11]")).click();

            }
            Assert.assertTrue(nextBtn.isEnabled());
            nextBtn.click();
        }

        public void verify_MakeUp_Screen(String yes_or_No, int selectIndex)
        {
            wait.until(ExpectedConditions.visibilityOf(makeUpTxt));
            Assert.assertEquals(makeUpTxt.getText(),"Do you use makeup?");
            Assert.assertEquals(oftenTxt.getText(),"How often do you go under the sun?");

            if(yes_or_No.equalsIgnoreCase("yes"))
            {
                driver.findElement(By.xpath("//*[@name='Yes']")).click();
            }
            else
            {
                driver.findElement(By.xpath("//*[@name='No']")).click();
            }
            ReusableMethod.scrollDown("bottom");

            List<MobileElement> button = driver.findElements(By.className("XCUIElementTypeButton"));
             for(int i=3;i<button.size();i++) {
             if (selectIndex==i) {
                 button.get(i).click();
                 break;
            } else if (selectIndex == i) {
                 button.get(i).click();
                 break;

             } else {
                 button.get(i).click();
                 break;
             }
         }
            Assert.assertTrue(nextBtn.isEnabled());
            nextBtn.click();
        }

        public void verify_Skin_Type(String skinType,int index)
        {
            wait.until(ExpectedConditions.visibilityOf(skinTypeTxt));
            Assert.assertEquals(skinTypeTxt.getText(),"What is your skin type?");
          
            if(index==1)
            {
            	driver.findElement(By.xpath("(//XCUIElementTypeOther)[41]")).click();
            }
            
            else  if(index==2)
            {
            	driver.findElement(By.xpath("(//XCUIElementTypeOther)[46]")).click();
            }
            
            else if(index==3)
            {
            	driver.findElement(By.xpath("(//XCUIElementTypeOther)[51]")).click();
            }
            else if(index==4)
            {
            	driver.findElement(By.xpath("(//XCUIElementTypeOther)[56]")).click();
            }
            else  if(index==5)
            {
            	driver.findElement(By.xpath("(//XCUIElementTypeOther)[61]")).click();
            }
            
            Assert.assertEquals(nextBtn.getText(),"NEXT");
            nextBtn.click();

            wait.until(ExpectedConditions.visibilityOf(skinProduct));
            Assert.assertEquals(skinProduct.getText(),"How does your skin react to new skincare products?");
            if(index==1)
            {
                driver.findElement(By.xpath("(//XCUIElementTypeOther)[40]")).click();
            }
            else if(index==2)
            {
                driver.findElement(By.xpath("(//XCUIElementTypeOther)[43]")).click();
            }
            else
            {
                driver.findElement(By.xpath("(//XCUIElementTypeOther)[45]")).click();
            }
            Assert.assertEquals(nextBtn.getText(),"NEXT");
            nextBtn.click();

            wait.until(ExpectedConditions.visibilityOf(instruction));
            Assert.assertEquals(instruction.getText(),"Instructions for good selfie");
            ReusableMethod.scrollDown("bottom");
            Assert.assertEquals(skipSelfie.getText(),"Skip Selfie");
            Assert.assertEquals(takeSelfie.getText(),"TAKE SELFIE");
            skipSelfie.click();
            wait.until(ExpectedConditions.visibilityOf(bringUsTxt));
            Assert.assertEquals(bringUsTxt.getText(),"What brings you to us?");
            List<MobileElement> button = driver.findElements(By.className("XCUIElementTypeButton"));
            for(int i=0;i<button.size();i++) {
                if ( i== 1) {
                    button.get(i).click();
                    nextBtn.click();
                    break;
                }
                else if (i == 2) {
                    button.get(i).click();
                    nextBtn.click();
                    wait.until(ExpectedConditions.visibilityOf(assistanceTxt));
                    Assert.assertEquals(assistanceTxt.getText(), "What else would you like assistance in?");
                    button.get(3).click();
                    nextBtn.click();
                    break;


                } else {
                    button.get(i).click();
                    nextBtn.click();
                    wait.until(ExpectedConditions.visibilityOf(assistanceTxt));
                    Assert.assertEquals(assistanceTxt.getText(), "What else would you like assistance in?");
                    button.get(1).click();
                    nextBtn.click();
                    break;
                }
            }

                wait.until(ExpectedConditions.visibilityOf(conditions));
                Assert.assertEquals(conditions.getText(),"Do you experience any of the following undereye conditions?");
                for(int i=1;i<button.size();i++) {

                    if (i==1) {
                        try {
                            button.get(i).click();
                        }
                        catch (Exception e)
                        {
                            driver.findElement(By.className("XCUIElementTypeButton")).click();

                        }
                        break;
                    } else if (i == 2) {
                        try {
                            button.get(i).click();
                        }
                        catch (Exception e)
                        {
                            driver.findElement(By.className("android.widget.Button")).click();
                        }
                        break;

                    } else if(i==3) {
                        try {
                            button.get(i).click();
                            }
                        catch (Exception e)
                        {
                            driver.findElement(By.className("android.widget.Button")).click();
                        }
                        break;
                    }
                    else if(i==4)
                    {
                        try {
                            button.get(i).click();
                        }
                        catch (Exception e)
                        {
                            driver.findElement(By.className("android.widget.Button")).click();
                        }
                        break;
                    }
                    else
                    {
                        try {
                            button.get(i).click();
                        }
                        catch (Exception e)
                        {
                            driver.findElement(By.className("android.widget.Button")).click();

                        }
                        break;

                    }
                }
                finishBtn.click();

            try
            {
                if(reasonsTxt.getText().contains("This condition may occur due"))
                {
                    Assert.assertTrue(reasonsTxt.getText().contains("This condition may occur due"));
                }
            }
            catch (Exception e)
            {
                wait.until(ExpectedConditions.visibilityOf(welcomeTxt));
                Assert.assertEquals(welcomeTxt.getText(),"Welcome Back");
                Assert.assertEquals(resultTxt.getText(),"Skin Analysis Result");
                Assert.assertEquals(aboutSkin.getText(),"About My Skin");
                Assert.assertEquals(summary.getText(),"Skin Summary");
            }

        }


    /*    public void  verify_Rating(int rating, int selectOption) {
            ReusableMethod.performScroll("How was your over all experience?", driver);
            wait.until(ExpectedConditions.visibilityOf(expr));
            Assert.assertEquals(expr.getText(), "How was your over all experience?");
            List<MobileElement> ratingTxt = driver.findElements(By.className("android.widget.TextView"));

            for (MobileElement rate : ratingTxt) {
                if (rating > 3 && rate.getText().contains("Average")) {
                    rate.click();
                    break;
                } else if (rating < 3 && rate.getText().contains("Poor")) {
                    rate.click();
                    break;
                } else if (rating >= 5 && rate.getText().contains("Excellent")) {
                    rate.click();
                    break;
                }
            }
            ReusableMethod.scrollDown();
            ReusableMethod.scrollDown();
            // ReusableMethod.performScroll("Ease of understanding the application",driver);
            List<MobileElement> textview = driver.findElements(By.className("android.widget.TextView"));

            for (MobileElement text : textview) {

                if (text.getText().contains("Easy")) {
                    text.click();
                    wait.until(ExpectedConditions.visibilityOf(answer));
                    Assert.assertEquals(answer.getText(), "Choose an answer");
                    if (selectOption < 3) {
                        driver.findElement(By.xpath("//*[@text='Easy']")).click();
                    } else if (selectOption >= 3 && selectOption < 7) {
                        driver.findElement(By.xpath("//*[@text='Complicated']")).click();
                    } else if (selectOption >= 7 && selectOption < 10) {
                        driver.findElement(By.xpath("//*[@text='Answer options do not capture my concern']")).click();
                    } else if (selectOption >= 10 && selectOption < 13) {
                        driver.findElement(By.xpath("//*[@text='I was not sure of the answers to few questions']")).click();
                    } else {
                        driver.findElement(By.xpath("//*[@text='Others (Pl specify)']")).click();
                    }
                } else if (text.getText().contains("Quick")) {
                    try {
                        Thread.sleep(2000);
                        text.click();
                        System.out.println("clicked on quick ");
                        wait.until(ExpectedConditions.visibilityOf(answer));
                        Assert.assertEquals(answer.getText(), "Choose an answer");
                    } catch (Exception e) {
                        driver.findElement(By.xpath("//*[@text='Quick']")).click();
                        e.getMessage();
                    }
                    if (selectOption < 3) {
                        driver.findElement(By.xpath("//*[@text='Quick']")).click();
                    } else if (selectOption >= 3 && selectOption < 7) {
                        driver.findElement(By.xpath("//*[@text='Too many questions']")).click();
                    } else if (selectOption >= 7 && selectOption < 10) {
                        driver.findElement(By.xpath("//*[@text='Not interesting']")).click();
                    } else if (selectOption >= 10 && selectOption < 13) {
                        driver.findElement(By.xpath("//*[@text='Image capturing is difficult']")).click();
                    } else {
                        driver.findElement(By.xpath("//*[@text='Others (Pl specify)']")).click();
                    }
                } else if (text.getText().contains("Helpful")) {
                    try {
                        Thread.sleep(2000);
                        text.click();
                        System.out.println("clicked on Helpful ");
                        wait.until(ExpectedConditions.visibilityOf(answer));
                        Assert.assertEquals(answer.getText(), "Choose an answer");
                    } catch (Exception e) {
                        driver.findElement(By.xpath("//*[@text='Helpful']")).click();
                        e.getMessage();
                    }

                    if (selectOption < 3) {
                        driver.findElement(By.xpath("//*[@text='Helpful']")).click();
                    } else if (selectOption >= 3 && selectOption < 7) {
                        driver.findElement(By.xpath("//*[@text='Not clear']")).click();
                    } else if (selectOption >= 7 && selectOption < 10) {
                        driver.findElement(By.xpath("//*[@text='Needed more information']")).click();
                    } else if (selectOption >= 10 && selectOption < 13) {
                        driver.findElement(By.xpath("//*[@text='Didn’t refer it']")).click();
                    } else {
                        driver.findElement(By.xpath("//*[@text='Others (Pl specify)']")).click();
                    }
                } else if (text.getText().contains("Agree with the concern identified")) {
                    try {
                        Thread.sleep(2000);
                        text.click();
                        System.out.println("clicked on Agree with the concern identified ");
                        wait.until(ExpectedConditions.visibilityOf(answer));
                        Assert.assertEquals(answer.getText(), "Choose an answer");
                    } catch (Exception e) {
                        driver.findElement(By.xpath("//*[@text='Agree with the concern identified']")).click();
                        e.getMessage();
                    }

                    if (selectOption < 3) {
                        driver.findElement(By.xpath("//*[@text='Agree with the concern identified']")).click();
                    } else if (selectOption >= 3 && selectOption < 7) {
                        driver.findElement(By.xpath("//*[@text='Summary is clear']")).click();
                    } else if (selectOption >= 7 && selectOption < 10) {
                        driver.findElement(By.xpath("//*[@text='Recommendations are relevant']")).click();
                    } else if (selectOption >= 10 && selectOption < 13) {
                        driver.findElement(By.xpath("//*[@text='Tough to understand the report']")).click();
                    } else {
                        driver.findElement(By.xpath("//*[@text='Others (Pl specify)']")).click();
                    }

                }
            }
            //ReusableMethod.performScroll("SUBMIT",driver);
            ReusableMethod.scrollDown();
            ReusableMethod.scrollDown();
            editBox.sendKeys("supereb apps kudos to entire team");
            submit.click();
            try
            {
            Thread.sleep(3000);
            }
            catch (Exception e)
            {
                e.getMessage();
            }

            wait.until(ExpectedConditions.visibilityOf(successMsg));
            System.out.println("the message is-------"+successMsg.getText());
            Assert.assertTrue(successMsg.getText().contains("Feedback"));
        }

        public void verify_Menus()
        {
            ReusableMethod.performScroll("Welcome Back",driver);
            wait.until(ExpectedConditions.visibilityOf(welcomeTxt));
            Assert.assertEquals(welcomeTxt.getText(),"Welcome Back");
            Assert.assertEquals(resultTxt.getText(),"Skin Analysis Result");
            Assert.assertEquals(aboutSkin.getText(),"About My Skin");
            Assert.assertEquals(summary.getText(),"Skin Summary");
            wait.until(ExpectedConditions.visibilityOf(menus));

            Actions act=new Actions(driver);
            act.clickAndHold(menus).moveToElement(welcomeTxt).build().perform();
            int count=0;
            List<MobileElement> labels = driver.findElements(By.className("android.widget.TextView"));
            for (MobileElement txt:labels) {
                if (txt.getText().contains("About My Skin")) {

                    Assert.assertEquals(txt.getText(), "About My Skin");
                    txt.click();
                    Assert.assertEquals(txt.getText(), "About My Skin");
                    count++;

                } else if (txt.getText().contains("My Personalized Regime Kit")) {
                    wait.until(ExpectedConditions.visibilityOf(menus));
                    ReusableMethod.performScroll("Welcome Back",driver);
                    act.clickAndHold(menus).moveToElement(welcomeTxt).build().perform();
                    Assert.assertEquals(txt.getText(), "My Personalized Regime Kit");
                    txt.click();
                    Assert.assertEquals(txt.getText(), "My Personalized Regime Kit");
                    count++;

                } else if (txt.getText().contains("Recommended Products")) {
                    wait.until(ExpectedConditions.visibilityOf(menus));

                    act.clickAndHold(menus).moveToElement(skinSummary).build().perform();
                    Assert.assertEquals(txt.getText(), "Recommended Products");
                    txt.click();
                    Assert.assertEquals(txt.getText(), "Recommended Products");
                    count++;
                } else if (txt.getText().contains("My Regime Schedule")) {
                    wait.until(ExpectedConditions.visibilityOf(menus));

                    act.clickAndHold(menus).moveToElement(buyComplete).build().perform();
                    Assert.assertEquals(txt.getText(), "My Regime Schedule");
                    txt.click();
                    Assert.assertEquals(txt.getText(), "My Regime Schedule");
                    count++;
                } else if (txt.getText().contains("Concerns And Solutions")) {
                    wait.until(ExpectedConditions.visibilityOf(menus));

                    act.clickAndHold(menus).moveToElement(sheduled).build().perform();
                    Assert.assertEquals(txt.getText(), "Concerns And Solutions");
                    txt.click();
                    Assert.assertEquals(txt.getText(), "Concerns And Solutions");
                    count++;
                } else if (txt.getText().contains("Generic Skincare Tips")) {
                    wait.until(ExpectedConditions.visibilityOf(menus));

                    try {
                        act.clickAndHold(menus).moveToElement(nightCare).build().perform();
                    } catch (Exception e) {
                        MobileElement menu = driver.findElement(By.xpath("//*[@text='MENU']"));
                        act.clickAndHold(menu).moveToElement(nightCare).build().perform();
                    }
                    Assert.assertEquals(txt.getText(), "Generic Skincare Tips");
                    txt.click();
                    Assert.assertEquals(txt.getText(), "Generic Skincare Tips");
                    count++;
                } else if (txt.getText().contains("Feedback")) {
                    try {
                        wait.until(ExpectedConditions.visibilityOf(menus));

                        act.clickAndHold(menus).moveToElement(tips).build().perform();
                        Assert.assertEquals(txt.getText(), "Feedback");
                        txt.click();
                        wait.until(ExpectedConditions.visibilityOf(expr));
                        Assert.assertEquals(expr.getText(), "How was your over all experience?");
                    } catch (Exception e) {
                        wait.until(ExpectedConditions.visibilityOf(menus));

                        act.clickAndHold(menus).moveToElement(tips).build().perform();
                        Assert.assertEquals(txt.getText(), "Feedback");
                        txt.click();
                        wait.until(ExpectedConditions.visibilityOf(expr));
                        Assert.assertEquals(expr.getText(), "How was your over all experience?");
                    }
                    count++;
                }
                if(count==7)
                {
                    break;
                }
            }
            ReusableMethod.performScroll("Welcome Back",driver);
            wait.until(ExpectedConditions.visibilityOf(menus));
            act.clickAndHold(menus).moveToElement(welcomeTxt).build().perform();
            MobileElement retest = driver.findElement(By.xpath("//*[@text='RETEST']"));
            Assert.assertEquals(retest.getText(),"RETEST");
            retest.click();
            wait.until(ExpectedConditions.visibilityOf(customerDetails));
            Assert.assertEquals(customerDetails.getText(),"Customer Details");
            driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        }

        public void verify_Filter_Option()
        {
          //  ReusableMethod.performScroll("RECOMMENDED PRODUCTS",driver);
            ReusableMethod.performScroll("MUST",driver);
            cleanBtn.click();
            List<MobileElement> ele = driver.findElements(By.className("android.widget.TextView"));
            for (MobileElement element:ele) {
                if (element.getText().contains("FACE WASH")) {
                    Assert.assertEquals(element.getText(), "FACE WASH");
                } else if (element.getText().contains("FACE CLEANSER")) {
                    Assert.assertEquals(element.getText(), "FACE CLEANSER");
                }
            }
                   driver.findElement(By.xpath("//android.widget.HorizontalScrollView/following-sibling::android.view.ViewGroup")).click();

            for (MobileElement element:ele) {
                if (element.getText().contains("FACE SCRUB")) {
                    Assert.assertEquals(element.getText(), "FACE SCRUB");
                } else if (element.getText().contains("DEEP CLEANSER")) {
                    Assert.assertEquals(element.getText(), "DEEP CLEANSER");
                }
                else if (element.getText().contains("DEEP CLEANSER")) {
                    Assert.assertEquals(element.getText(), "TONER");
                }

            }

            protectionBtn.click();
           // wait.until(ExpectedConditions.visibilityOf(sunScreen));
            //Assert.assertEquals(sunScreen.getText(),"SUNSCREEN");

            treatmentBtn.click();
            driver.findElement(By.xpath("//android.widget.HorizontalScrollView/preceding-sibling::android.view.ViewGroup")).click();

            List<MobileElement> filter = driver.findElements(By.className("android.widget.TextView"));

            for (MobileElement element:filter) {
                if (element.getText().contains("MOISTURISER")) {
                    Assert.assertEquals(element.getText(), "MOISTURISER");
                } else if (element.getText().contains("DAY CREAM")) {
                    Assert.assertEquals(element.getText(), "DAY CREAM");
                }
            }
            driver.findElement(By.xpath("//android.widget.HorizontalScrollView/following-sibling::android.view.ViewGroup")).click();

            for (MobileElement element:ele) {
                if (element.getText().contains("NIGHT CREAM")) {
                    Assert.assertEquals(element.getText(), "NIGHT CREAM");
                } else if (element.getText().contains("SERUM")) {
                    Assert.assertEquals(element.getText(), "SERUM");
                }
                else if (element.getText().contains("UNDER EYE")) {
                    Assert.assertEquals(element.getText(), "UNDER EYE");
                }

            }

            try {
                addonceBtn.click();
            }
            catch (Exception e)
            {
                ReusableMethod.performScroll("ADD ONS",driver);
                addonceBtn.click();

            }
            driver.findElement(By.xpath("//android.widget.HorizontalScrollView/preceding-sibling::android.view.ViewGroup")).click();
            List<MobileElement> sort = driver.findElements(By.className("android.widget.TextView"));

            for (MobileElement element:sort) {
                if (element.getText().contains("SHEET MASK")) {
                    Assert.assertEquals(element.getText(), "SHEET MASK");
                } else if (element.getText().contains("FACE PACK")) {
                    Assert.assertEquals(element.getText(), "FACE PACK");
                }
            }
            driver.findElement(By.xpath("//android.widget.HorizontalScrollView/following-sibling::android.view.ViewGroup")).click();
            List<MobileElement> text = driver.findElements(By.className("android.widget.TextView"));

            for (MobileElement element:text) {
                if (element.getText().contains("FACIAL KIT")) {
                    Assert.assertEquals(element.getText(), "FACIAL KIT");
                } else if (element.getText().contains("MASSAGE CREAM")) {
                    Assert.assertEquals(element.getText(), "MASSAGE CREAM");
                }

            }

        }*/
            }

