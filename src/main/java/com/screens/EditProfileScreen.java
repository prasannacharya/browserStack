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

public class EditProfileScreen extends Base {

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public EditProfileScreen() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		jse.executeScript(
				"browserstack_executor: {\"action\": \"setSessionName\", \"arguments\": {\"name\":\"Edit profile Test \" }}");

	}

	@FindBy(xpath = "//XCUIElementTypeOther[@name='EDIT PROFILE']")
	MobileElement editProfileTxt;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='BackButton']")
	MobileElement editBackBtn;

	@FindBy(xpath = "//XCUIElementTypeTextField[@name='EditProfileScreen-EditName']")
	MobileElement editName;

	@FindBy(xpath = "(//XCUIElementTypeTextField)[2]")
	MobileElement editPhoneNumber;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='EditProfileScreen-CallSupport']")
	MobileElement contactUs;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Date of Birth Date of Birth Welcome-Register-DOBInput']")
	MobileElement editDob;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='EditProfileScreen-Camera']")
	MobileElement cameraEle;

	@FindBy(xpath = "(//XCUIElementTypeOther)[33]")
	MobileElement uploadImg;

	@FindBy(xpath = "//*[@*='EditProfileScreen-Camera']")
	MobileElement uploadPhoto;

//	@FindBy(xpath = "//*[@name='EditProfileScreen-Camera']")
//	MobileElement uploadImg;

	@FindBy(xpath = "//XCUIElementTypeTextField[@name='EditProfileScreen-EditEmail']")
	MobileElement editEmail;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='EditProfileScreen-Male']")
	MobileElement maleRadioBtn;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='EditProfileScreen-Female']")
	MobileElement femaleRadio;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='EditProfileScreen-Others']")
	MobileElement editOtherRadio;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='EditProfileScreen-SaveDetails']")
	MobileElement saveDeatils;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='PROFILE']")
	MobileElement ProfileLabel;

	@FindBy(xpath = "(//XCUIElementTypeStaticText)[2]")
	MobileElement profileName;

//	@FindBy(className = "android.widget.Button")
//	MobileElement hambugermenu;
//	
//	@FindBy(xpath = "//android.widget.TextView[@index='3']") // Glow Gold Member
//	// android.view.ViewGroup[Hamburger-ProfileDetails
//	MobileElement memberName;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='camera']")
	MobileElement cameraOption;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='gallery']")
	MobileElement gallery;

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Choose a photo')]")
	MobileElement choosePhotoTxt;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Choose']")
	MobileElement confirmImage;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='Profile edited successfully!']")
	MobileElement successMsg;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Profile-ProfileScreen-EditButton']")
	MobileElement profileEdit;

	@FindBy(xpath = "//*[@*='Allow Access to All Photos']")
	MobileElement allowAccess;

	@FindBy(xpath = "(//XCUIElementTypeOther)[7]")
	MobileElement recent;

	@FindBy(xpath = "(//XCUIElementTypeImage)[2]")
	MobileElement imageSelection;

	public void verifyEditScreen() {
		try {

			Reporter.log("verifying the edit profile functionality...plese wait....!!!", true);
			
			wait.until(ExpectedConditions.visibilityOf(editProfileTxt));
			editBackBtn.click();
			Assert.assertTrue(ProfileLabel.isEnabled());
			profileEdit.click();
			Assert.assertTrue(editProfileTxt.isEnabled());
			Assert.assertTrue(editName.getText().equalsIgnoreCase(prop.getProperty("userName")));
			Assert.assertEquals(editPhoneNumber.getText(), prop.getProperty("phoneNumber"));
			// ReusableMethod.performScroll("Others", driver);
			Assert.assertEquals(editEmail.getText(), prop.getProperty("email"));
			Assert.assertTrue(contactUs.isEnabled());
//			maleRadioBtn.click();
			editName.clear();
			editName.sendKeys(prop.getProperty("editedName"));
			ReusableMethod.hideKeyboard();
			saveDeatils.click();
			wait.until(ExpectedConditions.visibilityOf(profileName));
			profileName.getText().equals(prop.getProperty("editedName"));
			profileEdit.click();
			editName.clear();
			editName.sendKeys(prop.getProperty("userName"));
			if (driver.isKeyboardShown()) {
				driver.hideKeyboard();
			}
			saveDeatils.click();
			wait.until(ExpectedConditions.visibilityOf(profileName));
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \" Profile Verification successfully !\"}}");

		} catch (Exception e) {

			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Found a issue in Profile verification. !\"}}");

		}

	}

	public void uploadProfileImage() {
		try {
			Reporter.log("verifying the uplod profile  functionality....Please wait...!!!!!",true);
			wait.until(ExpectedConditions.visibilityOf(profileEdit));
			profileEdit.click();
			wait.until(ExpectedConditions.visibilityOf(editProfileTxt));
			Assert.assertTrue(editProfileTxt.isEnabled());	
			uploadImg.click();
			//uploadPhoto.click();
			wait.until(ExpectedConditions.visibilityOf(choosePhotoTxt));
			Assert.assertEquals(choosePhotoTxt.getText(), "Choose a photo or take a new one");

			gallery.click();
			Reporter.log("Selected the gallery option.......", true);
			allowAccess.click();
			Reporter.log("Permission allowed.......", true);

			recent.click();
			imageSelection.click();
			Reporter.log("Selected the image.......", true);

			confirmImage.click();
			wait.until(ExpectedConditions.visibilityOf(saveDeatils));
			Reporter.log("Clicked on save btn.......", true);

			saveDeatils.click();
			wait.until(ExpectedConditions.visibilityOf(successMsg));
			Assert.assertEquals(successMsg.getText(), "Profile edited successfully!");
			
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \" Upload profile Verification successfully !\"}}");

		} catch (Exception e) {

			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Found a issue in  upload profile. !\"}}");
		}

	}

}
