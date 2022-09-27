package com.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.base.Base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegisterScreen extends Base {

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public RegisterScreen() {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

		jse.executeScript(
				"browserstack_executor: {\"action\": \"setSessionName\", \"arguments\": {\"name\":\"Login modal Test \" }}");

	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Hamburger-RegisterButton']")
	MobileElement registerLink;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='GET STARTED']")
	MobileElement getStartedLink;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Welcome-LoginWithFacebook']")
	MobileElement facebookLogin;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Welcome-LoginWithGoogle']")
	MobileElement googleLogin;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Welcome-RegisterWithMobile']")
	MobileElement mobileLogin;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Welcome-RegisterClose']")
	MobileElement welcomeLogin;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='WELCOME TO HEALTH & GLOW']")
	MobileElement welcomeTxt;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='Enter your mobile number']")
	MobileElement mobileNoPlaceHolder;

	@FindBy(xpath = "(//XCUIElementTypeOther)[95]")
	MobileElement registernextBtn;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Welcome-RegisterNextButton']")
	MobileElement registerNxt;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Welcome-RegisterBackButton']")
	MobileElement backBtn;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Welcome-RegisterEmailOrMobileInput']")
	MobileElement mobileInput;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='LOGIN']")
	MobileElement LoginTxt;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='Password']")
	MobileElement pwdPlaceholder;

	@FindBy(xpath = "(//XCUIElementTypeOther)[101]") // Welcome-LoginForgotPasswordButton
	MobileElement forgotPwd;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Welcome-LoginHideShowPasswordIcon']")
	MobileElement showPwd;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Welcome-LoginButton']") // Welcome-LoginButton
	MobileElement loginBtn;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Welcome-LoginBackButton']")
	MobileElement loginBackBtn;

	@FindBy(xpath = "//XCUIElementTypeTextField[@value='prasannaachar126@gmail.com']")
	MobileElement prefilledEmail;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Welcome-LoginPasswordInput']") // Welcome-LoginPasswordInput
	MobileElement inputPassword;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='FORGOT PASSWORD']")
	MobileElement forgotPwdScreenTxt;

	@FindBy(xpath = "//XCUIElementTypeTextField[@name='Welcome-ForgotPasswordEmailOrMobileInput']")
	MobileElement forgotPwdEmail;

	@FindBy(xpath = "//*[@*='An OTP is sent to this mobile number']")
	MobileElement OtpPlaceHolder;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Welcome-ForgotPasswordBackButton']")
	MobileElement forgotBackBtn;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Welcome-ForgotPasswordNextButton']")
	MobileElement forgotNxtBtn;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='ONE TIME PASSWORD']")
	MobileElement otpLabel;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='Enter OTP sent to prasannaachar126@gmail.com']")
	WebElement otpEmail;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Welcome-OTPBackButton']")
	MobileElement otpBackBtn;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Welcome-OTPVerifyButton']")
	MobileElement otpVerifytBtn;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Welcome-OTPResendButton']")
	MobileElement otpResend;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='Didn't received OTP?']")
	WebElement resendMsg;

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Enter OTP sent to')]")
	WebElement otpSendTo;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='The OTP entered is invalid! Please try again.']")
	WebElement otpMsg;

	@FindBy(xpath = "//*[@name='Welcome-RegisterClose']")
	MobileElement registerclose;
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	MobileElement CancelBtn;

	public String verifyRegisterScreen() {
		try {
			Reporter.log("Verifying the register screen please wait....!!!!", true);
			
			wait.until(ExpectedConditions.visibilityOf(getStartedLink));
			Assert.assertTrue(facebookLogin.isEnabled());
			Assert.assertTrue(googleLogin.isEnabled());
			Assert.assertTrue(mobileLogin.isEnabled());

			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Register Screen execution successfully !\"}}");

		} catch (Exception e) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Found a issue in Register Screen execution !\"}}");

		}
		return getStartedLink.getText();

	}

	public void clickOnFacebookLink() {
		Reporter.log("Verifying the facebook Link screen please wait....!!!!", true);

		wait.until(ExpectedConditions.visibilityOf(getStartedLink));
		Assert.assertTrue(facebookLogin.isEnabled());
		facebookLogin.click();
		wait.until(ExpectedConditions.visibilityOf(CancelBtn));
		CancelBtn.click();
		
	}

	public void clickOnGoogleLink() {
		Reporter.log("Verifying the googleLink screen please wait....!!!!", true);

		wait.until(ExpectedConditions.visibilityOf(getStartedLink));
		Assert.assertTrue(googleLogin.isEnabled());
		googleLogin.click();
		wait.until(ExpectedConditions.visibilityOf(CancelBtn));
		CancelBtn.click();
	//	registerclose.click();

	}

	public void registerWithMobile() {
		try {
			Reporter.log("Register with mobile  testcase is running please wait....!!!!", true);

			wait.until(ExpectedConditions.visibilityOf(getStartedLink));
			mobileLogin.click();
			wait.until(ExpectedConditions.visibilityOf(welcomeTxt));
			Assert.assertEquals(welcomeTxt.getText(), "WELCOME TO HEALTH & GLOW");
			Assert.assertEquals(mobileNoPlaceHolder.getText(), "Enter your mobile number");
			wait.until(ExpectedConditions.visibilityOf(OtpPlaceHolder));
			Assert.assertEquals(OtpPlaceHolder.getText(), "An OTP is sent to this mobile number");
			backBtn.click();
			wait.until(ExpectedConditions.visibilityOf(getStartedLink));
			Assert.assertEquals(getStartedLink.getText(), "GET STARTED");
			mobileLogin.click();
			wait.until(ExpectedConditions.visibilityOf(welcomeTxt));

			mobileInput.sendKeys(prop.getProperty("registerMobileNo"));
			registerNxt.click();
			wait.until(ExpectedConditions.visibilityOf(otpLabel));
			Assert.assertEquals(otpLabel.getText(), "ONE TIME PASSWORD");
			Assert.assertTrue(otpSendTo.getText().contains(prop.getProperty("registerMobileNo")));
			
//			Assert.assertEquals(resendMsg.getText(), "Didn't received OTP?");
//			for (int i = 90; i < 96; i++) {
//				WebElement otpFiled = driver.findElement(By.xpath("(//XCUIElementTypeOther)[" + i + "]"));
//				otpFiled.sendKeys("1");
//			}
//
//			otpVerifytBtn.click();
//			wait.until(ExpectedConditions.visibilityOf(otpMsg));
//			Assert.assertEquals(otpMsg.getText(), "'The OTP entered is invalid! Please try again.");

			otpBackBtn.click();
			wait.until(ExpectedConditions.visibilityOf(welcomeTxt));
			Assert.assertEquals(welcomeTxt.getText(), "WELCOME TO HEALTH & GLOW");
			backBtn.click();
			wait.until(ExpectedConditions.visibilityOf(getStartedLink));
			Assert.assertEquals(getStartedLink.getText(), "GET STARTED");
			registerclose.click();
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Register with Mobile execution successfully !\"}}");

		} catch (Exception e) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"found a issue in Register with Mobile execution  !\"}}");

		}
	}

}
