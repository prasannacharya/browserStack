package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.Base;
import com.screens.HamburgerScreen;
import com.screens.LandingScreen;

public class HamburgerMenuTest extends Base {
	LandingScreen landScrn;
	HamburgerScreen hMenus;

	public HamburgerMenuTest() {
		super();
	}

	@BeforeClass
	public void setUp() { 
		landScrn = new LandingScreen(); 
		hMenus = landScrn.clickOnHamburgerMenu(); 
  
	}

	@Test
	public void hamburgerLabelTest()

	{
		test = extent.createTest("4.hamburgerLabelTest", "This test case is used to verify hamburger menus");

		hMenus.verifyHamBurgerMenus();
	}

}
