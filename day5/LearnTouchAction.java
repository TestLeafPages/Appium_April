package day5;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class LearnTouchAction {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.the511plus.MultiTouchTester");
		dc.setCapability("appActivity", "com.the511plus.MultiTouchTester.MultiTouchTester");
		dc.setCapability("deviceName", "OnePlus+");
		dc.setCapability("platformName", "Android");
		dc.setCapability("noReset", true);

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//ScrollDown
		// Get the screen size
		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
		int width = size.getWidth();
		int height = size.getHeight();

		// find the position that where we need to touch
		int startX = (int) (width * 0.5);
		int startY = (int) (height * 0.1);

		int endX = (int) (width * 0.5);
		int endY = (int) (height * 0.8);

		System.out.println(height +"======"+ width);
		System.out.println(startX + "====="+ startY);
		System.out.println(endX + "====="+ endY);

		// Class<dataType> obj =  new Class<>();

		Actions builde = new Actions(driver);

		TouchAction<?> action = new TouchAction<>(driver)

				.press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				.moveTo(PointOption.point(endX, endY))
				.release()
				.perform();






	}

}
