package com.screens;

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

public class LocateStroreScreen extends Base {

	WebDriverWait wait = new WebDriverWait(driver, 5);

	public LocateStroreScreen() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='StoreLocator-BackButton']")
	MobileElement backBtn;

	@FindBy(xpath  = "(//XCUIElementTypeOther)[20]")
	MobileElement storeSelectorDropDown;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Temporarily closed']")
	MobileElement termporarilyClosedTxt;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='StoreLocator-Navigate']")
	MobileElement navigateTxt;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Select city']")
	MobileElement selectCityHeader;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='No stores found']")
	MobileElement nostoresFound;

	@FindBy(xpath = "//XCUIElementTypeStaticText")
	MobileElement cityRes;

	public void verifyLocateStore() {
		Reporter.log("verifying the locate store  functionality..please wait..!!!", true);
		wait.until(ExpectedConditions.visibilityOf(backBtn));
	//	Assert.assertEquals(termporarilyClosedTxt.getText(), "Temporarily closed");
	//	Assert.assertTrue(navigateTxt.isEnabled());
		for (int i = 0; i < 2; i++) {
			storeSelectorDropDown.click();

			wait.until(ExpectedConditions.visibilityOf(selectCityHeader));
			Assert.assertEquals(selectCityHeader.getText(), "Select city");

			if (i == 0) {

				driver.findElement(By.xpath("(//XCUIElementTypeOther)[23]")).click();

				wait.until(ExpectedConditions.visibilityOf(navigateTxt));
				Assert.assertEquals(cityRes.getText(), "Brigade Road 1");
			} else {
				driver.findElement(By.xpath("(//XCUIElementTypeOther)[21]")).click();

				wait.until(ExpectedConditions.visibilityOf(navigateTxt));
				Assert.assertEquals(cityRes.getText().replaceAll(" ", ""), "Manipal");
			}
		}

	}

	public void verifyNoStoreFound() {
		Reporter.log("verifying the store not found scenario ..please wait..!!!", true);

		storeSelectorDropDown.click();
		wait.until(ExpectedConditions.visibilityOf(selectCityHeader));
		Assert.assertEquals(selectCityHeader.getText(), "Select city");
		driver.findElement(By.xpath("(//XCUIElementTypeOther)[24]")).click();
		wait.until(ExpectedConditions.visibilityOf(nostoresFound));
		Assert.assertEquals(nostoresFound.getText(), "No stores found");
	}

}
