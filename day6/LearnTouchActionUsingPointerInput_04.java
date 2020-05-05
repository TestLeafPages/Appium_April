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

public class LearnTouchActionUsingPointerInput_04 {
	
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
		
		
		// Action 1
		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		Sequence dragNdrop1 = new Sequence(finger1, 1);
		
		dragNdrop1.addAction(finger1.createPointerMove(Duration.ofMillis(0), 
				PointerInput.Origin.viewport(), sX, sY));
				
		dragNdrop1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			
		dragNdrop1.addAction(finger1.createPointerMove(Duration.ofMillis(3000), 
				PointerInput.Origin.viewport(), eX, eY));
		
		dragNdrop1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
	
		// Action 2
		PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
		Sequence dragNdrop2 = new Sequence(finger2, 2);
		
		dragNdrop2.addAction(finger2.createPointerMove(Duration.ofMillis(0), 
				PointerInput.Origin.viewport(), sX, sY+600));
				
		dragNdrop2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			
		dragNdrop2.addAction(finger2.createPointerMove(Duration.ofMillis(3000), 
				PointerInput.Origin.viewport(), eX, eY+600));
		
		dragNdrop2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		
		driver.perform(Arrays.asList(dragNdrop1, dragNdrop2));
		
		
		
		
		
		
				
		
		
		
	}

}












