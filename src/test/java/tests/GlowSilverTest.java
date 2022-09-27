package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.Base;
import com.screens.EditProfileScreen;
import com.screens.GlowRewardScreen;
import com.screens.GlowSilverScreen;
import com.screens.HamburgerScreen;
import com.screens.LandingScreen;
import com.screens.LoginScreen;
import com.screens.Loginwithmobile;
import com.screens.ProfileScreen;

public class GlowSilverTest extends Base {

	LandingScreen landScrn;
	HamburgerScreen hMenus;
	LoginScreen login;
	Loginwithmobile mobile;
	ProfileScreen profile;
	EditProfileScreen editScrn;
	GlowRewardScreen glowPage;
	GlowSilverScreen silverScrn;

	public GlowSilverTest() {
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
		  silverScrn = glowPage.silverPageObj();

	}

	@Test
	public void silverScreenTest() {
		test = extent.createTest("27.silverScreenTest","This test case is used to verify  the silver glow reward functionality ....");

		silverScrn.verifyGlowSilverScreen();
	}
}
