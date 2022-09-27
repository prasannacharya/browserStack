package com.screens;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.base.Base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen extends Base {

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public LoginScreen() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		jse.executeScript(
				"browserstack_executor: {\"action\": \"setSessionName\", \"arguments\": {\"name\":\"Login modal Test \" }}");

	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='SIGN IN TO CONTINUE']")
	MobileElement loginTxt;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Welcome-LoginWithFacebook']")
	MobileElement facebookLogin;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Welcome-LoginWithGoogle']")
	MobileElement googlebookLogin;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Welcome-LoginWithMobile']")
	MobileElement mobileLogin;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Welcome-LoginWithFacebook']")
	MobileElement welcomeLogin;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	MobileElement cancel;
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
	MobileElement continueBtn;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Welcome-LoginClose']")
	MobileElement loginClose;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Welcome-LoginBackButton']")
	MobileElement back;

	public String verifyLoginScreen() {
		try {
			Reporter.log("Verifying the login popup....Please wait..!!!!", true);
			
			wait.until(ExpectedConditions.visibilityOf(loginTxt));
			Assert.assertEquals(loginTxt.getText(), "SIGN IN TO CONTINUE");
			Assert.assertTrue(facebookLogin.isEnabled());
			Assert.assertTrue(googlebookLogin.isEnabled());
			Assert.assertTrue(mobileLogin.isEnabled());
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Login modal execution successfully !\"}}");

		} catch (Exception e) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Found issue in Login Modal \"}}");

		}
		return loginTxt.getText();

	}

	public void clickOnFacebookLink() {
		Reporter.log("clicking on the Facebook Link Please wait....!!!", true);
		try {
			wait.until(ExpectedConditions.visibilityOf(loginTxt));
			facebookLogin.click();
			cancel.click();
			Reporter.log("Success..!!!!!", true);
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Facebook execution successfully !\"}}");

		} catch (Exception e) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Found issue in Facebook execution \"}}");

		}
	}

	public void clickOnGoogleLink() {
		try {
			Reporter.log("clicking on the Google Link Please wait....!!!", true);

			wait.until(ExpectedConditions.visibilityOf(loginTxt));
			googlebookLogin.click();
			cancel.click();
			Reporter.log("Success..!!!!!", true);
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Google execution successfully !\"}}");

		} catch (Exception e) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Found issue in Google execution \"}}");

		}
	}

	public Loginwithmobile LoginWithMobile(String actionName) {
		Reporter.log("clicking on the Mobile Link Please wait....!!!", true);

		try {
				wait.until(ExpectedConditions.visibilityOf(loginTxt));
			//	mobileLogin.click();

				//back.click();
				//loginClose.click();

			Reporter.log("Success..!!!!!", true);
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Login wit mobile execution successfully !\"}}");
		}
		catch (Exception e) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Found issue in login with Mobile execution \"}}");

		}
		return new Loginwithmobile();

	}
}
