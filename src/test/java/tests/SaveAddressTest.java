package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.Base;
import com.screens.EditProfileScreen;
import com.screens.HamburgerScreen;
import com.screens.LandingScreen;
import com.screens.LoginScreen;
import com.screens.Loginwithmobile;
import com.screens.ProfileScreen;
import com.screens.SavedAddressScreen;

public class SaveAddressTest extends Base {
	LandingScreen landScrn;
	HamburgerScreen hMenus;
	LoginScreen login;
	Loginwithmobile mobile;
	ProfileScreen profile;
	EditProfileScreen editScrn;
	SavedAddressScreen saveAdd;

	public SaveAddressTest() {
		super();
	}

	@BeforeClass
	public void setUp() { 
		landScrn = new LandingScreen();
		hMenus = landScrn.clickOnHamburgerMenu();
		login = hMenus.clickONLoginBtn();
		mobile = login.LoginWithMobile("click");
		profile = mobile.verifyLogin();
		saveAdd = profile.savedAddressObj();

	}

	@Test(priority = 0) 
	public void saveAddressTest() {
		test = extent.createTest("19.saveAddressTest", "This test case is used to add new address ....");
 
		saveAdd.addSaveAddress();
	}

	@Test(priority = 1)
	public void editAddressTest() {
		test = extent.createTest("20.editAddressTest", "This test case is used to edit the existing address....");

		saveAdd.editAddress();
	}

	@Test(priority = 2)
	public void deleteSavedAddressTest() {
		test = extent.createTest("21.deleteSavedAddressTest", "This test case is used to delete the address ....");

		saveAdd.deleteSavedAdress();
	}
}
