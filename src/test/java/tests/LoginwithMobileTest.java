package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.Base;
import com.screens.HamburgerScreen;
import com.screens.LandingScreen;
import com.screens.LoginScreen;
import com.screens.Loginwithmobile;

public class LoginwithMobileTest extends Base {
	LandingScreen landScrn;
	HamburgerScreen hMenus;
	LoginScreen login;
	Loginwithmobile mobile;

	public LoginwithMobileTest() {
		super();

	}

	@BeforeClass
	public void setUp() {
		landScrn = new LandingScreen();
		hMenus = landScrn.clickOnHamburgerMenu(); 
		login = hMenus.clickONLoginBtn();
		mobile = login.LoginWithMobile("click");
 
	}

	@Test(priority = 2)
	public void loginTest() {
		test = extent.createTest("15.RegisterScrnTest", "This test case is used to verify  login functionality..");

		mobile.verifyLogin();  
	}  
 
	@Test(priority = 0)
	public void forgotPaswordTest() {
		test = extent.createTest("13.forgotPaswordTest",
				"This test case is used to verify  the  forgotPasword functionality");
 
		mobile.verifyForgotPassword();
	} 

	@Test(priority = 1)
	public void otpResendTest() {
		test = extent.createTest("14.otpResendTest", "This test case is used to verify  otpResend functionality..");

		mobile.verifyOtpScreen();
	}

}
