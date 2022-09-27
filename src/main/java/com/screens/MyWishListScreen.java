package com.screens;

import com.base.Base;
import com.util.ReusableMethod;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class MyWishListScreen extends Base {
    WebDriverWait wait = new WebDriverWait(driver, 15);
    String listName;

    public MyWishListScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "(//XCUIElementTypeOther)[21]")
    MobileElement wishList;


    @FindBy(xpath = "(//XCUIElementTypeOther)[27]")
    MobileElement defaultList;

    @FindBy(xpath = "(//XCUIElementTypeOther)[20]")
    MobileElement addWishListBtn;

    @FindBy(xpath = "//*[@name='CREATE NEW LIST']")
    MobileElement createListTxt;

    @FindBy(xpath = "//XCUIElementTypeTextField")
    MobileElement createField;

    @FindBy(xpath = "//*[@name='CreateWishlistScreen-createButton']")
    MobileElement createBtn;

    @FindBy(xpath = "//*[@content-desc='CreateWishlistScreen-close']")
    MobileElement closeBtn;

    @FindBy(xpath = "//XCUIElementTypeStaticText")
    MobileElement createSuccessMsg;
 
    @FindBy(xpath = "//*[@name='Wishlist edited successfully!']")
    MobileElement editSuccessMessage;

    @FindBy(xpath = "(//XCUIElementTypeOther)[31]")
    MobileElement successClose;


    @FindBy(xpath = "//*[@name='EmptyWishlist-StartButton']")
    MobileElement startBtn;

    @FindBy(xpath = "//*[@content-desc='WishlistScreen-ShareList']")
    MobileElement shareBtn;

    @FindBy(xpath = "//*[@name='WishlistScreen-ShareList']")
    MobileElement editBtn;

    @FindBy(xpath = "//*[@content-desc='BackButton']")
    MobileElement backBtn;

    @FindBy(xpath = "//*[@name='EDIT WISHLIST']")
    MobileElement editWishListTxt;

    @FindBy(xpath = "//*[@name='Title Title Welcome-RegisterEmailOrMobileInput']")
    MobileElement editTextField;

    @FindBy(xpath = "//*[@name='EmptyWishlist-StartButton']")
    MobileElement doneBtn;

    @FindBy(xpath = "//*[@name='Edit Collection']")
    MobileElement editCollection;

    @FindBy(xpath = "//*[@name='Delete Collection']")
    MobileElement deleteCollection;

    @FindBy(xpath = "//*[@name='REMOVE COLLECTION']")
    MobileElement removeTxt;

    @FindBy(xpath = "//*[@name='CANCEL']")
    MobileElement cancelBtn;

    @FindBy(xpath = "//*[@name='REMOVE']")
    MobileElement removeBtn;

    @FindBy(xpath = "(//XCUIElementTypeButton)[7]")
    MobileElement shopBtn;

    @FindBy(xpath = "//*[@name='SHOP']")
    MobileElement shopTxt;

    @FindBy(xpath = "//*[@name='MAKEUP']")
    MobileElement makeupBtn;

    @FindBy(xpath = "//*[@name='QUICK FILTER']")
    MobileElement filter;

    @FindBy(xpath = "//*[@text='ADD TO BAG']")
    MobileElement addToBag;

    @FindBy(xpath = "//*[@name='Lipstick']")
    MobileElement lipstickTxt;

    @FindBy(xpath = "//*[@name='BESTSELLER']")
    MobileElement bestseller;

    @FindBy(xpath = "//*[@name='PDP-AddToWishlist']")
    MobileElement wishListIcon;

    @FindBy(xpath = "//*[@text='Unable to add to wishlist']")
    MobileElement errorMsg;

    @FindBy(xpath = "//*[@name='Wishlist deleted successfully!']")
    MobileElement deleteMsg;
    

    @FindBy(xpath = "//*[@name='addtowishlist 00 Items']")
    MobileElement addwishlist;
    
    @FindBy(xpath = "(//XCUIElementTypeOther)[74]")
    MobileElement product;

    @FindBy(xpath = "//*[@name='REMOVE ITEM']")
    MobileElement removeitemsTxt;
    
    
    
    public void create_WishList() {
        wait.until(ExpectedConditions.visibilityOf(wishList));
        Assert.assertTrue(wishList.isEnabled());
        Assert.assertTrue(defaultList.isEnabled());
        addWishListBtn.click();
        wait.until(ExpectedConditions.visibilityOf(createListTxt));
        Assert.assertEquals(createListTxt.getText(), "CREATE NEW LIST");
        listName = ReusableMethod.generatePassword();
        createField.sendKeys(listName);
        createBtn.click();
        wait.until(ExpectedConditions.visibilityOf(createSuccessMsg));
        Assert.assertEquals(createSuccessMsg.getText(), "Wishlist created");
        
        List<WebElement> other = driver.findElements(By.className("XCUIElementTypeOther"));
        	for (WebElement wishlistName : other) {
				try
				{
        		if(wishlistName.getText().contains(listName))
				{
				//	wishlistName.click();
        			driver.findElement(By.xpath("//*[@name='"+listName+" 00 Items']")).click();
					break;
				}
				}
				catch (Exception e) {
					ReusableMethod.scrollDown("bottom");
				}
			}
        }


    public void edit_WishList() {

            editBtn.click();
            wait.until(ExpectedConditions.visibilityOf(editCollection));
            editCollection.click();
            wait.until(ExpectedConditions.visibilityOf(editWishListTxt));
            Assert.assertEquals(editWishListTxt.getText(), "EDIT WISHLIST");
            listName = ReusableMethod.generatePassword();
            try
            {
            	driver.getKeyboard();
               editTextField.clear();
            editTextField.sendKeys(listName);
            }
            catch (Exception e) {
            	driver.getKeyboard();
                editTextField.sendKeys(listName);
			}
            doneBtn.click();
            wait.until(ExpectedConditions.visibilityOf(editSuccessMessage));
            Assert.assertEquals(editSuccessMessage.getText(), "Wishlist edited successfully!");
            successClose.click();
    //        MobileElement wishTxt = driver.findElement(By.xpath("//*[@text='" + listName + "']"));
   //         Assert.assertEquals(wishTxt.getText(), listName);
        }



    public void delete_WishList()
    {
        wait.until(ExpectedConditions.visibilityOf(editBtn));
        editBtn.click();
        wait.until(ExpectedConditions.visibilityOf(deleteCollection));
        deleteCollection.click();
        wait.until(ExpectedConditions.visibilityOf(removeTxt));
        Assert.assertEquals(removeTxt.getText(),"REMOVE COLLECTION");
        Assert.assertEquals(cancelBtn.getText(),"CANCEL");
        Assert.assertEquals(removeBtn.getText(),"REMOVE");
        removeBtn.click();
        wait.until(ExpectedConditions.visibilityOf(deleteMsg));
        Assert.assertEquals(deleteMsg.getText(), "Wishlist deleted successfully!");
    }

    public void add_To_WishList()
    {
    	
    	wait.until(ExpectedConditions.visibilityOf(addwishlist));
    	addwishlist.click();
        wait.until(ExpectedConditions.visibilityOf(startBtn));
        startBtn.click();
        wait.until(ExpectedConditions.visibilityOf(shopBtn));
        shopBtn.click();
        wait.until(ExpectedConditions.visibilityOf(shopTxt));
        Assert.assertEquals(shopTxt.getText(),"SHOP");
        makeupBtn.click();
        try
        {
            Thread.sleep(2000);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        wait.until(ExpectedConditions.visibilityOf(filter));
        Assert.assertEquals(filter.getText(),"QUICK FILTER");
        lipstickTxt.click();
        wait.until(ExpectedConditions.visibilityOf(bestseller));
        try {
        	product.click();
            wait.until(ExpectedConditions.visibilityOf(wishListIcon));
            wishListIcon.click();
        }
        catch (Exception e)
        {
            driver.findElement(By.xpath("//*[@name='PDP-AddToWishlist']")).click();
        }
        
        
        wishListIcon.click();
         wait.until(ExpectedConditions.visibilityOf(removeitemsTxt));
         
        Assert.assertEquals(removeitemsTxt.getText(),"REMOVE ITEM");
        removeBtn.click();
    }
}
