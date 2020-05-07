package day8;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidBatteryInfo;
import io.appium.java_client.android.AndroidDriver;

public class LearnBatteryInfo_04 {
	
	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "net.oneplus.launcher");
		dc.setCapability("appActivity", "net.oneplus.launcher.Launcher");
		dc.setCapability("deviceName", "OnePlus+");
		dc.setCapability("udid", "af041859");
		dc.setCapability("platformName", "Android");
		dc.setCapability("noReset", true);

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		/*
		 * // Way 1:- AndroidBatteryInfo batteryInfo = driver.getBatteryInfo();
		 * System.out.println(batteryInfo.getLevel());
		 * System.out.println(batteryInfo.getState());
		 */
		
		//way 2:- 
		Map<String, Object> mp =  new HashMap<>();
		mp.put("command", "dumpsys");
		mp.put("args", "battery");
		Object executeScript = driver.executeScript("mobile:shell", mp);
		
		System.out.println(executeScript.toString());
	}

}
