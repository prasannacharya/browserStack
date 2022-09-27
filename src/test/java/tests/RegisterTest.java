package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.Base;
import com.screens.HamburgerScreen;
import com.screens.LandingScreen;
import com.screens.RegisterScreen;

public class RegisterTest extends Base {

	LandingScreen landScrn;
	HamburgerScreen hMenus;
	RegisterScreen register;

	public RegisterTest() {

		super();
	}

	@BeforeClass
	public void setUp() {
		landScrn = new LandingScreen();
		hMenus = landScrn.clickOnHamburgerMenu();
		register = hMenus.clickOnRegisterLink();

	}

	@Test(priority = 0)
	public void RegisterScrnTest() {
		test = extent.createTest("9.RegisterScrnTest",
				"This test case is used to verify register link  and getStarted label ");

		String loginTxt = register.verifyRegisterScreen();
		Assert.assertEquals(loginTxt, "GET STARTED");

	}

	@Test(priority = 1)
	public void clickOnFacebookTest() {
		test = extent.createTest("10.clickOnFacebookTest",
				"This test case is used to verify and clicking on the facebook link");

		register.clickOnFacebookLink();
	}

	@Test(priority = 2)
	public void clickOnGoogleTest() {
		test = extent.createTest("11.clickOnGoogleTest", "This test case is used to verify  and clickOn Google link");

		register.clickOnGoogleLink();
	}

	@Test(priority = 3)
	public void clickOnMobileTest() {
		test = extent.createTest("12.RegisterScrnTest", "This test case is used to verify  register modal");

		register.registerWithMobile();
	}

}
