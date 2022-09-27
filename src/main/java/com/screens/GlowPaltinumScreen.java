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
import com.util.ReusableMethod;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GlowPaltinumScreen extends Base {

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public GlowPaltinumScreen() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@FindBy(xpath = "//XCUIElementTypeOther[@name='GLOW PLATINUM']")
	MobileElement glowPlatinum;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Profile-GlowRewards-Platinum-SeeBenefitsButton']")
	MobileElement seeBenfitsLink;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='GLOW TITANIUM']")
	MobileElement glowTitanium;

	@FindBy(xpath = "(//XCUIElementTypeOther)[22]")
	MobileElement backBtn;

	public void verifyGlowPlatinumScreen() {

		Reporter.log("verifying the platinum glow reward functionality...please wait...!!!!", true);

		wait.until(ExpectedConditions.visibilityOf(glowPlatinum));
		Assert.assertTrue(glowPlatinum.isEnabled());

		List<MobileElement> titaniumBenifits = driver.findElements(By.xpath("//XCUIElementTypeStaticText"));
		for (MobileElement benifits : titaniumBenifits) {
			if (benifits.getText().equals("Club Access Criteria")) {
				Assert.assertEquals(benifits.getText(), "Club Access Criteria");
			} else if (benifits.getText().equals("Glow Points Earned")) {
				Assert.assertEquals(benifits.getText(), "Glow Points Earned");
			} else if (benifits.getText().equals("Glow Point Value")) {
				Assert.assertEquals(benifits.getText(), "Glow Point Value");
			} else if (benifits.getText().equals("Program Enrollment Gift**")) {
				Assert.assertEquals(benifits.getText(), "Program Enrollment Gift**");
			} else if (benifits.getText().equals("Points Validity")) {
				Assert.assertEquals(benifits.getText(), "Points Validity");
			} else if (benifits.getText().equals("Gift Vouchers**")) {
				Assert.assertEquals(benifits.getText(), "Gift Vouchers**");
			} else if (benifits.getText().equals("Birthday Discounts**")) {
				Assert.assertEquals(benifits.getText(), "Birthday Discounts**");
			} else if (benifits.getText().equals("Next Club Is Glow Titanium")) {
				Assert.assertTrue(benifits.getText().contains("Next Club Is Glow Titanium"));
			}

		}

		seeBenfitsLink.click();

		wait.until(ExpectedConditions.visibilityOf(glowTitanium));
		Assert.assertTrue(glowTitanium.isEnabled());

	}
}
