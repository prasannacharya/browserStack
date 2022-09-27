package com.screens;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.base.Base;
import com.util.ReusableMethod;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PersonaliseScreen extends Base {

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public PersonaliseScreen() {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		jse.executeScript(
				"browserstack_executor: {\"action\": \"setSessionName\", \"arguments\": {\"name\":\"PersonaliseScreenTest \" }}");

	}

	@FindBy(xpath = "//XCUIElementTypeOther[@name='PERSONALISE']")
	MobileElement personalisePageHeader;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='SKIN ANALYSIS RESULT']")
	MobileElement skinAnalysisRes;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Profile-Personalize-SkinAnalysis-ViewDetailsButton']")
	MobileElement viewDetailsBtn;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='SKIN DETAILS']")
	MobileElement skinDetailsTitle;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='HAIR DETAILS']")
	MobileElement hairDetailsTitle;

	@FindBy(xpath = "(//XCUIElementTypeOther)[68]")
	MobileElement saveDetailsButton;

	@FindBy(xpath = "(//XCUIElementTypeOther)[31]")
	MobileElement skinColorLink;

	@FindBy(xpath = "(//XCUIElementTypeOther)[34]") // Welcome-LoginForgotPasswordButton
	MobileElement skinTypeLink;

	@FindBy(xpath = "(//XCUIElementTypeOther)[40]")
	MobileElement hairTypeLink;

	@FindBy(xpath = "(//XCUIElementTypeOther)[43]") // Welcome-LoginButton
	MobileElement hairStrengthLink;

	@FindBy(xpath = "(//XCUIElementTypeOther)[49]")
	MobileElement categoriesLink;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='INTERESTS']")
	MobileElement interestTitle;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='CONCERNS']") // Welcome-LoginPasswordInput
	MobileElement concernsTitle;

	@FindBy(xpath = "(//XCUIElementTypeOther)[55]")
	MobileElement skinLink;

	@FindBy(xpath = "(//XCUIElementTypeOther)[58]")
	MobileElement eyesLink;

	@FindBy(xpath = "(//XCUIElementTypeOther)[61]")
	MobileElement lipsLink;

	@FindBy(xpath = "(//XCUIElementTypeOther)[64]")
	MobileElement hairLink;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='SKIN COLOUR']")
	MobileElement colourTxt;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='SKIN TYPE']")
	MobileElement typeTxt;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Profile-Personalize-DoneButton']")
	MobileElement doneBtn;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='HAIR TYPE']") // Welcome-LoginPasswordInput
	MobileElement hairTypeTxt;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='HAIR STRENGTH']")
	MobileElement hairStrengthTxt;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='CATEGORIES & BRANDS']")
	MobileElement categoriesTxt;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='SKIN CONCERN']")
	MobileElement skinConernTxt;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='EYES CONCERN']")
	MobileElement eyeConcernTxt;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='LIPS CONCERN']")
	MobileElement lipsConcernsTxt;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='HAIR CONCERN']")
	MobileElement hairConcernTxt;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Personalise saved successfully']")
	MobileElement confirmMsg;

	@FindBy(xpath = "//XCUIElementTypeButton")
	MobileElement backBtn;

	public void verifyPersonaliseScreen() {
		try {
			Reporter.log("verifying the personalise screen please wait....!!!", true);

			wait.until(ExpectedConditions.visibilityOf(personalisePageHeader));
			Assert.assertTrue(personalisePageHeader.isEnabled());
			Assert.assertEquals(skinAnalysisRes.getText(), "SKIN ANALYSIS RESULT");
			Assert.assertTrue(viewDetailsBtn.isEnabled());
			Assert.assertEquals(skinDetailsTitle.getText(), "SKIN DETAILS");
			Assert.assertEquals(hairDetailsTitle.getText(), "HAIR DETAILS");
			ReusableMethod.scrollDown("bottom");
			Assert.assertEquals(interestTitle.getText(), "INTERESTS");
			Assert.assertEquals(concernsTitle.getText(), "CONCERNS");
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"verifyPersonaliseScreen execution successfully !\"}}");

		} catch (Exception e) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Found issue in verifyPersonaliseScreen\"}}");

		}
	}

	public void skinColourValidation() {
		wait.until(ExpectedConditions.visibilityOf(personalisePageHeader));
		Assert.assertTrue(personalisePageHeader.isEnabled());
		try {
			skinColorLink.click();
			wait.until(ExpectedConditions.visibilityOf(colourTxt));
			Assert.assertEquals(colourTxt.getText(), "SKIN COLOUR");
//			List<MobileElement> details = driver.findElements(By.xpath("(//XCUIElementTypeOther)[80]"));
//			
//			for (MobileElement skinDetais : details) {
//				System.out.println(skinDetais.getText());
//				skinDetais.click();
//			}
			doneBtn.click();
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"SKIN COLOUR execution successfully !\"}}");

		} catch (Exception e) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Found issue in SKIN COLOUR\"}}");

		}
	}

	public void skinTypeValidation() {
		wait.until(ExpectedConditions.visibilityOf(personalisePageHeader));
		Assert.assertTrue(personalisePageHeader.isEnabled());
		try {
			skinTypeLink.click();
			wait.until(ExpectedConditions.visibilityOf(typeTxt));
			Assert.assertEquals(typeTxt.getText(), "SKIN TYPE");
//			List<MobileElement> details = driver.findElements(By.xpath("(//XCUIElementTypeOther)[80]"));
//			
//			for (MobileElement skinType : details) {
//				System.out.println(skinType.getText());
//				skinType.click();
//			}
			doneBtn.click();
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"SKIN Validation execution successfully !\"}}");

		} catch (Exception e) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Found issue in SKIN Validation\"}}");

		}
	}

	public void hairTypeValidation() {
		wait.until(ExpectedConditions.visibilityOf(personalisePageHeader));
		Assert.assertTrue(personalisePageHeader.isEnabled());
		try {
			hairTypeLink.click();
			wait.until(ExpectedConditions.visibilityOf(hairTypeTxt));
			Assert.assertEquals(hairTypeTxt.getText(), "HAIR TYPE");
//			List<MobileElement> details = driver.findElements(By.xpath("(//XCUIElementTypeOther)[80]"));
//			
//			for (MobileElement skinType : details) {
//				System.out.println(skinType.getText());
//				skinType.click();
//			}
			ReusableMethod.scrollDown("bottom");
			doneBtn.click();
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"hairtype execution successfully !\"}}");

		} catch (Exception e) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Found issue in hair Type\"}}");

		}

	}

	public void hairStrengthValidation() {
		wait.until(ExpectedConditions.visibilityOf(personalisePageHeader));
		Assert.assertTrue(personalisePageHeader.isEnabled());
		try {
			hairStrengthLink.click();
			wait.until(ExpectedConditions.visibilityOf(hairStrengthTxt));
			Assert.assertEquals(hairStrengthTxt.getText(), "HAIR STRENGTH");
			// List<MobileElement> details =
			// driver.findElements(By.xpath("(//XCUIElementTypeOther)[80]"));

//			for (MobileElement skinType : details) {
//				System.out.println(skinType.getText());
//				skinType.click();
//			}se.executeScript(
			doneBtn.click();
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"hairStrength execution successfully !\"}}");

		} catch (Exception e) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Found issue in hair strength\"}}");
		}
	}

	public void categoryBrandValidation() {
		wait.until(ExpectedConditions.visibilityOf(personalisePageHeader));
		Assert.assertTrue(personalisePageHeader.isEnabled());
		try {
			categoriesLink.click();
			wait.until(ExpectedConditions.visibilityOf(categoriesTxt));
			Assert.assertEquals(categoriesTxt.getText(), "CATEGORIES & BRANDS");
//			List<MobileElement> details = driver.findElements(By.xpath("(//XCUIElementTypeOther)[80]"));
//			
//			for (MobileElement category : details) {
//				System.out.println(category.getText());
//				category.click();
//			}
			doneBtn.click();
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Category&Brands execution successfully !\"}}");

		} catch (Exception e) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Found issue in Category&Brands\"}}");

		}

	}

	public void skinValidation() {
		wait.until(ExpectedConditions.visibilityOf(personalisePageHeader));
		Assert.assertTrue(personalisePageHeader.isEnabled());
		try {
			skinLink.click();
			wait.until(ExpectedConditions.visibilityOf(skinConernTxt));
			Assert.assertEquals(skinConernTxt.getText(), "SKIN CONCERN");
//			List<MobileElement> details = driver.findElements(By.xpath("(//XCUIElementTypeOther)[80]"));
//			
//			for (MobileElement skin : details) {
//				System.out.println(skin.getText());
//				skin.click();
//			}
			ReusableMethod.scrollDown("bottom");
			doneBtn.click();
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"skinConcern execution successfully !\"}}");

		} catch (Exception e) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Found issue in skin concern\"}}");

		}

	}

	public void eyeValidation() {
		wait.until(ExpectedConditions.visibilityOf(personalisePageHeader));
		Assert.assertTrue(personalisePageHeader.isEnabled());

		try {
			eyesLink.click();
			wait.until(ExpectedConditions.visibilityOf(eyeConcernTxt));
			Assert.assertEquals(eyeConcernTxt.getText(), "EYES CONCERN");
//			List<MobileElement> details = driver.findElements(By.xpath("(//XCUIElementTypeOther)[80]"));
//
//			for (MobileElement eye : details) {
//				System.out.println(eye.getText());
//				eye.click();
//			}
			doneBtn.click();
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"EyeConcern execution successfully !\"}}");

		} catch (Exception e) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Found issue in Eye concern\"}}");

		}

	}

	public void lipsValidation() {
		wait.until(ExpectedConditions.visibilityOf(personalisePageHeader));
		Assert.assertTrue(personalisePageHeader.isEnabled());

		try {
			lipsLink.click();
			wait.until(ExpectedConditions.visibilityOf(lipsConcernsTxt));
			Assert.assertEquals(lipsConcernsTxt.getText(), "LIPS CONCERN");
//			List<MobileElement> details = driver.findElements(By.xpath("(//XCUIElementTypeOther)[80]"));
//
//			for (MobileElement lip : details) {
//				System.out.println(lip.getText());
//				lip.click();
//			}
			doneBtn.click();

			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"LipsConcern execution successfully !\"}}");

		} catch (Exception e) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Found issue in lips concern\"}}");

		}

	}

	public void hairValidation() {
		wait.until(ExpectedConditions.visibilityOf(personalisePageHeader));
		Assert.assertTrue(personalisePageHeader.isEnabled());

		try {
			hairLink.click();
			wait.until(ExpectedConditions.visibilityOf(hairConcernTxt));
			Assert.assertEquals(hairConcernTxt.getText(), "HAIR CONCERN");
//			List<MobileElement> details = driver.findElements(By.xpath("(//XCUIElementTypeOther)[80]"));
//
//			for (MobileElement hair : details) {
//				System.out.println(hair.getText());
//				hair.click();
//			}
			doneBtn.click();
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"hairConcern execution successfully !\"}}");

		} catch (Exception e) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Found issue in hair concern\"}}");

		}

	}

	public void personaliseVerfication() {
		Reporter.log("verifying the personalise functionality please wait....!!!", true);
		try {
			skinColourValidation();
			skinTypeValidation();
			hairTypeValidation();
			hairStrengthValidation();
			// ReusableMethod.performScroll("INTERESTS", driver);
			categoryBrandValidation();
			skinValidation();
			eyeValidation();
			lipsValidation();
			hairValidation();
			wait.until(ExpectedConditions.visibilityOf(saveDetailsButton));
			saveDetailsButton.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			wait.until(ExpectedConditions.visibilityOf(confirmMsg));
			Assert.assertEquals(confirmMsg.getText(), "Personalise saved successfully");
			backBtn.click();
//		List<MobileElement> res = driver.findElements(By.xpath("//android.widget.TextView[@index='2']"));
//		for (MobileElement datas : res) {
//			System.out.println(datas.getText());
//		}
//		
//	//	ReusableMethod.performScroll("INTERESTS", driver);
//
//		List<MobileElement> res2 = driver.findElements(By.xpath("//android.widget.TextView[@index='1']"));
//
//		for (MobileElement data2 : res2) {
//			
//			System.out.println(data2.getText());

			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"PersonaliseTest execution successfully !\"}}");

		} catch (Exception e) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Found issue in personalise Test\"}}");

		}
	}
}
