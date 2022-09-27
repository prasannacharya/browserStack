package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.Base;
import com.screens.HamburgerScreen;
import com.screens.LandingScreen;
import com.screens.LoginScreen;
import com.screens.Loginwithmobile;
import com.screens.ProfileScreen;

public class ProfileScreenTest extends Base {

	LandingScreen landScrn;
	HamburgerScreen hMenus;
	LoginScreen login;
	Loginwithmobile mobile;
	ProfileScreen profile;

	public ProfileScreenTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		landScrn=new LandingScreen();
		 hMenus = landScrn.clickOnHamburgerMenu();
		login = hMenus.clickONLoginBtn();
		 mobile = login.LoginWithMobile("click");
		  profile = mobile.verifyLogin();
	} 

	@Test
	public void profileDeatilsTest() {
		test = extent.createTest("16.profileDeatilsTest", "This test case is used to verify  profileDeatils");

		profile.verifyProfileScreen(); 
 
	}
}
