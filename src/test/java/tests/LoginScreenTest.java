package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.Base;
import com.screens.HamburgerScreen;
import com.screens.LandingScreen;
import com.screens.LoginScreen;

public class LoginScreenTest extends Base {
	LandingScreen landScrn;  
	HamburgerScreen hMenus;
	LoginScreen login;

	public LoginScreenTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		landScrn = new LandingScreen();
		hMenus = landScrn.clickOnHamburgerMenu();
		login = hMenus.clickONLoginBtn();

	} 

	@Test
	public void LoginScrnTest() {
		test = extent.createTest("5.LoginScrnTest", "This test case is used to verify LoginScreen label");

		String loginTxt = login.verifyLoginScreen();
		Assert.assertEquals(loginTxt, "SIGN IN TO CONTINUE");

	}

	@Test(priority = 1)
	public void clickOnFacebookTest() { 
		test = extent.createTest("6.clickOnFacebookTest", "This test case is used to verify facebook link");

		login.clickOnFacebookLink();
	}

	@Test()
	public void clickOnGoogleTest() {
		test = extent.createTest("7.clickOnGoogleTest", "This test case is used to verify google link ");

		login.clickOnGoogleLink();
	}

	@Test 
	public void clickOnMobileTest() {
		test = extent.createTest("8.clickOnMobileTest", "This test case is used to verify mobile link");

		login.LoginWithMobile("close");
	}

}
