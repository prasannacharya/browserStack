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

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LandingScreen extends Base {

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public LandingScreen() {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		jse.executeScript(
				"browserstack_executor: {\"action\": \"setSessionName\", \"arguments\": {\"name\":\"Java test \" }}");

	}

	// Page Factory - OR:
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Welcome-SkipButton']")
	WebElement skipBtn;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Welcome to']")
	WebElement welcomeToTxt;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='all new Health & Glow']")
	WebElement healthandGlowTxt;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Welcome-Onboarding-GetStartedButton']")
	WebElement getstaretdBtn;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Welcome-Onboarding-LoginButton']")
	WebElement loginBtn;

	@FindBy(className = "(XCUIElementTypeButton)[8]")
	WebElement homeBtn;

	@FindBy(xpath = "//*[@name='Shop Shop']")
	WebElement shopBtn;

	@FindBy(xpath  = "//*[@name='Offers Offers']")
	WebElement Offers;

	@FindBy(xpath   = "//*[@name='Profile Profile']")
	WebElement profile;

	@FindBy(xpath  = "//*[@name='Bag Bag']")
	WebElement bag;

	@FindBy(xpath = "//*[@name='HambergerMenuIcon']")
	MobileElement hambugermenu;

	@FindBy(xpath = "(//XCUIElementTypeButton)[4]")
	WebElement qrcode;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='SHOP']")
	WebElement shopScreen;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='OFFERS']")
	WebElement offerscreen;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='PROFILE']")
	WebElement profileScreen;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='BAG (0 ITEMS)']")
	WebElement bagScreen;

	@FindBy(xpath = "//XCUIElementTypeStaticTex[@name='HOME']")
	WebElement homeTxt;

	@FindBy(xpath = "(//XCUIElementTypeOther)[60]")
	WebElement panel;
	
	@FindBy(xpath = "//*[@name='Allow']")
	WebElement allow;
	
	@FindBy(xpath = "//*[@*='qrcode']")
	WebElement searchBtn;

	@FindBy(xpath = "//*[@name='Welcome-LoginClose']")
	WebElement loginClose;


	public void verifyLandingScreenLabels() {

		try {
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//XCUIElementTypeButton)[3]")).click();
			Reporter.log("Verifying the landing  screen----------!!!", true);
			wait.until(ExpectedConditions.visibilityOf(shopBtn));
			Assert.assertTrue(homeBtn.isEnabled());
			Assert.assertTrue(shopBtn.isEnabled());
			Assert.assertTrue(Offers.isEnabled());
			Assert.assertTrue(bag.isEnabled());
			Assert.assertTrue(profile.isEnabled());

			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Landing  screen execution successfully !\"}}");

		} catch (Exception e) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Found issue in Landing Screen\"}}");

		}
	}

	public void clickonfootermenu() {
		try {

			Reporter.log("Validating the footer menu ....Please wait....!!!!", true);
			shopBtn.click();
			wait.until(ExpectedConditions.visibilityOf(shopScreen));
			Assert.assertEquals(shopScreen.getText(), "SHOP");
			Offers.click();
			Assert.assertEquals(offerscreen.getText(), "OFFERS");
			profile.click();
			loginClose.click();
			Assert.assertEquals(profileScreen.getText(), "PROFILE");
			bag.click();
			Assert.assertTrue(bagScreen.getText().contains("BAG (0 ITEMS)"));
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Footer Menu execution successfully !\"}}");

		} catch (Exception e) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Found issue in Footer Menu\"}}");

		}
	}

	public HamburgerScreen clickOnHamburgerMenu()

	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(allow));
			if(allow.isEnabled())
			{
				Reporter.log("Please allow the permission=======",true);
				allow.click();
			}
			wait.until(ExpectedConditions.visibilityOf(welcomeToTxt));
			veriySplashScreen();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		Reporter.log("clicking the hamburgerMenu please wait......!!!", true);
		try {
			driver.findElement(By.xpath("(//XCUIElementTypeButton)[3]")).click();

			Thread.sleep(1500);

		} catch (Exception e) {
			e.printStackTrace();

		}
	//	hambugermenu.click();
		//System.out.println(hambugermenu.getId());
		driver.findElement(By.xpath("(//XCUIElementTypeButton)[3]")).click();
		//	ReusableMethod.horizontalSwipeByPercentage(0.3, 0.5, 0.3);

//		ProfileScreen prop = new ProfileScreen();
//		prop.checkUserStatus();
		return new HamburgerScreen();

	} 

	public void veriySplashScreen() {
		try {
			Reporter.log("Verifying the splash screen.....Please wait....!!!", true);

			try
			{
				wait.until(ExpectedConditions.visibilityOf(allow));
				if(allow.isEnabled())
				{
					Reporter.log("Please allow the permission=======",true);
					allow.click();
				}
			}
			catch (Exception e) {
				e.getMessage();
				Reporter.log("Permission  is allowed please continue=======",true);

			}
			wait.until(ExpectedConditions.visibilityOf(welcomeToTxt));
			Assert.assertEquals(welcomeToTxt.getText(), "Welcome to");
			Assert.assertEquals(healthandGlowTxt.getText(), "all new Health & Glow");
			Assert.assertTrue(loginBtn.isEnabled());
			Assert.assertTrue(getstaretdBtn.isEnabled());
			skipBtn.click();
			try
			{
				wait.until(ExpectedConditions.visibilityOf(allow));
			if(allow.isEnabled())
			{
				Reporter.log("Please allow the permission=======",true);
				allow.click();
			}
			}
			catch (Exception e) {
				e.getMessage();
				Reporter.log("Permission  is allowed please continue=======",true);

			}

			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Splash screen execution successfully !\"}}");

		} catch (Exception e) {
			e.getCause();
			e.getMessage();
			e.printStackTrace();
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Found issue in spalsh screen\"}}");

		}
	}
	
	
	public SearchScreen search_Obj()
	{
		driver.findElement(By.xpath("(//XCUIElementTypeButton)[3]")).click();

		wait.until(ExpectedConditions.visibilityOf(searchBtn));
		searchBtn.click();
		return new SearchScreen();
	}
}
