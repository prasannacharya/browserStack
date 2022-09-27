package com.util;

import java.io.FileOutputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Reporter;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;


import com.base.Base;
import com.google.common.collect.ImmutableList;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofMillis;

public class ReusableMethod extends Base {
	private static JavascriptExecutor js;
	private static HashMap<String, String> scrollObject = new HashMap<>();
	private static Dimension windowSize;

	public static void performScroll(IOSElement element) {
//		Reporter.log("Swiping the screen -----Please wait...!!!",true);
//		scrollObject.put("direction", "down");
//		scrollObject.put("element", element.getId());
//		System.out.println(element.getId());
//		js.executeScript("mobile: swipe", scrollObject);
//		Reporter.log("Swipe action completed..!!!..please continue",true);

	}

	public static void setValueToProperties(String newPassword) {
		try {
			FileOutputStream out = new FileOutputStream(
					System.getProperty("user.dir") + "/src/main/java/com/config/config.properties");
			prop.setProperty("password", newPassword);
			prop.save(out, newPassword);

		} catch (Exception e) {
			e.getCause();
			e.getMessage();
			e.printStackTrace();
		}

	}

	public static String generatePassword() {

		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmno";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 6) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr + "a1" + "@";

	}

	public static void scrollTillEnd() {
		try {
			Reporter.log("Scrolling the screen Please wait...!!!!!...", true);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", scrollObject);

		} catch (Exception e) {
			e.getStackTrace();
			e.getCause();
			e.getMessage();
		}
	}
//
//	public static void scroll(ScrollDirection dir, double distance) {
//		if (distance < 0 || distance > 1) {
//			throw new Error("Scroll distance must be between 0 and 1");
//		}
//		Dimension size = getWindowSize();
//		Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));
//		int top = midPoint.y - (int) ((size.height * distance) * 0.5);
//		int bottom = midPoint.y + (int) ((size.height * distance) * 0.5);
//		int left = midPoint.x - (int) ((size.width * distance) * 0.5);
//		int right = midPoint.x + (int) ((size.width * distance) * 0.5);
//		if (dir == ScrollDirection.UP) {
//			swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
//		} else if (dir == ScrollDirection.DOWN) {
//			swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
//		} else if (dir == ScrollDirection.LEFT) {
//			swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR);
//		} else {
//			swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR);
//		}
//		Reporter.log("Swipe action completed..!!!..please continue", true);
//	}

	public enum ScrollDirection {
		UP, DOWN, LEFT, RIGHT
	}

