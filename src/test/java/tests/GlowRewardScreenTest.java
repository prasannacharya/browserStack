package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.Base;
import com.screens.EditProfileScreen;
import com.screens.GlowRewardScreen;
import com.screens.HamburgerScreen;
import com.screens.LandingScreen;
import com.screens.LoginScreen;
import com.screens.Loginwithmobile;
import com.screens.ProfileScreen;

public class GlowRewardScreenTest extends Base {

	LandingScreen landScrn;
	HamburgerScreen hMenus;
	LoginScreen login;
	Loginwithmobile mobile;
	ProfileScreen profile;
	EditProfileScreen editScrn;
	GlowRewardScreen glowPage;

	public GlowRewardScreenTest() {

		super();
	}

	@BeforeClass
	public void setUp() {
		landScrn = new LandingScreen();
		hMenus = landScrn.clickOnHamburgerMenu();
		login = hMenus.clickONLoginBtn();
		mobile = login.LoginWithMobile("click");
		profile = mobile.verifyLogin();
	//	profile=new ProfileScreen();
		glowPage = profile.glowRewardObj(); 

	}

	@Test(priority = 0)   
	public void glowScreenTest() {
		test = extent.createTest("24.glowScreenTest", "This test case is used to verify the glow reward screen  ....");

		glowPage.verifyglowRewardScreen();
	}

	@Test(priority = 1)
	public void knowMoreLinkTest() {
		test = extent.createTest("25.knowMoreLinkTest", "This test case is used to verify the know more link in glow reward screen ....");

		glowPage.knowMoreLinktxt();
	}

	@Test(enabled = false)
	public void faqsTest() {
		test = extent.createTest("26.faqsTest", "This test case is used to verify faqs functionality ....");

		 glowPage.veriyFaq();
	}

}
