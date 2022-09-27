package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.Base;
import com.screens.EditProfileScreen;
import com.screens.HamburgerScreen;
import com.screens.LandingScreen;
import com.screens.LoginScreen;
import com.screens.Loginwithmobile;
import com.screens.PersonaliseScreen;
import com.screens.ProfileScreen;
import com.screens.SettingScreen;

public class PersonaliseTest extends Base {

	LandingScreen landScrn;
	HamburgerScreen hMenus;
	LoginScreen login;
	Loginwithmobile mobile;
	ProfileScreen profile;
	EditProfileScreen editScrn;
	SettingScreen settings;
	PersonaliseScreen personalise;

	public PersonaliseTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
//		landScrn = new LandingScreen();
//		hMenus = landScrn.clickOnHamburgerMenu();
//		login = hMenus.clickONLoginBtn();
//		mobile = login.LoginWithMobile("click");
//		profile = mobile.verifyLogin();
		profile = new ProfileScreen();
		personalise = profile.personaliseObj();

	}

	@Test
	public void personaliseScreenTest() {
		test = extent.createTest("22.personaliseScreenTest", "This test case is used to verify the personalise labels  ....");

		personalise.verifyPersonaliseScreen();
	}

	@Test(priority = 1)
	public void personaliseTest() {
		test = extent.createTest("23.personaliseTest", "This test case is used to verify the personalise functionality ....");

		personalise.personaliseVerfication();
	}
}
