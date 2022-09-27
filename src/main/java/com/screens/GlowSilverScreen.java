package com.screens;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GlowSilverScreen extends Base {

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public GlowSilverScreen() {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@FindBy(xpath = "//XCUIElementTypeOther[@name='GLOW SILVER']")
	MobileElement glowSilverHeader;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Profile-GlowRewards-Silver-SeeBenefitsButton']")
	MobileElement seeBenfitsLink;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='GLOW GOLD']")
	MobileElement glowGoldHeader;

	@FindBy(xpath = "(//XCUIElementTypeOther)[22]")
	MobileElement backBtn;

	public void verifyGlowSilverScreen() {

		Reporter.log("verifying the silver reward screen please wait...!!!", true);

		wait.until(ExpectedConditions.visibilityOf(glowSilverHeader));
		Assert.assertTrue(glowSilverHeader.isEnabled());

		List<MobileElement> silverBenifits = driver.findElements(By.xpath("//XCUIElementTypeStaticText"));
		for (MobileElement benifits : silverBenifits) {
			if (benifits.getText().equals("Club Access Criteria")) {
				Assert.assertEquals(benifits.getText(), "Club Access Criteria");
			} else if (benifits.getText().equals("Glow Points Earned")) {
				Assert.assertEquals(benifits.getText(), "Glow Points Earned");
			} else if (benifits.getText().equals("Glow Point Value")) {
				Assert.assertEquals(benifits.getText(), "Glow Point Value");
			}

			else if (benifits.getText().equals("Program Enrollment Gift**")) {
				Assert.assertEquals(benifits.getText(), "Program Enrollment Gift**");
			} else if (benifits.getText().equals("Points Validity")) {
				Assert.assertEquals(benifits.getText(), "Points Validity");
			} else if (benifits.getText().equals("Earn & Burn")) {
				Assert.assertEquals(benifits.getText(), "Earn & Burn");
			} else if (benifits.getText().equals("You Are Already Glow Gold Member")) {
				Assert.assertEquals(benifits.getText(), "You Are Already Glow Gold Member");
			}

			// ReusableMethod.performScroll("TERMS", driver);
			else if (benifits.getText().equals("TERMS & CONDITIONS")) {
				Assert.assertEquals(benifits.getText(), "TERMS & CONDITIONS");
			} else if (benifits.getText().equals("No points will be awarded during Free Shopping,"))
				Assert.assertTrue(benifits.getText().contains("No points will be awarded during Free Shopping,"));
		}

		seeBenfitsLink.click();

		wait.until(ExpectedConditions.visibilityOf(glowGoldHeader));
		Assert.assertTrue(glowGoldHeader.isEnabled());

	}

}
