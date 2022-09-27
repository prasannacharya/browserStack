package com.screens;

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

import java.util.HashMap;

public class ProfileScreen extends Base {

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public ProfileScreen() {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		jse.executeScript(
				"browserstack_executor: {\"action\": \"setSessionName\", \"arguments\": {\"name\":\"Profile Test \" }}");

	}

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Hamburger-ProfileDetails']") 
	MobileElement memberName;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='PROFILE']")
	MobileElement ProfileLabel;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Profile-ProfileScreen-EditButton']")
	MobileElement profileEdit;

	@FindBy(xpath = "(//XCUIElementTypeStaticText)[2]")
	MobileElement profileName;

	@FindBy(xpath = "(//XCUIElementTypeStaticText)[3]")
	MobileElement profilePhoneNumber;

	@FindBy(xpath = "(//XCUIElementTypeStaticText)[4]")
	MobileElement profileEmail;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Profile-ProfileScreen-VerifyEmailButton']")
	MobileElement profileVerify;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Profile-ProfileScreen-GlowPointsButton']")
	MobileElement profileGlowReward;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='EditProfileScreen-Camera']")
	MobileElement profileUpload;


	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='SKIN DETAILS']")
	MobileElement skinAnalysis;

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Hey!')]")
	MobileElement skinAnalysisDescprion;

	@FindBy(xpath = "(//XCUIElementTypeOther)[109]") // Welcome-LoginPasswordInput
	MobileElement MyOrderList;

	@FindBy(xpath = "(//XCUIElementTypeOther)[110]")
	MobileElement mySubScrption;

	@FindBy(xpath = "(//XCUIElementTypeOther)[111]")
	MobileElement myPayments;

	@FindBy(xpath = "(//XCUIElementTypeOther)[112]")
	MobileElement myBooking;

	@FindBy(xpath = "(//XCUIElementTypeOther)[113]")
	MobileElement myWishList;

	@FindBy(xpath = "(//XCUIElementTypeOther)[114]")
	MobileElement personalise;

	@FindBy(xpath = "(//XCUIElementTypeOther)[115]")
	MobileElement savedAddresses;

	@FindBy(xpath = "(//XCUIElementTypeOther)[116]")
	MobileElement rewardsList;

	@FindBy(xpath = "(//XCUIElementTypeOther)[117]")
	WebElement myReview;

	@FindBy(xpath = "(//XCUIElementTypeOther)[118]")
	MobileElement settingMenu;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Profile-SettingsScreen-LogoutButton']")
	MobileElement logoutBtn;


	@FindBy(className = "android.widget.Button")
	MobileElement hambugermenu;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Profile-SettingsScreen-LogoutYesButton']")
	MobileElement yesBtn;
	
	@FindBy(xpath = "(//XCUIElementTypeOther)[44]")
	MobileElement skinExpert;
	
	@FindBy(xpath = "(//XCUIElementTypeOther)[39]")
	MobileElement wishList;
	
	@FindBy(xpath = "(//XCUIElementTypeOther)[35]")
	MobileElement shop;
	
	@FindBy(xpath = "(//XCUIElementTypeButton)[8]")
	MobileElement bag;
	
	@FindBy(xpath = "(//XCUIElementTypeOther)[42]")
	MobileElement egiftcard;

	public void verifyProfileScreen() {
		
		Reporter.log("verifying the profile details...Please wait...!!!");
		try {
			
			try {
				Thread.sleep(1500);
			} catch (Exception e) {
			}
			memberName.click();

			Assert.assertTrue(ProfileLabel.isEnabled());
			Assert.assertTrue(profileEdit.isEnabled());

			Assert.assertTrue(profileName.getText().equalsIgnoreCase(prop.getProperty("userName")));
			Assert.assertEquals(profilePhoneNumber.getText(), prop.getProperty("phoneNumber"));
			Assert.assertEquals(profileEmail.getText(), prop.getProperty("email"));
			Assert.assertTrue(profileGlowReward.getText().contains("Points"));
			Assert.assertTrue(profileVerify.isEnabled());
			Assert.assertEquals(skinAnalysis.getText(), "SKIN DETAILS");
			Assert.assertTrue(MyOrderList.isEnabled());
			// ReusableMethod.performScroll();
			Assert.assertTrue(mySubScrption.isEnabled());
			Assert.assertTrue(myPayments.isEnabled());
		//	ReusableMethod.scrollDown("bottom");
			HashMap<String,Object>scrollobject=new HashMap<>();
			scrollobject.put("direction","down");
			scrollobject.put("xpath","(//XCUIElementTypeOther)[112]");
			driver.executeScript("mobile:scroll",scrollobject);
			Assert.assertTrue(myBooking.isEnabled());
			Assert.assertTrue(myWishList.isEnabled());
			ReusableMethod.scrollDown("bottom");

			Assert.assertTrue(personalise.isEnabled());
			// ReusableMethod.performScroll("Settings", driver);
			Assert.assertTrue(MyOrderList.isEnabled());
			Assert.assertTrue(savedAddresses.isEnabled());
			Assert.assertTrue(myReview.isEnabled());
			Assert.assertTrue(settingMenu.isEnabled());
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Profile Test execution successful...!\"}}");

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Found issue in Profile Test\"}}");
		}

	}

	public EditProfileScreen editProfileScreen()

	{
		try {
			Thread.sleep(1500);
		} catch (Exception e) {
		}
		 memberName.click();
		wait.until(ExpectedConditions.visibilityOf(profileEdit));
		profileEdit.click();
		return new EditProfileScreen();
	}

	public void checkUserStatus() {
 
		try {
			wait.until(ExpectedConditions.visibilityOf(memberName));
			Reporter.log("checking user status ----Plase wait.....!!!", true);
			wait.until(ExpectedConditions.visibilityOf(memberName));
			memberName.click();
			// ReusableMethod.performScroll("Settings", driver);

			if (settingMenu.isEnabled()) {
				Reporter.log("User is already logged in please logout.....!!!!!", true);

				settingMenu.click();
				wait.until(ExpectedConditions.visibilityOf(logoutBtn));
				logoutBtn.click();
				yesBtn.click();
				wait.until(ExpectedConditions.visibilityOf(hambugermenu));
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				ReusableMethod.horizontalSwipeByPercentage(0.2, 0.5, 0.8);

				// driver.findElement(By.className("android.widget.Button")).click();
			}

		} catch (Exception e) {

			Reporter.log("user is not logged in...!!!Please continue the test----!!!!!!", true);

		}
	}

	public SavedAddressScreen savedAddressObj() {
		try {
			Thread.sleep(1500);
		} catch (Exception e) {
		}
		memberName.click();
		ReusableMethod.scrollDown("bottom");
		ReusableMethod.scrollDown("bottom");
		wait.until(ExpectedConditions.elementToBeClickable(savedAddresses));
		savedAddresses.click();
		return new SavedAddressScreen();

	}

	public SettingScreen settingScrnObj() {
		try {
			Thread.sleep(1500);

			 memberName.click();

			ReusableMethod.scrollDown("bottom");
			ReusableMethod.scrollDown("bottom");

			wait.until(ExpectedConditions.elementToBeClickable(settingMenu));
			settingMenu.click();
			System.out.println("clicked on the setting link ");
		} catch (Exception e) {
		}
		return new SettingScreen();
	}

	public PersonaliseScreen personaliseObj() {
		try {
			Thread.sleep(1500);
		} catch (Exception e) {
		}
		memberName.click();

		ReusableMethod.scrollDown("bottom");

		wait.until(ExpectedConditions.visibilityOf(personalise));
		personalise.click();
		return new PersonaliseScreen();
	}

	public GlowRewardScreen glowRewardObj() {
		try {
			Thread.sleep(1500);
		} catch (Exception e) {
		}
		memberName.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		ReusableMethod.scrollTillEnd();

		wait.until(ExpectedConditions.visibilityOf(rewardsList));
		rewardsList.click();
		return new GlowRewardScreen();
	}
	
	
	public SkinExpertScreen skin_Exper_Object()
	{
		ReusableMethod.scrollDown("bottom");
		ReusableMethod.scrollDown("bottom");
		wait.until(ExpectedConditions.visibilityOf(skinExpert));
		skinExpert.click();
		return new SkinExpertScreen();
	}
	
	
	public MyWishListScreen wish_List_Obj()
	{
		wait.until(ExpectedConditions.visibilityOf(wishList));
		wishList.click();
		return new MyWishListScreen();
	}
	
	public BagScreen bag_Screen_Obj()
	{
		wait.until(ExpectedConditions.visibilityOf(shop));
		shop.click();
		wait.until(ExpectedConditions.visibilityOf(bag));
		bag.click();
		return new BagScreen();
	}
	 
	
	public GiftCard e_giftCardObj()
	{
		wait.until(ExpectedConditions.visibilityOf(egiftcard));
		egiftcard.click();
		return new GiftCard();
	}
}
