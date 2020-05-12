package day9;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;

public class MobileWrapper {
	
	public static AppiumDriver<WebElement> driver;
	
	//Launch app
	public boolean launchApp(String appPacakage, String appActivity, String deviceName) throws MalformedURLException {
		boolean bReturn = false;
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("appPackage", appPacakage);
			dc.setCapability("appActivity", appActivity);
			dc.setCapability("deviceName", deviceName);
			dc.setCapability("platformName", "Android");
			dc.setCapability("automationName", "UiAutomator2");
			dc.setCapability("noReset", true);
			
			
			
			

			driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			bReturn = true;
		} catch (MalformedURLException e) {
			
		}
		return bReturn;
	}
	
	//launch Browser
	public boolean launchBrowser(String browerName, String deviceName, String url) throws MalformedURLException {
		boolean bReturn = false;
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("browserName", browerName);
			dc.setCapability("deviceName", deviceName);
			driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			bReturn = true;
		} catch (MalformedURLException e) {
			
		}
		return bReturn;
	}
	
	// Only for Android
	public boolean switchBetweenAppsInAndroid(String appPackage, String appActivity) {
		boolean bReturn = false;
		try {
			((StartsActivity) driver).startActivity(new Activity(appPackage, appActivity));
			bReturn = true;
		} catch (Exception e) {

		}
		return bReturn;
	}
	
	

}
