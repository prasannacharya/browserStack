package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {

	public static IOSDriver driver;
	public static Properties prop;
	public static FileInputStream file;
	public static long PAGE_LOAD_TIMEOUT = 50;
	public static long IMPLICIT_WAIT = 20;
	public static DesiredCapabilities caps;
	public AppiumServiceBuilder builder;
	public AppiumDriverLocalService service;
	public static SimpleDateFormat simpleDateFormat;
	public static JavascriptExecutor jse;
	public static FileInputStream inputStream;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	static int passedCount = 0;
	static int failureCount = 0;
	static int skippedCount = 0;
	public static FileOutputStream fos;

	public Base() {
		/*
		 * Initializing the properties file
		 */
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException exp) {
			exp.printStackTrace();
		}
	}

	@BeforeTest
	public static void ConnectToBrowserStack() {

		Reporter.log("Connecting to  browser stack Server  Please wait.....!!!!!.......", true);

		try {

			caps = new DesiredCapabilities();
//			caps.setCapability("browserstack.user", "niveussolutions1");
//			caps.setCapability("browserstack.key", "mp2Azmni4U3YZyP4uHsV");

			// Set your access credentials
			caps.setCapability("browserstack.user", "prasannaachar1");
			caps.setCapability("browserstack.key", "NVa5uSqy3wvPphyCykWE");

//			caps.setCapability("browserstack.user", "prasannaachar2");
//			caps.setCapability("browserstack.key", "5eRZBPWiLRve8pMG6TCz");
			
		// Set URL of the application under test
			caps.setCapability("app", "bs://e6cf1d88d042ca7e3c6179ea35b3cf9b679bc911");

			// Set URL of the application under test
			// caps.setCapability("app", "bs://32d25d3006c2b9c77e7fb6da60b8709258653c65");

			// Specify device and os_version for testing
			caps.setCapability("device", "iPhone 12");
			caps.setCapability("os_version", "14.1");

			// Set other BrowserStack capabilities
			caps.setCapability("project", "Hng Ios Automation");
			caps.setCapability("build", "HnG Ios Build");
			caps.setCapability("name", "HealthandGlow");
	//		caps.setCapability("browserstack.idleTimeout", "10");
//			caps.setCapability("connectHardwareKeyboard", false);
	//		caps.setCapability("unicodeKeyboard", false);
	//		caps.setCapability("resetKeyboard", false);
			
			URL url = new URL("http://hub.browserstack.com/wd/hub");

			driver = new IOSDriver<>(url, caps);
		} catch (Exception exp) {
			System.out.println("the cause is " + exp.getCause());
			System.out.println("the message is" + exp.getMessage());
			exp.printStackTrace();
		}
		jse = (JavascriptExecutor) driver;

	//	driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);

	}

	@AfterTest
	public void shutDownServer() {

		 driver.quit();
//		((AppiumDriver) driver).resetApp();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@BeforeSuite
	public void setUpReport() throws IOException {

		prop = new Properties();
		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/Qa.properties"));
		prop.load(inputStream);

		/******************** Extent Report *******************/
		htmlReporter = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Report/AutomationReport.html"));
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir") + "/Report/ExtentConfigFile.xml"));
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Operating System", prop.getProperty("OperatingSystem"));
		extent.setSystemInfo("System Name", prop.getProperty("SystemName"));
		extent.setSystemInfo("Environment", prop.getProperty("Environment"));
		extent.setSystemInfo("Platform", "Web Application");

		htmlReporter.config().setDocumentTitle(prop.getProperty("ReportDocumentTitle"));
		htmlReporter.config().setReportName(prop.getProperty("ReportName"));
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);

	}

	//@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		int passed = 0;
		int failed = 0;
		int skipped = 0;
		if (result.getStatus() == ITestResult.FAILURE) {
			failed++;
			File path = new File(System.getProperty("user.dir") + "/Report/ScreenShot/" + result.getName() + ".png");
			try {
				// To create reference of TakesScreenshot
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				// Call method to capture screenshot
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				// Copy files to specific location
				// result.getName() will return name of test case so that screenshot name will
				// be same as test case name
				FileUtils.copyFile(src, path);

				System.out.println("Successfully captured a screenshot");
			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + "Test Failed Due to below issues", ExtentColor.RED));
			test.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(path.getName()).build());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			passed++;
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test is Passed", ExtentColor.GREEN));

		} else {
			skipped++;
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "Test is Skipped ", ExtentColor.YELLOW));
			test.skip(result.getThrowable());

		}
		passedCount = passedCount + passed;
		failureCount = failureCount + failed;
		skippedCount = skippedCount + skipped;
		// driver.quit();
	}

	@AfterSuite
	public void flushReport() throws IOException, InterruptedException {

		extent.flush();

		// SendEmail email = new SendEmail();
		// email.sendEmail(passedCount, failureCount, skippedCount);

	}

	public void reset_App() {
		((AppiumDriver) driver).resetApp();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
