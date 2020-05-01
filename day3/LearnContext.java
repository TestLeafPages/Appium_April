package day3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class LearnContext {
	
	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		dc.setCapability("deviceName", "OnePlus+");
		dc.setCapability("platformName", "Android");
		dc.setCapability("noReset", true);

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Set<String> allCon = driver.getContextHandles();
		System.out.println(allCon.size());

		for (String eachCon : allCon) {
			System.out.println(eachCon);
			driver.context(eachCon);
		}
		
		driver.findElementByXPath("(//android.widget.EditText)[1]").sendKeys("sakthivel@testleaf.com");
		driver.findElementByXPath("(//android.widget.EditText)[2]").sendKeys("Leaf@123");
		
		
		
		
	}

}
