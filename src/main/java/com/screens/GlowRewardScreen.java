package com.screens;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.xmlbeans.impl.regex.REUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.base.Base;
import com.util.ReusableMethod;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GlowRewardScreen extends Base {

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public GlowRewardScreen() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@FindBy(xpath = "//XCUIElementTypeOther[@name='GLOW REWARDS']")
	MobileElement glowRewardHeader;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='GLOW PLATINUM']")
	MobileElement glowPlatinumHeader;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='GLOW SILVER']")
	MobileElement glowSilverHeader;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='GLOW GOLD']")
	MobileElement glowGoldHeader;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='GLOW TITANIUM']")
	MobileElement glowTitaniumHeader;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Glow-Screen-ViewHistoryBtn']")
	MobileElement viewHistry;

	@FindBy(xpath = "(//XCUIElementTypeStaticText)[2]")
	MobileElement goldMemberTxt;

	@FindBy(xpath = "//XCUIElementTypeStaticText")
	MobileElement heyTxt;

	@FindBy(xpath = "(//XCUIElementTypeStaticText)[12]")
	MobileElement benifitsTxt;

	@FindBy(xpath = "(//XCUIElementTypeStaticText)[35]") // Welcome-LoginPasswordInput
	MobileElement nextclub;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Profile-GlowRewards-Plan-SeeBenefitsButton']")
	MobileElement seeBenifitsLink;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='GLOW REWARD CLUBS']")
	MobileElement categoryTxt;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Profile-GlowRewards-RewardClub-Silver-KnowMoreButton']")
	MobileElement silverKnowlink;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Profile-GlowRewards-RewardClub-Gold-KnowMoreButton']")
	MobileElement goldLink;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Profile-GlowRewards-RewardClub-Platinum-KnowMoreButton']")
	MobileElement platinumKnowLink;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Profile-GlowRewards-RewardClub-Titanium-KnowMoreButton']")
	MobileElement titaniumKnowLnk;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='FAQs']")
	MobileElement faqs;

	@FindBy(xpath = "(//XCUIElementTypeOther)[21]")
	MobileElement backBtnP;

	@FindBy(xpath = "(//XCUIElementTypeOther)[20]")
	MobileElement bBtn;
	
	@FindBy(xpath = "//*[@name='Club Access Criteria']")
	MobileElement clubTxt;
	
	@FindBy(xpath = "//*[@name='Glow Points Earned']")
	MobileElement glowPointsEarnedTxt;
	
	@FindBy(xpath = "//*[@name='Glow Point Value']")
	MobileElement glowPointValueTxt;
	
	@FindBy(xpath = "//*[@name='Program Enrollment Gift**']")
	MobileElement programEnrollmentTxt;
	
	@FindBy(xpath = "//*[@name='Earn & Burn']")
	MobileElement earnBurnTxt;
	
	@FindBy(xpath = "//*[@name='Points Validity']")
	MobileElement pointsValidityTxt;
	
	
	@FindBy(xpath = "//*[@name='Gift Vouchers**']")
	MobileElement giftVoucherTxt;
	
	@FindBy(xpath = "//*[@name='Birthday Discounts**']")
	MobileElement birthdayDiscountTxt;
	
	

	public void verifyglowRewardScreen() {

		Reporter.log("verifying the glow reward functionality.....please wait...!!!", true);
		wait.until(ExpectedConditions.visibilityOf(glowRewardHeader));
		Assert.assertTrue(glowRewardHeader.isEnabled());
		Assert.assertTrue(viewHistry.isEnabled());
		Assert.assertTrue(heyTxt.getText().contains(prop.getProperty("userName")));
		Assert.assertEquals(goldMemberTxt.getText(), "Glow Silver Member");
		Assert.assertEquals(benifitsTxt.getText(), "YOUR GLOW GOLD BENEFITS");
		Assert.assertEquals(clubTxt.getText(), "Club Access Criteria");
		Assert.assertEquals(glowPointsEarnedTxt.getText(), "Glow Points Earned");
		Assert.assertEquals(glowPointValueTxt.getText(), "Glow Point Value");
		Assert.assertEquals(programEnrollmentTxt.getText(), "Program Enrollment Gift**");
		ReusableMethod.scrollDown("bottom");
		Assert.assertEquals(earnBurnTxt.getText(), "Earn & Burn");
		Assert.assertEquals(pointsValidityTxt.getText(), "Points Validity");
		Assert.assertEquals(giftVoucherTxt.getText(), "Gift Vouchers**");
		Assert.assertEquals(birthdayDiscountTxt.getText(), "Birthday Discounts**");


//		List<MobileElement> benifits = driver.findElements(By.xpath("//XCUIElementTypeStaticText"));
//
//		for (MobileElement goldB : benifits) {
//			int count = 0;
//
//			if (goldB.getText().contains("Club Access Criteria")) {
//				Assert.assertEquals(goldB.getText(), "Club Access Criteria");
//				count++;
//			} else if (goldB.getText().contains("Glow Points Earned")) {
//				Assert.assertEquals(goldB.getText(), "Glow Points Earned");
//				count++;
//			} else if (goldB.getText().contains("Glow Point Value")) {
//				Assert.assertEquals(goldB.getText(), "Glow Point Value");
//				count++;
//			} else if (goldB.getText().contains("Program Enrollment Gift**")) {
//				Assert.assertEquals(goldB.getText(), "Program Enrollment Gift**");
//				count++;
//			} else if (goldB.getText().contains("Glow Points Earned")) {
//				Assert.assertEquals(goldB.getText(), "Glow Points Earned");
//				count++;
//			} else if (goldB.getText().contains("Points Validity")) {
//				Assert.assertEquals(goldB.getText(), "Points Validity");
//				count++;
//			}
//			else if (goldB.getText().contains("Gift Vouchers**")) {
//				Assert.assertEquals(goldB.getText(), "Gift Vouchers**");
//				count++;
//			} else if (goldB.getText().contains("Birthday Discounts**")) {
//				Assert.assertEquals(goldB.getText(), "Birthday Discounts**");
//				count++;
//			}
//			if (count == 8) {
//				break;
//			}
//
//		}
		Assert.assertTrue(nextclub.getText().contains("Platinum"));
		seeBenifitsLink.click();
		wait.until(ExpectedConditions.visibilityOf(glowPlatinumHeader));
		Assert.assertTrue(glowPlatinumHeader.isEnabled());
		backBtnP.click();
		wait.until(ExpectedConditions.visibilityOf(glowRewardHeader));
		Assert.assertTrue(glowRewardHeader.isEnabled());
	}

	public void knowMoreLinktxt() {
		Reporter.log("verifying the know more link  functionality.....please wait...!!!", true);

		wait.until(ExpectedConditions.visibilityOf(glowRewardHeader));
		Assert.assertTrue(glowRewardHeader.isEnabled());
		ReusableMethod.scrollDown("bottom");
		silverKnowlink.click();
		wait.until(ExpectedConditions.visibilityOf(glowSilverHeader));
		Assert.assertTrue(glowSilverHeader.isEnabled());
		backBtnP.click();

		wait.until(ExpectedConditions.visibilityOf(glowRewardHeader));
		Assert.assertTrue(glowRewardHeader.isEnabled());

		goldLink.click();

		wait.until(ExpectedConditions.visibilityOf(glowGoldHeader));
		Assert.assertTrue(glowGoldHeader.isEnabled());
		backBtnP.click();

		wait.until(ExpectedConditions.visibilityOf(glowRewardHeader));
		Assert.assertTrue(glowRewardHeader.isEnabled());

		platinumKnowLink.click();
		wait.until(ExpectedConditions.visibilityOf(glowPlatinumHeader));
		Assert.assertTrue(glowPlatinumHeader.isEnabled());
		backBtnP.click();

		wait.until(ExpectedConditions.visibilityOf(glowRewardHeader));
		Assert.assertTrue(glowRewardHeader.isEnabled());

		titaniumKnowLnk.click();

		wait.until(ExpectedConditions.visibilityOf(glowTitaniumHeader));
		Assert.assertTrue(glowTitaniumHeader.isEnabled());

		backBtnP.click();

		wait.until(ExpectedConditions.visibilityOf(glowRewardHeader));
		Assert.assertTrue(glowRewardHeader.isEnabled());

	}

	public void veriyFaq()

	{
		Reporter.log("verifying the faq's functionality.....please wait...!!!", true);

		wait.until(ExpectedConditions.visibilityOf(glowRewardHeader));
		Assert.assertEquals(glowRewardHeader.getText(), "GLOW REWARDS");

		Assert.assertEquals(faqs.getText(), "FAQs");

		List<MobileElement> question = driver.findElements(By.xpath("//XCUIElementTypeStaticText"));

		for (MobileElement qtn : question) {

			if (qtn.getText().contains("Glow Rewards?")) {
				assertTrue(qtn.getText().contains("Glow Rewards?"));
			} else if (qtn.getText().contains("value of Glow Points?")) {
				assertTrue(qtn.getText().contains("value of Glow Points?"));

			} else {
				assertTrue(qtn.getText().contains("redeem my Glow Points?"));
			}
		}
	}

	public GlowSilverScreen silverPageObj() {

		wait.until(ExpectedConditions.visibilityOf(glowRewardHeader));
		ReusableMethod.scrollDown("bottom");
		ReusableMethod.scrollDown("bottom");
		Assert.assertTrue(glowRewardHeader.isEnabled());

		silverKnowlink.click();

		return new GlowSilverScreen();

	}

	public GlowPaltinumScreen PlantinumScrnObj() {

		
		  wait.until(ExpectedConditions.visibilityOf(glowRewardHeader));
		  Assert.assertTrue(glowRewardHeader.isEnabled());
		  ReusableMethod.scrollDown("bottom"); 
		  platinumKnowLink.click();
		 

		return new GlowPaltinumScreen();

	}

	public GlowGoldScreen goldScrnObj() {
		
		  wait.until(ExpectedConditions.visibilityOf(glowRewardHeader));
		  Assert.assertTrue(glowRewardHeader.isEnabled());
		  ReusableMethod.scrollDown("bottom");
		  ReusableMethod.scrollDown("bottom");
		  goldLink.click();
		return new GlowGoldScreen();

	}

	public GlowTitaniumScreen titaniumScrnObj() {
		
		  wait.until(ExpectedConditions.visibilityOf(glowRewardHeader)); 
		  Assert.assertTrue(glowRewardHeader.isEnabled());
		  ReusableMethod.scrollDown("bottom"); 
		   titaniumKnowLnk.click();
		 

		return new GlowTitaniumScreen();

	}

}
