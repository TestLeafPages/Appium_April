package day6;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class LearnTouchAction_Swipe_01 {
	
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
		
		TouchAction<?> action = new TouchAction<>(driver)
				.press(PointOption.point(sX, sY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				.moveTo(PointOption.point(eX, eY))
				.release()
				.perform();
				
		
		
		
	}

}
