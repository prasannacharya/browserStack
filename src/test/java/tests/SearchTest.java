package tests;

import com.base.Base;
import com.screens.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchTest extends Base {

    LandingScreen landScrn;
    SearchScreen search;

    public SearchTest()
    {
        super();
    }
    @BeforeClass
    public void setUp() {
    	
        landScrn = new LandingScreen();
        landScrn.veriySplashScreen();
         search = landScrn.search_Obj();
    }

    @Test
    public void searchTest()     
    { 
        search.verify_Global_Search();  
    }

}
