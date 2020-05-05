package day6;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class LearnTouchActionUsingPointerInput_03 {
	
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.the511plus.MultiTouchTester");
		dc.setCapability("appActivity", "com.the511plus.MultiTouchTester.MultiTouchTester");
		dc.setCapability("deviceName", "OnePlus+");
		dc.setCapability("platformName", "Android");
		dc.setCapability("noReset", true);

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		Dimension size = driver.manage().window().getSize();
		int sX = (int) (size.getWidth() * 0.2);
		int sY = (int) (size.getHeight() * 0.5);
		
		int eX = (int) (size.getWidth() * 0.8);
		int eY = (int) (size.getHeight() * 0.5);
		
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence dragNdrop = new Sequence(finger, 1);
		
		dragNdrop.addAction(finger.createPointerMove(Duration.ofMillis(0), 
				PointerInput.Origin.viewport(), sX, sY));
				
		dragNdrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			
		dragNdrop.addAction(finger.createPointerMove(Duration.ofMillis(1000), 
				PointerInput.Origin.viewport(), eX, eY));
		
		dragNdrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(Arrays.asList(dragNdrop));
		
		
		
		
		
				
		
		
		
	}

}












