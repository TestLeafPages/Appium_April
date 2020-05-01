package day3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class UsingEmulator {
	
	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "Android Emulator");
		dc.setCapability("platformVersion", "9.0");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		
		dc.setCapability("appPackage", "com.google.android.apps.messaging");
		dc.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
		
		AndroidDriver<WebElement> driver =  new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

}
