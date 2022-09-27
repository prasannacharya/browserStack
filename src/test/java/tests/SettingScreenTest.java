package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.Base;
import com.screens.EditProfileScreen;
import com.screens.HamburgerScreen;
import com.screens.LandingScreen;
import com.screens.LoginScreen;
import com.screens.Loginwithmobile;
import com.screens.ProfileScreen;
import com.screens.SettingScreen;

public class SettingScreenTest extends Base {

	LandingScreen landScrn;
	HamburgerScreen hMenus;
	LoginScreen login;
	Loginwithmobile mobile;
	ProfileScreen profile;
	EditProfileScreen editScrn;
	SettingScreen settings;

	public SettingScreenTest() {
		super();

	}

	@BeforeClass
	public void setUp() {
		
		  landScrn = new LandingScreen(); 
		  hMenus = landScrn.clickOnHamburgerMenu();
		  login = hMenus.clickONLoginBtn();
		  mobile = login.LoginWithMobile("click");
		  profile = mobile.verifyLogin();
		  settings = profile.settingScrnObj(); 
 
	}

	@Test(priority = 0)
	public void notificationSettingTest() {
		test = extent.createTest("31.notificationSettingTest",
				"This test case is used to verify  the notification functionality ....");
		settings.verifyNotification();
	}
 
	@Test(priority = 1)
	public void samePasswordValidationTest() {
		test = extent.createTest("32.samePasswordValidationTest",
				"This test case is used to verify  the duplicate  password scenario ....");
		settings.samePwdVerification();
	}

	@Test(priority = 2)
	public void passwordLengthTest() {
		test = extent.createTest("33.passwordLengthTest", "This test case is used to verify  the password length ....");
		settings.verifyinvalidPwdLenght();
	}

	@Test(priority = 3)
	public void invalidPwdTest() {
		test = extent.createTest("34.invalidPwdTest",
				"This test case is used to verify  the invalid password scenario ....");
		settings.invalidRestPassword();

	}

	@Test(priority = 4, enabled = false)
	public void resetPasswordTest() {
		test = extent.createTest("35.resetPasswordTest",
				"This test case is used to verify  the reset password  functionality ....");
		settings.verifyRestPassword();
	}

	@Test(priority = 5)
	public void policiesTest() {
		test = extent.createTest("36.policiesTest",
				"This test case is used to verify  the policies functionality ....");
		settings.veifyPoliciesScreen();
	}

	@Test(priority = 6)
	public void logoutTest() {
		test = extent.createTest("37.logoutTest", "This test case is used to verify  the logout functionality ....");
		settings.verifyLogout();
	}

}
