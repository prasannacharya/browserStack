package tests;

import com.base.Base;
import com.screens.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SkinExpertTest extends Base {
    LandingScreen landScrn;
    HamburgerScreen hMenus; 
    LoginScreen login ;
    Loginwithmobile mobile;
    ProfileScreen profile;
    SkinExpertScreen skin;


    public SkinExpertTest()
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
		  skin=profile.skin_Exper_Object();
 
    }  

    @Test(enabled = false) 
    public void verify_Skin_Expert_Test()
    {
        skin.verify_Skin_Expert_Screen();
    }
     
    @Test(priority = 1)     
    public void add_Customer_Details_Test()  
    { 
        skin.add_Customer_Details_Screen("Friend");  
    }   

    @Test(priority = 2)
    public void personal_Info_Test()
    {
        skin.personal_Details("male",35,2);
    } 

    @Test(priority = 3)
    public void makeup_Screen_Test()
    {
        skin.verify_MakeUp_Screen("yes",3);
    }

    @Test(priority = 4)
    public void skin_result_Test()
    { 
        skin.verify_Skin_Type("Normal",1);
    }

    @Test(priority = 5,enabled=false)
    public void rating_Test()
    {
       // skin.verify_Rating(4,3);
    }


}
