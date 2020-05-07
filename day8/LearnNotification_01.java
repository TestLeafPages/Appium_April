package day8;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class LearnNotification_01 {
	
	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "net.oneplus.launcher");
		dc.setCapability("appActivity", "net.oneplus.launcher.Launcher");
		dc.setCapability("deviceName", "OnePlus+");
		dc.setCapability("platformName", "Android");
		dc.setCapability("noReset", true);

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.openNotifications();
		
		String text = driver.findElementByXPath("//*[@text='USB debugging connected']").getText();
		System.out.println(text);
		
		
		WebElement ele = driver.findElementByXPath("//*[@text='USB debugging connected']");
		
		driver.findElementByXPath("//*[@text='USB debugging connected']").click();
		
		
		List<WebElement> allText = driver.findElementsById("android:id/title");
		for (WebElement eachText : allText) {
			System.out.println(eachText.getText());
		}
		
		/*
		 * if(!ele.isDisplayed()) { // scroll }
		 */
		
		
	}

}
