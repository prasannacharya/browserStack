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

public class EditProfileTest extends Base {
	LandingScreen landScrn;
	HamburgerScreen hMenus;
	LoginScreen login;
	Loginwithmobile mobile;
	ProfileScreen profile;
	EditProfileScreen editScrn;

	public EditProfileTest() {
		super();
	}

	@BeforeClass
	public void setUp() {

		landScrn = new LandingScreen();
		hMenus = landScrn.clickOnHamburgerMenu();
		login = hMenus.clickONLoginBtn();
		mobile = login.LoginWithMobile("click");
		profile = mobile.verifyLogin();
		//profile = new ProfileScreen();
		editScrn = profile.editProfileScreen();

	}
  
	@Test(priority = 0)
	public void editProfileScreenTest() {
		test = extent.createTest("17.editProfileScreenTest", "This test case is used to edit the profile details...");

		editScrn.verifyEditScreen();
	}

	@Test(priority = 1)
	public void uploadProfileImage() {   
		test = extent.createTest("18.uploadProfileImage", "This test case is used to upload the profile image....");

		editScrn.uploadProfileImage();
	}

}
