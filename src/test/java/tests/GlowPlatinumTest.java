package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.Base;
import com.screens.EditProfileScreen;
import com.screens.GlowPaltinumScreen;
import com.screens.GlowRewardScreen;
import com.screens.HamburgerScreen;
import com.screens.LandingScreen;
import com.screens.LoginScreen;
import com.screens.Loginwithmobile;
import com.screens.ProfileScreen;

public class GlowPlatinumTest extends Base {

	LandingScreen landScrn;
	HamburgerScreen hMenus;
	LoginScreen login;
	Loginwithmobile mobile;
	ProfileScreen profile;
	EditProfileScreen editScrn;
	GlowRewardScreen glowPage;
	GlowPaltinumScreen platinum;

	public GlowPlatinumTest() {

		super();
	}

	@BeforeClass
	public void setUp() {
	
		 landScrn = new LandingScreen();
		   hMenus = landScrn.clickOnHamburgerMenu();
		  login = hMenus.clickONLoginBtn();
		  mobile =login.LoginWithMobile("click");
		  profile = mobile.verifyLogin(); 
		  glowPage = profile.glowRewardObj();
		platinum = glowPage.PlantinumScrnObj(); 

	}

	@Test
	public void glowPlatinumScreenTest() {
		test = extent.createTest("29.glowPlatinumScreenTest",
				"This test case is used to verify  the platinum  glow reward functionality ....");
		platinum.verifyGlowPlatinumScreen();
	}
}
