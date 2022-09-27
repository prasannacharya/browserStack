package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.Base;
import com.screens.EditProfileScreen;
import com.screens.GlowRewardScreen;
import com.screens.GlowTitaniumScreen;
import com.screens.HamburgerScreen;
import com.screens.LandingScreen;
import com.screens.LoginScreen;
import com.screens.Loginwithmobile;
import com.screens.ProfileScreen;

public class GlowTitaniumTest extends Base {

	LandingScreen landScrn;
	HamburgerScreen hMenus;
	LoginScreen login;
	Loginwithmobile mobile;
	ProfileScreen profile;
	EditProfileScreen editScrn;
	GlowRewardScreen glowPage;
	GlowTitaniumScreen titanium;

	public GlowTitaniumTest() {
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
		titanium = glowPage.titaniumScrnObj();

	}
  
	@Test
	public void titaniumScreenTest() {
		test = extent.createTest("30.titaniumScreenTest",
				"This test case is used to verify  the titanium  glow reward functionality ....");
		titanium.verifyGlowTitaniumScreen();
	}

}
