package day3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class InstallApp {
	
	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "OnePlus");
		dc.setCapability("platformName", "Android");
		dc.setCapability("app", "C:\\Users\\dell\\Desktop\\appium\\apks\\leaforg.apk");
		
		AndroidDriver<WebElement> driver =  new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}

}
