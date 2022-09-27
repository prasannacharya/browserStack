package tests;

import com.base.Base;
import com.screens.BagScreen;
import com.screens.HamburgerScreen;
import com.screens.LandingScreen;
import com.screens.LoginScreen;
import com.screens.Loginwithmobile;
import com.screens.ProfileScreen;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BagTest extends Base {

    LandingScreen landScrn; 
    BagScreen bag;
    HamburgerScreen hMenus; 
    LoginScreen login ;
    Loginwithmobile mobile;
    ProfileScreen profile;

    public BagTest() {
        super();
    }

    @BeforeClass 
    public void setUp() {
    	landScrn=new LandingScreen();
		 hMenus = landScrn.clickOnHamburgerMenu();
		login = hMenus.clickONLoginBtn();
		 mobile = login.LoginWithMobile("click");
		  profile = mobile.verifyLogin();
		  bag=profile.bag_Screen_Obj();

    }
 
    @Test  
    public void apply_Coupon_Test() 
    { 
        bag.apply_Coupon();   
    }   
 
    @Test(priority = 1)
    public void gift_Wrap_Test()
    {
        bag.Verify_DeliveryAddress();  
    }  
 
    @Test(priority = 2)
    public void add_Address_Test() 
    {
        bag.add_New_Address();      
    }  

}