	private static Dimension getWindowSize() {
		if (windowSize == null) {
			windowSize = driver.manage().window().getSize();
		}
		System.out.println(windowSize);
		return windowSize;
	}

//	//protected static void swipe(Point start, Point end, Duration duration) {
//		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
//		Sequence swipe = new Sequence(input, 0);
//		swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
//		swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
////	        if (isAndroid) {
////	            duration = duration.dividedBy(ANDROID_SCROLL_DIVISOR);
////	        } else {
//		swipe.addAction(new Pause(input, duration));
//		duration = Duration.ZERO;
//		// }
//		swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
//		swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//		driver.perform(ImmutableList.of(swipe));
//	}
	public static void scrollDown(String action) {
		if (action.equalsIgnoreCase("bottom")) {
			Reporter.log("Scrolling the screen please wait..!!!!!1", true);
			Dimension dimension = driver.manage().window().getSize();
			int scrollStart = (int) (dimension.getHeight() * 0.9);
			int scrollEnd = (int) (dimension.getHeight() * 0.0);

			new TouchAction((PerformsTouchActions) driver).press(PointOption.point(0, scrollStart))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(0, scrollEnd))
					.release().perform();
			Reporter.log("Scroll to bottom  completed..!!!..please continue", true);
		}
		else {
			Reporter.log("Scrolling the screen please wait..!!!!!1", true);
			Dimension dimension = driver.manage().window().getSize();
			int scrollStart = (int) (dimension.getHeight() * 0.3);
			int scrollEnd = (int) (dimension.getHeight() * 0.8);

			new TouchAction((PerformsTouchActions) driver).press(PointOption.point(0, scrollEnd))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(PointOption.point(0, scrollStart)).release().perform();
			Reporter.log("Scroll to top completed..!!!..please continue", true);

		}
		
		

	}

	public static void hideKeyboard() {

		if (driver.isKeyboardShown()) {
			driver.hideKeyboard();
		}
	}

	public static void swipe(Direction dir) {
	    System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

	    // Animation default time:
	    //  - Android: 300 ms
	    //  - iOS: 200 ms
	    // final value depends on your app and could be greater
	    final int ANIMATION_TIME = 200; // ms

	    final int PRESS_TIME = 200; // ms

	    int edgeBorder = 10; // better avoid edges
	    PointOption pointOptionStart, pointOptionEnd;

	    // init screen variables
	    Dimension dims = driver.manage().window().getSize();

	    // init start point = center of screen
	    pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

	    switch (dir) {
	        case DOWN: // center of footer
	            pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
	            break;
	        case UP: // center of header
	            pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
	            break;
	        case LEFT: // center of left side
	            pointOptionEnd = PointOption.point(edgeBorder, dims.height / 5);
	            break;
	        case RIGHT: // center of right side
	            pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 5);
	            break;
	        default:
	            throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
	    }

	    // execute swipe using TouchAction
	    try {
	        new TouchAction(driver)
	                .press(pointOptionStart)
	                // a bit more reliable when we add small wait
	                .waitAction(WaitOptions.waitOptions(ofMillis(PRESS_TIME)))
	                .moveTo(pointOptionEnd)
	                .release().perform();
	    } catch (Exception e) {
	        System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
	        return;
	    }

	    // always allow swipe action to complete
	    try {
	        Thread.sleep(ANIMATION_TIME);
	    } catch (InterruptedException e) {
	        // ignore
	    }
	}
	

	public enum Direction {
		UP, DOWN, LEFT, RIGHT
	}
	
	
	
	public static void SwipeScreen(WebElement el) throws InterruptedException {
//		WebElement Panel = el;
//		Dimension dimension = Panel.getSize();
//		
//		int Anchor = Panel.getSize().getHeight()/2; 
//		
//		Double ScreenWidthStart = dimension.getWidth() * 0.1;
//		int scrollStart = ScreenWidthStart.intValue();
//		
//		Double ScreenWidthEnd = dimension.getWidth() * 0.8;
//		int scrollEnd = ScreenWidthEnd.intValue();
//		
//		new TouchAction((PerformsTouchActions) driver)
//		.press(PointOption.point(scrollStart, Anchor))
//		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
//		.moveTo(PointOption.point(scrollEnd, Anchor))
//		.release().perform();
//		
//		Thread.sleep(3000);
		Dimension dimension = driver.manage().window().getSize();

		Double ScreenWidthStart = dimension.getWidth() * 0.1;
		int scrollStart = ScreenWidthStart.intValue();
		Double ScreenWidthEnd = dimension.getWidth() * 0.8;
		int scrollEnd = ScreenWidthEnd.intValue();
		new TouchAction((PerformsTouchActions) driver) 
        .press(PointOption.point(0, scrollStart)) 
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))) 
        .moveTo(PointOption.point(0, scrollEnd)) 
        .release().perform();
	}
	
	
//		 public static void singleTap (MobileElement iosElement) {
//		        new TouchAction(driver)
//		            .tap(tapOptions().withElement(element(iosElement)))
//		            .waitAction(waitOptions(ofMillis(250))).perform();
//		    }
//
		 public static  void horizontalSwipeByPercentage (double startPercentage, double endPercentage, double anchorPercentage) {
		        Dimension size = driver.manage().window().getSize();
		        int anchor = (int) (size.height * anchorPercentage);
		        int startPoint = (int) (size.width * startPercentage);
		        int endPoint = (int) (size.width * endPercentage);
		        new TouchAction(driver)
		            .press(point(startPoint, anchor))
		            .waitAction(waitOptions(ofMillis(1000)))
		            .moveTo(point(endPoint, anchor))
		            .release().perform();
		        System.out.println("swipe done-----");
		    }

		 public static void swipeRight() {

				//The viewing size of the device
				Dimension size = driver.manage().window().getSize();

				//Starting x location set to 5% of the width (near left)
				int startx = (int) (size.width * 0.05);
				//Ending x location set to 95% of the width (near right)
				int endx = (int) (size.width * 0.95);
				//y position set to mid-screen vertically
				int starty = size.height / 2;
				scroll(startx, starty, endx, starty);

			}
		 
		 private static void scroll(int fromX, int fromY, int toX, int toY) {
				TouchAction touchAction = new TouchAction(driver);
				touchAction.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
			}
		 
		 
		 //Swipe by elements
//		    public static  void swipeByElements ( WebElement startElement, WebElement endElement) {
//		        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
//		        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);
//		        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
//		        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);
//		        new TouchAction(driver)
//		            .press(point(startX,startY))
//		            .waitAction(waitOptions(ofMillis(1000)))
//		            .moveTo(point(endX, endY))
//		            .release().perform();
//		    }
//
		    public static  void tap_On_Element(int x,int y)
		    {
		          TouchAction touchAction = new TouchAction(driver);
		          touchAction.tap(PointOption.point(x,y))
		                     .perform();
		    }
}