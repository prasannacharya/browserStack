package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.Base;
import com.screens.LandingScreen;

public class LandingScreenTest extends Base {
	LandingScreen landScrn;

	public LandingScreenTest() {
		super();

	}

	@BeforeClass
	public void setUp() {
		landScrn = new LandingScreen();

	}

	@Test(priority = 1)
	public void landingScreenLableTest() { 
		test = extent.createTest("2.landingScreenLableTest",
				"This test case is used to verify the landing screen labels");
		landScrn.verifyLandingScreenLabels();
	}
 
	@Test(priority = 2)
	public void footerMenuTest() {    
		test = extent.createTest("3.footerMenuTest", "This test case is used to verify the footerMenus");

		landScrn.clickonfootermenu();
	}

	@Test(priority = 0)
	public void splashScreenTest() {
		test = extent.createTest("1.splashScreenTest", "This test case is used to verify the splashScreen");

		landScrn.veriySplashScreen();
	}

}
