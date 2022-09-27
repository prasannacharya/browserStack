package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.Base;
import com.screens.EditProfileScreen;
import com.screens.GlowGoldScreen;
import com.screens.GlowRewardScreen;
import com.screens.HamburgerScreen;
import com.screens.LandingScreen;
import com.screens.LoginScreen;
import com.screens.Loginwithmobile;
import com.screens.ProfileScreen;

public class GlowGoldScreenTest extends Base {

	LandingScreen landScrn;
	HamburgerScreen hMenus;
	LoginScreen login;
	Loginwithmobile mobile;
	ProfileScreen profile;
	EditProfileScreen editScrn;
	GlowRewardScreen glowPage;
	GlowGoldScreen gold;

	public GlowGoldScreenTest() {
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
		  gold = glowPage.goldScrnObj();
 
	}

	@Test
	public void glowGoldScreenTest() {

		test = extent.createTest("28.glowGoldScreenTest",
				"This test case is used to verify  the gold  glow reward functionality ....");

		gold.verifyGlowGoldScreen();
	}
}
