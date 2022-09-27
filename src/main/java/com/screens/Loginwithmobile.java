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

public class Loginwithmobile extends Base {

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public Loginwithmobile() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		jse.executeScript(
				"browserstack_executor: {\"action\": \"setSessionName\", \"arguments\": {\"name\":\"Login modal Test \" }}");

	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='LOGIN']")
	MobileElement welcomeTxt;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='Email or Mobile number']")
	MobileElement emilplaceHolder;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Welcome-LoginWithMobile']")
	MobileElement nxtBtn;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Welcome-LoginBackButton']")
	MobileElement backBtn;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Welcome-LoginEmailOrMobileInput']")
	MobileElement emailFiled;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='SIGN IN TO CONTINUE']")
	MobileElement loginTxt;

	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='Password']")
	MobileElement pwdPlaceholder;

	@FindBy(xpath = "(//XCUIElementTypeOther)[25]") // Welcome-LoginForgotPasswordButton
	MobileElement forgotPswd;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Welcome-LoginForgotPasswordButton']") // Welcome-LoginForgotPasswordButton
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
	MobileElement forgotScreenTxt;

	@FindBy(xpath = "(//XCUIElementTypeStaticText)[1]")
	MobileElement forgotPwdScreenTxt;

	@FindBy(xpath = "//XCUIElementTypeTextField[@name='Welcome-ForgotPasswordEmailOrMobileInput']")
	MobileElement forgotPwdEmail;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='An OTP is sent to both email and mobile number to reset your password']")
	MobileElement confirmTxt;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Welcome-ForgotPasswordBackButton']")
	MobileElement forgotBackBtn;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Welcome-ForgotPasswordNextButton']")
	MobileElement forgotNxtBtn;

	@FindBy(xpath = "//*[@name='Welcome-LoginEmailOrMobileInput']")
	MobileElement mobileLogin;

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

	@FindBy(xpath = "(//XCUIElementTypeStaticText)[15]")
	WebElement resendMsg;

	@FindBy(xpath = "(//XCUIElementTypeButton)[3]")
	WebElement hambugermenu;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='The OTP entered is invalid! Please try again.']")
	WebElement otpMsg;

	@FindBy(xpath = "(//XCUIElementTypeStaticText)[11]")
	WebElement otpValidation;
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
	MobileElement continueBtn;

	@FindBy(xpath = "//*[@name='Welcome-LoginBackButton']")
	MobileElement welcomeBackBtn;
	

	public ProfileScreen verifyLogin() {
		
		Reporter.log("Verify Login functionality please wait......!!!.....", true);

	//	wait.until(ExpectedConditions.visibilityOf(welcomeTxt));
//		backBtn.click();
	//	Assert.assertTrue(mobileLogin.isEnabled());
	//	mobileLogin.click();
	//	driver.hideKeyboard();
		wait.until(ExpectedConditions.visibilityOf(loginTxt));
		driver.getKeyboard();
		try {
			driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Welcome-LoginEmailOrMobileInput']"))
					.sendKeys(prop.getProperty("email"));

		} catch (Exception e) {
			emailFiled.sendKeys(prop.getProperty("email"));

			e.getCause();
			e.getMessage();
			e.printStackTrace();
		}
		nxtBtn.click();
		Assert.assertEquals(welcomeTxt.getText(), "LOGIN");
		Assert.assertTrue(pwdPlaceholder.isEnabled());
		try {
			WebElement pwd = driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Welcome-LoginPasswordInput']"));
			pwd.sendKeys(prop.getProperty("password"));

		} catch (Exception e) {

			inputPassword.sendKeys(prop.getProperty("password"));
			e.getCause();
			e.getMessage();
			e.printStackTrace();
		}
		loginBtn.click();

		try

		{
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//XCUIElementTypeButton")).click();
			ReusableMethod.horizontalSwipeByPercentage(0, 0.5, 0.8);
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Login with Mobile execution successfully !\"}}");

		} catch (Exception e) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Found issue in Login with Mobile execution \"}}");

			e.getCause();
			e.getMessage();
			e.printStackTrace();
		}
		// hambugermenu.click();
		return new ProfileScreen();

	}

	public void verifyForgotPassword() {
	
		driver.getKeyboard();
		Reporter.log("verifying the forgot password functionality please wait...!!!........", true);

		String email = prop.getProperty("email");
		wait.until(ExpectedConditions.visibilityOf(loginTxt));
		try {
			WebElement email_Filed = driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='Welcome-LoginEmailOrMobileInput']"));
			email_Filed.sendKeys(prop.getProperty("email"));
		} catch (Exception e) {

			//emailFiled.sendKeys(prop.getProperty("email"));
		
			mobileLogin.sendKeys(prop.getProperty("email"));
		}
		nxtBtn.click();
		Assert.assertEquals(welcomeTxt.getText(), "LOGIN");
		try
		{
		try {
				forgotPswd.click();
			} catch (Exception e) {
				Reporter.log("Inside the catch----clickin on the forgot link plese wait----", true);
				forgotPwd.click();
			}
			Assert.assertEquals(forgotPwdScreenTxt.getText(), "FORGOT PASSWORD");
			Assert.assertEquals(forgotPwdEmail.getText(), email);
			forgotNxtBtn.click();
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Forgot Password execution successfully !\"}}");
		}
		 catch (Exception ele) {

			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Found issue in forgot Password verification \"}}");

			ele.getCause();
			ele.getMessage();
			ele.printStackTrace();

		}
		
	}

	public void verifyOtpScreen() {

		Reporter.log("Verifying the  Otp functionality please wait....!!!..", true);
		try {
			for (int i = 15; i < 21; i++) {
				WebElement otpFiled = driver.findElement(By.xpath("(//XCUIElementTypeOther)[" + i + "]"));
				otpFiled.sendKeys("1");
			}

			Assert.assertEquals(otpLabel.getText(), "ONE TIME PASSWORD");
			Assert.assertTrue(otpEmail.getText().contains(prop.getProperty("email")));
			Assert.assertTrue(otpResend.isEnabled());
			// Assert.assertEquals(resendMsg.getText(), "Didn't received OTP?");

			System.out.println("After passing Otp" + otpVerifytBtn.isEnabled());

			System.out.println("before resend" + otpResend.isEnabled());
			otpResend.click();

			System.out.println("after resend" + otpResend.isEnabled());

			otpVerifytBtn.click();

			// wait.until(ExpectedConditions.visibilityOf(otpMsg));

			// Assert.assertEquals(otpValidation.getText(), "The OTP entered is invalid!
			// Please try again.");

			otpBackBtn.click();

			Assert.assertEquals(forgotPwdScreenTxt.getText(), "FORGOT PASSWORD");

			forgotBackBtn.click();
			wait.until(ExpectedConditions.visibilityOf(welcomeBackBtn));
			welcomeBackBtn.click();

			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Verify Otp execution successfully !\"}}");

		} catch (Exception e) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Found issue in Otp  verification \"}}");

			e.printStackTrace();
		}
	}

}
