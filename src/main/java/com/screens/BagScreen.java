package com.screens;

import com.base.Base;
import com.util.ReusableMethod;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class BagScreen extends Base {

	WebDriverWait wait = new WebDriverWait(driver, 15);

	public BagScreen() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(xpath = "//*[@text='Bag']")
	MobileElement bag;

	@FindBy(xpath = "//*[contains(@name,'BAG')]")
	MobileElement bagScrn;

	@FindBy(xpath = "//*[@name='BagScreen-PlaceOrder']")
	MobileElement placeOrder;

	@FindBy(xpath = "//*[@name='Order_Bag-Return Refund']")
	MobileElement applyCoupon;

	@FindBy(xpath = "//*[@name='Order_Bag-Return Refund']")
	MobileElement applyCouponTxt;

	@FindBy(xpath = "//*[@name='APPLY COUPON']")
	MobileElement couponHeader;

	@FindBy(xpath = "//*[@name='COUPONS-ENTER_COUPON_CODE']")
	MobileElement enterCoupon;

	@FindBy(xpath = "//*[@name='CouponScreen-Apply']")
	MobileElement applyBtn;

	@FindBy(xpath = "//*[@name='Applied Successfully']")
	MobileElement successMsg;

	@FindBy(xpath = "//*[@name='AWESOME']")
	MobileElement awesomeTxt;

	@FindBy(xpath = "//*[@name='AVAILABLE COUPONS']")
	MobileElement availableCoupons;

	@FindBy(xpath = "//*[@name='COUPONS-APPLY_COUPON_CODE']")
	MobileElement couponCode;

	@FindBy(xpath = "(//XCUIElementTypeStaticText)[2]")
	MobileElement warningMsg;

	@FindBy(xpath = "//*[@name='FailureDialog-Okay']")
	MobileElement failureOkay;

	@FindBy(xpath = "//*[@name='BackButton']")
	MobileElement backBtn;

	@FindBy(xpath = "//*[@name='Order_Bag-GLOW_POINTS_CHECKBOX']")
	MobileElement checkbox;

	@FindBy(xpath = "//*[@name='BagScreen-Return Refund']")
	MobileElement refundBtn;

	@FindBy(xpath = "//*[@name='BagScreen-Return Refund']")
	MobileElement returnandRefundTxt;

	@FindBy(xpath = "//*[@name='RETURN & REFUND']")
	MobileElement refundHeader;

	@FindBy(xpath = "//*[@name='DELIVER TO']")
	MobileElement deliveryTxt;

	@FindBy(xpath = "//*[contains(@name,'Please modify your address.')]")
	MobileElement addressWarningMsg;

	@FindBy(xpath = "//*[@name='ADD GIFT WRAP']")
	MobileElement addGiftWrap;

	@FindBy(xpath = "//*[@name='SEND YOUR LOVE']")
	MobileElement sendTxt;

	@FindBy(xpath = "(//XCUIElementTypeTextField)[1]")
	MobileElement recepientName;

	@FindBy(xpath = "(//XCUIElementTypeTextField)[2]")
	MobileElement messageField;

	@FindBy(xpath = "(//XCUIElementTypeTextField)[3]")
	MobileElement senderName;

	@FindBy(xpath = "(//XCUIElementTypeOther)[49]")
	MobileElement imageView;

	@FindBy(xpath = "//*[@name='DONE']")
	MobileElement doneBtn;

	@FindBy(xpath = "//*[@name='REMOVE GIFT WRAP']")
	MobileElement removeGiftBtn;

	@FindBy(xpath = "//*[@name='VIEW ITEMS']")
	MobileElement viewItems;

	@FindBy(xpath = "//*[@name='2 items are unavailable for this pincode']")
	MobileElement unavailable;

	@FindBy(xpath = "//*[@name='UNAVAILABLE ITEMS']")
	MobileElement itemsNotAvailable;

	@FindBy(xpath = "//*[@name='REMOVE']")
	MobileElement removeBtn;

	@FindBy(xpath = "//*[@name='MOVE TO WISHLIST']")
	MobileElement moveToWishListBtn;

	@FindBy(xpath = "(//XCUIElementTypeOther)[112]")
	MobileElement closeBtn;

	@FindBy(xpath = "//*[@name='ADD NEW ADDRESS']")
	MobileElement addNewAddress;

	@FindBy(xpath = "//*[@name='Profile-Address-UseCurrentLocation']")
	MobileElement useCurrentLocation;

	@FindBy(xpath = "//*[@name='Profile-Address-SearchInput']")
	MobileElement searchField;

	@FindBy(xpath = "//*[@name='Profile-Address-SearchResult-0']")
	MobileElement searchResult;

	@FindBy(xpath = "//*[@name='Profile-AddAddress-PincodeInput']")
	MobileElement pincode;

	@FindBy(xpath = "//*[@name='Profile-AddAddress-NameInput']")
	MobileElement nameField;

	@FindBy(xpath = "//*[@name='Profile-AddAddress-MobileNoInput']")
	MobileElement phoneFiled;

	@FindBy(xpath = "//*[@name='Profile-AddAddress-HouseInput']")
	MobileElement houseInput;

	@FindBy(xpath = "//*[@name='Profile-AddAddress-LandmarkInput']")
	MobileElement landMark;
	@FindBy(xpath = "//*[@name='Profile-AddAddress-AddressTypeHome']")
	MobileElement homeBtn;

	@FindBy(xpath = "//*[@name='SAVE']")
	MobileElement saveBtn;

	@FindBy(xpath = "//*[@name='Saved Successfully!']")
	MobileElement saveaddressMsg;

	@FindBy(xpath = "//*[@name='ADD NEW']")
	MobileElement addNewBtn;

	@FindBy(xpath = "//*[@name='CHANGE ADDRESS']")
	MobileElement changeAddress;

	@FindBy(xpath = "//*[contains(@name,'PAY')]")
	MobileElement payBtn;

	@FindBy(xpath = "//*[@name='Payment Methods']")
	MobileElement paymentMethods;

	public void apply_Coupon() {
		wait.until(ExpectedConditions.visibilityOf(bagScrn));
		Assert.assertTrue(bagScrn.getText().contains("BAG"));
		ReusableMethod.scrollDown("bottom");
		Assert.assertTrue(applyCouponTxt.isEnabled());
		applyCoupon.click();
		wait.until(ExpectedConditions.visibilityOf(couponHeader));
		Assert.assertEquals(couponHeader.getText(), "APPLY COUPON");
		try {
			driver.getKeyboard();
			enterCoupon.sendKeys("Testing");

			applyBtn.click();
			wait.until(ExpectedConditions.visibilityOf(successMsg));
			Assert.assertEquals(successMsg.getText(), "Applied Successfully");
			awesomeTxt.click();
		} catch (Exception e) {
			e.getMessage();
			driver.getKeyboard();
			enterCoupon.sendKeys("Testing");
			applyBtn.click();
			wait.until(ExpectedConditions.visibilityOf(successMsg));
			Assert.assertEquals(successMsg.getText(), "Applied Successfully");
			awesomeTxt.click();
		}

		wait.until(ExpectedConditions.visibilityOf(availableCoupons));
		Assert.assertEquals(availableCoupons.getText(), "AVAILABLE COUPONS");
       try
       {
        couponCode.click();
        couponCode.click();
        wait.until(ExpectedConditions.visibilityOf(warningMsg));
       // Assert.assertEquals(warningMsg.getText(),"Coupon is not applicable as bag value is not sufficient");
        failureOkay.click() ;
       }
       catch (Exception e) {
    	  e.getMessage();
          failureOkay.click() ;

       }
		backBtn.click();

		wait.until(ExpectedConditions.visibilityOf(bagScrn));
		ReusableMethod.scrollDown("bottom");
		ReusableMethod.scrollDown("bottom");

		checkbox.click();
		ReusableMethod.scrollDown("bottom");
		ReusableMethod.scrollDown("bottom");

		Assert.assertEquals(returnandRefundTxt.getText(), "BagScreen-Return Refund");
		ReusableMethod.scrollDown("bottom");
		refundBtn.click();
		wait.until(ExpectedConditions.visibilityOf(refundHeader));
		Assert.assertEquals(refundHeader.getText(), "RETURN & REFUND");
		backBtn.click();
		placeOrder.click();
	}

	public void Verify_DeliveryAddress() {
		wait.until(ExpectedConditions.visibilityOf(deliveryTxt));
		// Assert.assertEquals(addressWarningMsg.getText(),"Seems like you don't have
		// any address with your selected pincode. Please modify your address.");
		ReusableMethod.scrollDown("bottom");
		addGiftWrap.click();
		wait.until(ExpectedConditions.visibilityOf(sendTxt));
		try {
			driver.getKeyboard();
			recepientName.sendKeys("Testing Hng");
			messageField.sendKeys("Super app well  done team");
			driver.hideKeyboard();
			senderName.sendKeys("TesterNameQa");
		} catch (Exception e) {
			driver.getKeyboard();
			recepientName.sendKeys("Testing Hng");
			messageField.sendKeys("Super app well  done team");
			driver.hideKeyboard();
			senderName.sendKeys("TesterNameQa");
		}
		imageView.click();
		doneBtn.click();
		try {
			wait.until(ExpectedConditions.visibilityOf(removeGiftBtn));
			Assert.assertEquals(removeGiftBtn.getText(), "REMOVE GIFT WRAP");
			removeGiftBtn.click();
			Assert.assertTrue(addGiftWrap.isEnabled());
			Assert.assertEquals(unavailable.getText(), "2 items are unavailable for this pincode");
			viewItems.click();
			Assert.assertEquals(itemsNotAvailable.getText(), "UNAVAILABLE ITEMS");
		} catch (Exception e) {
			// TODO: handle exception
		}
		removeBtn.isEnabled();
		moveToWishListBtn.isEnabled();
		try
		{
		closeBtn.click();
		}
		catch (Exception e) {
			ReusableMethod.tap_On_Element(343, 432);
		}
	}

	public void add_New_Address() {
		wait.until(ExpectedConditions.visibilityOf(placeOrder));
		 
		placeOrder.click();

		wait.until(ExpectedConditions.visibilityOf(addNewAddress));
		addNewAddress.click();
		try {
			wait.until(ExpectedConditions.visibilityOf(addNewAddress));
		} catch (Exception e) {
			e.getMessage();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='ADD NEW ADDRESS']")));
		}
		Assert.assertEquals(addNewAddress.getText(), "ADD NEW ADDRESS");
		Assert.assertTrue(useCurrentLocation.isEnabled());
		try {
			driver.getKeyboard();
			searchField.sendKeys("udupi");
		}

		catch (Exception e) {
			driver.getKeyboard();
			searchField.sendKeys("udupi");
		}

		driver.hideKeyboard();
		wait.until(ExpectedConditions.visibilityOf(searchResult));
		searchResult.click();
		wait.until(ExpectedConditions.visibilityOf(pincode));

		try {
			driver.getKeyboard();
			pincode.sendKeys("576101");

		}

		catch (Exception e) {
			driver.getKeyboard();
			pincode.sendKeys("576101");
		}
		driver.hideKeyboard();

		// pincode.sendKeys("576101");
		try {
			driver.getKeyboard();
			nameField.sendKeys("Kundapura");
		} catch (Exception e) {
			driver.getKeyboard();
			nameField.sendKeys("Kundapura");
		}
		phoneFiled.sendKeys("9879765438");
		ReusableMethod.scrollDown("bottom");
		houseInput.sendKeys("NearTempleRoad#23");
		landMark.sendKeys("Near junoir college");
		try
		{
		homeBtn.click();
		homeBtn.click();
		homeBtn.click();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			homeBtn.click();
		}
		saveBtn.click();

		wait.until(ExpectedConditions.visibilityOf(saveaddressMsg));
		driver.findElement(By.xpath("(//XCUIElementTypeButton)[6]")).click();
		addNewBtn.isEnabled();
		changeAddress.isEnabled();
		try
		{
	//	payBtn.click();
		driver.findElement(By.xpath("(//XCUIElementTypeButton)[5]")).click();
		}
		catch (Exception e) {
			e.getMessage();		
			driver.findElement(By.xpath("(//XCUIElementTypeButton)[5]")).click();
		}
		
		wait.until(ExpectedConditions.visibilityOf(paymentMethods));
		Assert.assertEquals(paymentMethods.getText(), "Payment Methods");

		List<MobileElement> paymentOption = driver.findElements(By.className("XCUIElementTypeStaticText"));
		for (MobileElement pay : paymentOption) {
			if (pay.getText().contains("SBI Debit")) {
				Assert.assertEquals(pay.getText(), "SBI Debit");
			} else if (pay.getText().contains("UPI - Google Pay")) {
				Assert.assertEquals(pay.getText(), "UPI - Google Pay");
			} else if (pay.getText().contains("UPI - Amazon Pay")) {
				Assert.assertEquals(pay.getText(), "UPI - Amazon Pay");
			}

			else if (pay.getText().contains("UPI - PhonePe")) {
				Assert.assertEquals(pay.getText(), "UPI - PhonePe");
			}
		}
	}
}
