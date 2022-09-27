package com.screens;

import java.util.List;

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

public class SettingScreen extends Base {

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public SettingScreen() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='BackButton']")
	MobileElement settingBackBrn;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='SETTINGS']")
	MobileElement settingHeader;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Profile-SettingsScreen-NotificationSettingButton']")
	MobileElement notificationBtn;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Profile-SettingsScreen-PasswordSettingButton']")
	MobileElement passwordRestBtn;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Profile-SettingsScreen-PolicySettingButton']")
	MobileElement policySettingBtn;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Profile-SettingsScreen-LogoutButton']")
	MobileElement logoutBtn;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='NOTIFICATIONS']") // Welcome-LoginForgotPasswordButton
	MobileElement notificationHeader;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='BackButton']")
	MobileElement BackBtn;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='CHANGE PASSWORD']")
	MobileElement chnagePwdHeadder;

	@FindBy(xpath = "//XCUIElementTypeSecureTextField[@name='ChangePasswordScreen-oldpassword']")
	MobileElement oldPwdField;

	@FindBy(xpath = "//XCUIElementTypeSecureTextField[@name='ChangePasswordScreen-newpassword']")
	MobileElement newPwdField;

	@FindBy(xpath = "//XCUIElementTypeSecureTextField[@name='ChangePasswordScreen-confirmnewpassword']")
	MobileElement confirmPwdfield;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='ChangePasswordScreen-changepasswordbtn']")
	MobileElement confirmChangePwdBtn;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='POLICIES']")
	MobileElement policiesHeader;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Profile-SettingsScreen-PrivacyPolicyButton']") // Welcome-LoginPasswordInput
	MobileElement privacySubTitle;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Profile-SettingsScreen-ShipmentPolicyButton']")
	MobileElement shipmentSubTitle;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Profile-SettingsScreen-ReturnAndRefundPolicyButton']")
	MobileElement returnRefundSubtitle;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Profile-SettingsScreen-TermsOfUsePolicyButton']")
	MobileElement termOfUseSubtitle;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='PRIVACY']")
	MobileElement privacyTitle;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='SHIPMENT']")
	MobileElement shipmentTitle;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='RETURN & REFUND']")
	MobileElement returnnRefundTitle;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='TERMS OF USE']")
	MobileElement termofUseTitle;

	@FindBy(xpath = "//XCUIElementTypeOther[@label='Contact Us:']")
	MobileElement contactUsText;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='p']")
	MobileElement contactUsDescprtion;

	@FindBy(xpath = "(//XCUIElementTypeStaticText)[60]")
	MobileElement contactEmail;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Profile-SettingsScreen-LogoutYesButton']")
	MobileElement logoutYes;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Profile-SettingsScreen-LogoutNoButton']")
	MobileElement logoutNo;

	@FindBy(xpath = "//XCUIElementTypeStaticText")
	MobileElement logoutMsg;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Home Home']")
	WebElement homeBtn;

	public void verifyNotification() {
		Reporter.log("verifying the notification functionality...Please wait...!!!", true);

		wait.until(ExpectedConditions.visibilityOf(settingHeader));
		Assert.assertTrue(settingHeader.isEnabled());
		notificationBtn.click();
		Assert.assertTrue(notificationHeader.isEnabled());
		List<MobileElement> notification = driver.findElements(By.xpath("//XCUIElementTypeStaticText"));

		for (MobileElement notifiy : notification) {
			if (notifiy.getText().equals("Push"))
				Assert.assertEquals(notifiy.getText(), "Push");
			else if (notifiy.getText().equals("Order Update")) {
				Assert.assertEquals(notifiy.getText(), "Order Update");

			} else if (notifiy.getText().equals("Shipment")) {
				Assert.assertEquals(notifiy.getText(), "Shipment");
			} else if (notifiy.getText().equals("Recommendations")) {
				Assert.assertEquals(notifiy.getText(), "Recommendations");

			}
		}

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}

		List<MobileElement> toggle = driver.findElements(By.xpath("//XCUIElementTypeOther"));
		for (int i = 26; i < 39; i++) {
			if (i == 26) {
				toggle.get(i).click();
			} else if (i == 30) {
				toggle.get(i).click();

			} else if (i == 34) {
				toggle.get(i).click();

			} else if (i == 38) {
				toggle.get(i).click();

			}
		}

		List<MobileElement> subtitle = driver.findElements(By.xpath("//XCUIElementTypeStaticText"));

		for (MobileElement title : subtitle) {
			if (title.getText().equals("Notifications about offers, deals on store & app")) {
				Assert.assertEquals(title.getText(), "Notifications about offers, deals on store & app");
			} else if (title.getText().equals("Notifications about your orders")) {
				Assert.assertEquals(title.getText(), "Notifications about your orders");
			} else if (title.getText().equals("Notifications update on shipment and delivery")) {
				Assert.assertEquals(title.getText(), "Notifications update on shipment and delivery");
			} else if (title.getText().equals("Product update and expert recommendations for you")) {
				Assert.assertEquals(title.getText(), "Product update and expert recommendations for you");

			}
		}
		BackBtn.click();
		wait.until(ExpectedConditions.visibilityOf(settingHeader));
	}

	public void samePwdVerification() {
		Reporter.log("verifying the duplicate password scenario...Please wait...!!!", true);

		wait.until(ExpectedConditions.visibilityOf(settingHeader));
		Assert.assertTrue(settingHeader.isEnabled());
		passwordRestBtn.click();
		Assert.assertTrue(chnagePwdHeadder.isEnabled());
		oldPwdField.sendKeys(prop.getProperty("password"));
		newPwdField.sendKeys(prop.getProperty("password"));
		confirmPwdfield.sendKeys(prop.getProperty("password"));
		confirmChangePwdBtn.click();
		/*
		 * wait.until(ExpectedConditions.visibilityOf(samePwdValidation));
		 * Assert.assertEquals(samePwdValidation.getText(), "New password should not be
		 * same as old password.");
		 */

		BackBtn.click();
		wait.until(ExpectedConditions.visibilityOf(settingHeader));
	}

	public void verifyinvalidPwdLenght() {
		Reporter.log("verifying the password length...Please wait...!!!", true);

		wait.until(ExpectedConditions.visibilityOf(settingHeader));
		Assert.assertTrue(settingHeader.isEnabled());
		passwordRestBtn.click();
		Assert.assertTrue(chnagePwdHeadder.isEnabled());
		String password = ReusableMethod.generatePassword();
		oldPwdField.sendKeys(prop.getProperty("password"));
		newPwdField.sendKeys(password + password + "122");
		confirmPwdfield.sendKeys(password);
		/*
		 * confirmChangePwdBtn.click();
		 * wait.until(ExpectedConditions.visibilityOf(lenghtValidation));
		 * Assert.assertEquals(lenghtValidation.getText()
		 * ,"Password must contain minimum 8 and maximum 16 characters with at least, one alphabet, one numeric and one special character"
		 * );
		 */
		BackBtn.click();
		wait.until(ExpectedConditions.visibilityOf(settingHeader));
	}

	public void invalidRestPassword() {
		Reporter.log("verifying the invalid password scenario...Please wait...!!!", true);

		wait.until(ExpectedConditions.visibilityOf(settingHeader));
		Assert.assertTrue(settingHeader.isEnabled());
		passwordRestBtn.click();
		Assert.assertTrue(chnagePwdHeadder.isEnabled());
		String password = ReusableMethod.generatePassword();
		oldPwdField.sendKeys(prop.getProperty("password"));
		newPwdField.sendKeys(password);
		confirmPwdfield.sendKeys(password + "12");
		confirmChangePwdBtn.click();

		BackBtn.click();
		wait.until(ExpectedConditions.visibilityOf(settingHeader));
	}

	public void verifyRestPassword() {
		Reporter.log("verifying the rest password functionality...Please wait...!!!", true);

		wait.until(ExpectedConditions.visibilityOf(settingHeader));
		Assert.assertTrue(settingHeader.isEnabled());
		passwordRestBtn.click();
		Assert.assertTrue(chnagePwdHeadder.isEnabled());
		String password = ReusableMethod.generatePassword();
		oldPwdField.sendKeys(prop.getProperty("password"));
		newPwdField.sendKeys(password);
		confirmPwdfield.sendKeys(password);
		System.out.println(password);
		ReusableMethod.setValueToProperties(password);
		confirmChangePwdBtn.click();
		BackBtn.click();
		wait.until(ExpectedConditions.visibilityOf(settingHeader));
	}

	public void veifyPoliciesScreen() {
		Reporter.log("verifying the policies screen ...Please wait...!!!", true);

		wait.until(ExpectedConditions.visibilityOf(settingHeader));
		Assert.assertTrue(settingHeader.isEnabled());
		policySettingBtn.click();
		Assert.assertTrue(policiesHeader.isEnabled());
		privacySubTitle.click();
		Assert.assertTrue(privacyTitle.isEnabled());
		BackBtn.click();
		shipmentSubTitle.click();
		Assert.assertTrue(shipmentTitle.isEnabled());
		BackBtn.click();
		returnRefundSubtitle.click();
		Assert.assertTrue(returnnRefundTitle.isEnabled());
		BackBtn.click();
		termOfUseSubtitle.click();
		Assert.assertTrue(termofUseTitle.isEnabled());
		ReusableMethod.scrollDown("bottom");
		ReusableMethod.scrollDown("bottom");
		ReusableMethod.scrollDown("bottom");
		Assert.assertTrue(contactUsText.isEnabled());
		Assert.assertTrue(contactUsDescprtion.isEnabled());
		Assert.assertEquals(contactEmail.getText(), prop.getProperty("hngEmail"));
		BackBtn.click();
		BackBtn.click();
	}

	public void verifyLogout() {
		Reporter.log("verifying the logout functionality...Please wait...!!!", true);

		wait.until(ExpectedConditions.visibilityOf(settingHeader));
		Assert.assertTrue(settingHeader.isEnabled());
		logoutBtn.click();
		Assert.assertTrue(logoutMsg.getText().contains("Are you sure"));
		logoutNo.click();
		wait.until(ExpectedConditions.visibilityOf(settingHeader));
		logoutBtn.click();
		logoutYes.click();
		wait.until(ExpectedConditions.visibilityOf(homeBtn));

		Assert.assertTrue(homeBtn.isEnabled());

	}
}
