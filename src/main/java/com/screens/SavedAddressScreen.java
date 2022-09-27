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

public class SavedAddressScreen extends Base {

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public SavedAddressScreen() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		jse.executeScript(
				"browserstack_executor: {\"action\": \"setSessionName\", \"arguments\": {\"name\":\"Save Addreess Test \" }}");

	}

	

	@FindBy(xpath = "//XCUIElementTypeOther[@name='ADDRESS']")
	MobileElement addressTitle;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='SavedAddressesScreen-AddNewAddress']")
	MobileElement newAddressLink;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Allow While Using App']")
	MobileElement allow;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='CHOOSE DELIVERY ADDRESS']")
	MobileElement deliveryAddress;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Profile-SavedAddress-RemoveButton']")
	MobileElement removeBtn;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Profile-SavedAddress-EditButton']")
	MobileElement editBtn;

	@FindBy(xpath = "(//XCUIElementTypeStaticText)[2]")
	MobileElement addedRadioBtn;

	@FindBy(xpath = "(//XCUIElementTypeStaticText)[4]") // Welcome-LoginForgotPasswordButton
	MobileElement addedcities;

	@FindBy(xpath = "(//XCUIElementTypeButton)[1]")
	MobileElement backBtn;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='ADD NEW ADDRESS']") // Welcome-LoginButton
	MobileElement newAddressTitle;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Google Maps']")
	MobileElement myLocationBtn;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Profile-Address-SearchInput']")
	MobileElement searchAddress;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Profile-Address-UseCurrentLocation']") // Welcome-LoginPasswordInput
	MobileElement useCurentLocation;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='SEARCH RESULTS']")
	MobileElement searchResultText;

	@FindBy(xpath = "(//XCUIElementTypeOther)[56]")
	MobileElement resultPalce;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Profile-Address-SearchResult-0']")
	MobileElement resState;

	@FindBy(xpath = "(//XCUIElementTypeStaticText)[1]")
	MobileElement distric;

	@FindBy(xpath = "(//XCUIElementTypeStaticText)[2]")
	MobileElement state;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Profile-EditAddress-ChangeButton']") // Welcome-LoginButton
	MobileElement chnageAddresBtn;

	@FindBy(xpath = "//XCUIElementTypeTextField[@name='Profile-AddAddress-PincodeInput']")
	MobileElement pincode;

	@FindBy(xpath = "//XCUIElementTypeTextField[@name='Profile-AddAddress-NameInput']")
	MobileElement name;

	@FindBy(xpath = "//XCUIElementTypeTextField[@name='Profile-AddAddress-MobileNoInput']") // Welcome-LoginPasswordInput
	MobileElement mobileInput;

	@FindBy(xpath = "(//XCUIElementTypeStaticText)[6]")
	MobileElement contactPhoneNum;

	@FindBy(xpath = "//XCUIElementTypeTextField[@name='Profile-AddAddress-HouseInput']")
	MobileElement houseInput;

	@FindBy(xpath = "//XCUIElementTypeTextField[@name='Profile-AddAddress-LandmarkInput']")
	MobileElement landMark;

	@FindBy(xpath = "(//XCUIElementTypeOther)[84]")
	MobileElement prefilledcity;

	@FindBy(xpath = "(//XCUIElementTypeOther)[85]")
	MobileElement prefilledState;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Profile-AddAddress-AddressTypeHome']")
	MobileElement homeRadioBtn;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Profile-AddAddress-AddressTypeOffice']")
	MobileElement officeRadioBtn;

	@FindBy(xpath = "//*[@name='Profile-AddAddress-AddressTypeOther']")
	MobileElement othersRadioBtn;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='Save this address as']")
	MobileElement saveThisAddressTxt;

	@FindBy(xpath = "//*[@name='Profile-AddAddress-AddressTitle']")
	MobileElement otherTite;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='SAVE']")
	MobileElement saveAddress;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='EDIT ADDRESS']")
	MobileElement editAddressPage;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='UPDATE']")
	MobileElement updateBtn;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='Are you sure you want to remove this address?']")
	MobileElement removethisAdd;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='YES']")
	MobileElement yesBtn;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='NO']")
	MobileElement noBtn;

	@FindBy(xpath = "(//XCUIElementTypeOther)[47]")
	MobileElement closeModal;

	public void addSaveAddress() {
		try {
			Reporter.log("Adding the new address....Please wait....!!!!", true);
			wait.until(ExpectedConditions.visibilityOf(addressTitle));
			Assert.assertTrue(addressTitle.isEnabled());
			Assert.assertTrue(newAddressLink.isEnabled());
			newAddressLink.click();
			try
			{
			if(allow.isEnabled())
			{
				allow.click();
			}
			else
			{
				Reporter.log("permission already allowed=======",true);
			}
			}
			catch (Exception e) {
				e.getMessage();
			}
			Assert.assertTrue(newAddressTitle.isEnabled());
			searchAddress.click();
			driver.getKeyboard();
			searchAddress.sendKeys("udupi");
			ReusableMethod.hideKeyboard();
			Assert.assertTrue(useCurentLocation.isEnabled());
			Assert.assertEquals(searchResultText.getText(), "SEARCH RESULTS");
			// ReusableMethod.performScroll("SEARCH RESULTS", driver);
			// ReusableMethod.scrollDown("bottom");
			Assert.assertTrue(resState.isEnabled());
			resState.click();
			driver.getKeyboard();
			Reporter.log("found  the Address.....!!!!...", true);
			Assert.assertEquals(distric.getText(), "Udupi");
			Assert.assertEquals(state.getText(), "Karnataka, India");
			pincode.sendKeys("123456");
			name.sendKeys("KrishnaTemple");
			// ReusableMethod.performScroll("Landmark", driver);
			mobileInput.sendKeys("8760231567");
			ReusableMethod.scrollDown("bottom");
			ReusableMethod.hideKeyboard();

			Assert.assertEquals(contactPhoneNum.getText(), "This number will be used to contact you during delivery");
			driver.getKeyboard();
			houseInput.sendKeys("12££5$");
			Thread.sleep(1000);
			landMark.sendKeys("Near krishna Temple");
			ReusableMethod.hideKeyboard();
			ReusableMethod.scrollDown("bottom");
			// ReusableMethod.performScroll("SAVE", driver);
			Assert.assertTrue(prefilledcity.isEnabled());
			Assert.assertTrue(prefilledState.isEnabled());
			Assert.assertEquals(saveThisAddressTxt.getText(), "Save this address as");
			homeRadioBtn.click();
			// ReusableMethod.performScroll("Other", driver);
			saveAddress.click();
			Assert.assertEquals(deliveryAddress.getText(), "CHOOSE DELIVERY ADDRESS");
			Assert.assertTrue(addedRadioBtn.getText().contains("HOME"));
			Assert.assertEquals(addedcities.getText(), "Udupi, Karnataka, India");
			Reporter.log("successfully added the Address.....!!!!...", true);
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \" Add address Excecution Successful!!\"}}");

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Found issue in Add address Test\"}}");
		}

	}

	public void editAddress() {
		try {

			Reporter.log("editing the existing address....Please wait....!!!!", true);

			driver.getKeyboard();
			wait.until(ExpectedConditions.visibilityOf(addressTitle));
			Assert.assertTrue(addressTitle.isEnabled());
			Assert.assertTrue(editBtn.isDisplayed());
			editBtn.click();
			// allow.click();
			wait.until(ExpectedConditions.visibilityOf(editAddressPage));
			Assert.assertTrue(editAddressPage.isEnabled());
			// Assert.assertEquals(prefilledcity.getText(), "Udupi");
			Assert.assertTrue(chnageAddresBtn.isEnabled());
			chnageAddresBtn.click();
			driver.getKeyboard();
			searchAddress.click();
			searchAddress.sendKeys("bangalore");
			ReusableMethod.hideKeyboard();
			Assert.assertTrue(useCurentLocation.isEnabled());
			Assert.assertEquals(searchResultText.getText(), "SEARCH RESULTS");
//	ReusableMethod.performScroll("SEARCH RESULTS", driver);
			ReusableMethod.scrollDown("bottom");
			Assert.assertTrue(resState.isEnabled());
			resState.click();
			driver.getKeyboard();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			wait.until(ExpectedConditions.visibilityOf(editAddressPage));
			Assert.assertEquals(distric.getText(), "Bangalore");
			Assert.assertEquals(state.getText(), "Karnataka, India");
			pincode.sendKeys("193456");
			ReusableMethod.scrollDown("bottom");
			ReusableMethod.hideKeyboard();
			Assert.assertEquals(contactPhoneNum.getText(), "This number will be used to contact you during delivery");
			Assert.assertTrue(prefilledcity.isEnabled());
			// ReusableMethod.performScroll("Other", driver);
			// Assert.assertEquals(prefilledcity.getText(), "Bengaluru");
			Assert.assertEquals(saveThisAddressTxt.getText(), "Save this address as");
			othersRadioBtn.click();
			otherTite.clear();
			driver.getKeyboard();
			otherTite.sendKeys("TestingHub");
			ReusableMethod.hideKeyboard();
			ReusableMethod.scrollDown("bottom");
			updateBtn.click();

			Assert.assertEquals(deliveryAddress.getText(), "CHOOSE DELIVERY ADDRESS");
			System.out.println(addedRadioBtn.getText());
			Assert.assertTrue(addedRadioBtn.getText().contains("OTHER"));
			Assert.assertEquals(addedcities.getText(), "Bangalore, Karnataka, India");
			Reporter.log("successfully updated  the Address.....!!!!...");

			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Edit Address exceution successful...!!\"}}");

		} catch (

		Exception e) {
			e.printStackTrace();
			e.getCause();
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Found issue in Edit Address Test\"}}");
		}
	}

	public void deleteSavedAdress() {
		Reporter.log("deleteing the existing adress ....Please wait....!!!!", true);

		try {
			wait.until(ExpectedConditions.visibilityOf(addressTitle));
			Assert.assertTrue(addressTitle.isEnabled());
			removeBtn.click();
			Assert.assertEquals(removethisAdd.getText(), "Are you sure you want to remove this address?");
			noBtn.click();
			wait.until(ExpectedConditions.visibilityOf(addedRadioBtn));
			Assert.assertTrue(addedRadioBtn.getText().contains("OTHER"));
			removeBtn.click();
			yesBtn.click();
			try {
				addedRadioBtn.isEnabled();
			} catch (Exception e) {
				Reporter.log("Successfully deleted  the saved Address", true);
				backBtn.click();
			}

			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Delete  Address exceution successful...!!\"}}");

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Found issue in delete address Test\"}}");
		}

	}
}
