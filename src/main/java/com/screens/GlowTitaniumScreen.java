package com.screens;


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

public class GlowTitaniumScreen extends Base {
	WebDriverWait wait = new WebDriverWait(driver, 10);

	public GlowTitaniumScreen() {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@FindBy(xpath = "//XCUIElementTypeOther[@name='GLOW TITANIUM']")
	MobileElement glowTitanum;
	@FindBy(xpath = "(//XCUIElementTypeOther)[20]")
	MobileElement backBtn;
	
	
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
	
	
	@FindBy(xpath = "//*[@name='Exclusive Surprises']")
	MobileElement exclusiveSurpriseTxt;
	
	@FindBy(xpath = "//*[@name='Bonus Glow Points']")
	MobileElement bonusTxt;
	
	
	
	

	public void verifyGlowTitaniumScreen() {
		Reporter.log("verifying the titanium glow reward..Please wait..!!!", true);

		wait.until(ExpectedConditions.visibilityOf(glowTitanum));
		Assert.assertTrue(glowTitanum.isEnabled());

		/*
		 * List<MobileElement> titaniumBenifits =
		 * driver.findElements(By.xpath("//XCUIElementTypeStaticText")); for
		 * (MobileElement benifits : titaniumBenifits) { if
		 * (benifits.getText().equals("Club Access Criteria")) {
		 * Assert.assertEquals(benifits.getText(), "Club Access Criteria"); } else if
		 * (benifits.getText().equals("Glow Points Earned")) {
		 * Assert.assertEquals(benifits.getText(), "Glow Points Earned"); } else if
		 * (benifits.getText().equals("Glow Point Value")) {
		 * Assert.assertEquals(benifits.getText(), "Glow Point Value"); } else if
		 * (benifits.getText().equals("Program Enrollment Gift**")) {
		 * Assert.assertEquals(benifits.getText(), "Program Enrollment Gift**"); } else
		 * if (benifits.getText().equals("Points Validity")) {
		 * Assert.assertEquals(benifits.getText(), "Points Validity"); } else if
		 * (benifits.getText().equals("Gift Vouchers**")) {
		 * Assert.assertEquals(benifits.getText(), "Gift Vouchers**"); } else if
		 * (benifits.getText().equals("Birthday Discounts**")) {
		 * Assert.assertEquals(benifits.getText(), "Birthday Discounts**"); } else if
		 * (benifits.getText().equals("Earn & Burn")) {
		 * Assert.assertEquals(benifits.getText(), "Earn & Burn"); } else if
		 * (benifits.getText().equals("Exclusive Surprises")) {
		 * Assert.assertEquals(benifits.getText(), "Exclusive Surprises"); } else if
		 * (benifits.getText().equals("Bonus Glow Points")) {
		 * Assert.assertTrue(benifits.getText().contains("Bonus Glow Points")); }
		 * 
		 * }
		 */
		
		
		Assert.assertEquals(clubTxt.getText(), "Club Access Criteria");
		Assert.assertEquals(glowPointsEarnedTxt.getText(), "Glow Points Earned");
		Assert.assertEquals(glowPointValueTxt.getText(), "Glow Point Value");
		Assert.assertEquals(programEnrollmentTxt.getText(), "Program Enrollment Gift**");
		ReusableMethod.scrollDown("bottom");
		Assert.assertEquals(earnBurnTxt.getText(), "Earn & Burn");
		Assert.assertEquals(pointsValidityTxt.getText(), "Points Validity");
		Assert.assertEquals(giftVoucherTxt.getText(), "Gift Vouchers**");
		Assert.assertEquals(birthdayDiscountTxt.getText(), "Birthday Discounts**");
		Assert.assertEquals(exclusiveSurpriseTxt.getText(), "Exclusive Surprises");
		Assert.assertEquals(bonusTxt.getText(), "Bonus Glow Points");

		for (int i = 0; i < 5; i++) {
			backBtn.click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
