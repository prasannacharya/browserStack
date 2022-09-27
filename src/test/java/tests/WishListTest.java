package tests;

import com.base.Base;
import com.screens.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WishListTest extends Base {

    LandingScreen landScrn;
    HamburgerScreen hMenus;
    LoginScreen login;
    Loginwithmobile mobile;
    ProfileScreen profile;
    MyWishListScreen wish;

    public  WishListTest()
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
         wish = profile.wish_List_Obj(); 
    }

    @Test   
    public void create_WishListTest() 
    {
        wish.create_WishList();  
    }

    @Test(priority = 1)
    public void edit_WishListTest() 
    {
        wish.edit_WishList();
    }

    @Test(priority = 2)
    public void delete_WishListTest()
    {
        wish.delete_WishList();
    }

    @Test(priority = 3) 
    public void add_To_WishList()
    { 
        wish.add_To_WishList();
    }

}
