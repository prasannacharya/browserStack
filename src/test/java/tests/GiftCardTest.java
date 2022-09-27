package tests;

import com.base.Base;
import com.screens.BagScreen;
import com.screens.GiftCard;
import com.screens.HamburgerScreen;
import com.screens.LandingScreen;
import com.screens.LoginScreen;
import com.screens.Loginwithmobile;
import com.screens.ProfileScreen;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GiftCardTest extends Base {
    
	  LandingScreen landScrn; 
	    BagScreen bag;
	    HamburgerScreen hMenus; 
	    LoginScreen login ;
	    Loginwithmobile mobile;
	    ProfileScreen profile;
	    GiftCard gift;
	    
    public GiftCardTest()
    {
        super();
    }

    @BeforeClass
    public void setUp() {
    	landScrn=new LandingScreen();
		 hMenus = landScrn.clickOnHamburgerMenu();
		login = hMenus.clickONLoginBtn();
		 mobile = login.LoginWithMobile("click");
		  profile = mobile.verifyLogin();
		  gift = profile.e_giftCardObj();
    }

    @Test
    public void bulk_Purchase_Test() 
    { 
        gift.bulk_Purchase();    
    }  
 
    @Test(priority = 1)
    public void send_GiftCard_Test()
    {
        gift.send_GiftCard(2500); 
    }

}
