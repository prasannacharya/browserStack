package com.screens;

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
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HamburgerScreen extends Base {

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public HamburgerScreen() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		jse.executeScript(
				"browserstack_executor: {\"action\": \"setSessionName\", \"arguments\": {\"name\":\"hamburgerMenuTest \" }}");

	}

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Hamburger-LoginButton']")
	WebElement loginBtn;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='v1.0.0']")
	WebElement versionNo;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Hamburger-RegisterButton']")
	WebElement Register;

	@FindBy(xpath = "(//XCUIElementTypeOther)[36]")
	WebElement shopNow;

	@FindBy(xpath = "(//XCUIElementTypeOther)[37]")
	WebElement glowReward;

	@FindBy(xpath = "(//XCUIElementTypeOther)[38]")
	WebElement checkOut;

	@FindBy(xpath = "(//XCUIElementTypeOther)[39]")
	WebElement hagEasyshopping;

	@FindBy(xpath = "(//XCUIElementTypeOther)[40]")
	WebElement bookService;

	@FindBy(xpath = "(//XCUIElementTypeOther)[41]")
	WebElement reorder;

	@FindBy(xpath = "(//XCUIElementTypeOther)[44]")
	WebElement skinExpert;

	@FindBy(xpath = "(//XCUIElementTypeOther)[45]")
	WebElement aboutUs;

	@FindBy(xpath = "(//XCUIElementTypeOther)[50]")
	IOSElement locateStore;

	@FindBy(xpath = "(//XCUIElementTypeOther)[47]")
	IOSElement help;

	@FindBy(xpath = "(//XCUIElementTypeOther)[48]")
	WebElement share;

	@FindBy(xpath = "(//XCUIElementTypeOther)[42]")
	WebElement glowstories;

	@FindBy(xpath = "(//XCUIElementTypeButton)[3]")
	WebElement hambugermenu;

	public void verifyHamBurgerMenus() {

		try {

			Reporter.log("Verifying the hamburger menus ......please wait.!!!....", true);

			wait.until(ExpectedConditions.visibilityOf(loginBtn));
			Assert.assertTrue(loginBtn.isEnabled());
			Assert.assertTrue(Register.isEnabled());
			Assert.assertTrue(shopNow.isEnabled());
			Assert.assertTrue(glowReward.isEnabled());

			Assert.assertTrue(checkOut.isEnabled());

			Assert.assertTrue(hagEasyshopping.isEnabled());

			Assert.assertTrue(bookService.isEnabled());

			Assert.assertTrue(reorder.isEnabled());

			ReusableMethod.scrollDown("bottom");

			Assert.assertTrue(aboutUs.isEnabled());

			Assert.assertTrue(locateStore.isEnabled());

			Assert.assertTrue(help.isEnabled());

			Assert.assertTrue(share.isEnabled());
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"HamBurgerMenus execution successfully !\"}}");

		} catch (Exception e) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Found issue in HamBurgerMenus Screen\"}}");

		}
	}

	public LoginScreen clickONLoginBtn() {
		wait.until(ExpectedConditions.visibilityOf(loginBtn));
		loginBtn.click();
		return new LoginScreen();

	}

	public LocateStroreScreen locateStoreObj() {
		try {
			Thread.sleep(2000);
			ReusableMethod.performScroll(locateStore);
			locateStore.click();
		} catch (Exception e) {
			e.getCause();
		}
		return new LocateStroreScreen();

	}

	public RegisterScreen clickOnRegisterLink() {
		wait.until(ExpectedConditions.visibilityOf(Register));
		Register.click();
		return new RegisterScreen();
	}

}
