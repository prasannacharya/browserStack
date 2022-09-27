package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.Base;
import com.screens.HamburgerScreen;
import com.screens.LandingScreen; 
import com.screens.LocateStroreScreen;

public class StoreLocatorTest extends Base {

	HamburgerScreen hMenus;
	LandingScreen landScrn;
	LocateStroreScreen locateStore;

	public StoreLocatorTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		landScrn = new LandingScreen(); 
		hMenus = landScrn.clickOnHamburgerMenu();
		locateStore = hMenus.locateStoreObj(); 

	}

	@Test(priority = 0)
	public void locateStoreTest() {
		test = extent.createTest("38.locateStoreTest", "This test case is used to verify  the locatore store functionality ....");

		locateStore.verifyLocateStore();  
	} 
	  
	@Test(priority = 1)
	public void noStoreFoundTest()
	{
		test = extent.createTest("39.noStoreFoundTest", "This test case is used to verify  the store not found scenario ....");

		locateStore.verifyNoStoreFound();
	}
}
