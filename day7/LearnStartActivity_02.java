package day7;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class LearnStartActivity_02 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.whatsapp");
		dc.setCapability("appActivity", "com.whatsapp.HomeActivity");
		dc.setCapability("deviceName", "OnePlus+");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("noReset", true);

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Thread.sleep(2000);

		//driver.findElementById("com.whatsapp:id/menuitem_search").click();
		driver.findElementByAccessibilityId("Search").click();
		//driver.findElementByAccessibilityId(using)


		driver.findElementById("com.whatsapp:id/search_src_text").sendKeys("APPIUM APRIL WD 2020");
		Thread.sleep(2000);

		driver.findElementById("com.whatsapp:id/conversations_row_contact_name").click();


		// switch control from one activity to another activity(diff app)
		Activity act =  new Activity("com.oneplus.mms", "com.android.mms.ui.ConversationList");
		driver.startActivity(act);


		//driver.startActivity(new Activity("com.oneplus.mms", "com.android.mms.ui.ConversationList"));

		Thread.sleep(3000);

		driver.findElementById("com.oneplus.mms:id/action_search_conversation").click();
		//driver.findElementByAccessibilityId("Search messages").click();

		Thread.sleep(2000);
		driver.findElementById("com.oneplus.mms:id/search_src_text").sendKeys("TL Sarath");
		System.out.println("completed");

		Thread.sleep(2000);

		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/"
				+ "android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/"
				+ "android.widget.RelativeLayout/android.widget.TextView[1]").click();


		String text = driver.findElementById("com.oneplus.mms:id/message_text").getText();


		// way 2 // switch control from one activity to another activity(diff app)

		Activity act1 = new Activity("com.whatsapp", "com.whatsapp.HomeActivity");
		driver.startActivity(act1);

		Thread.sleep(2000);

		//driver.findElementById("com.whatsapp:id/menuitem_search").click();
		driver.findElementByAccessibilityId("Search").click();
		//driver.findElementByAccessibilityId(using)


		driver.findElementById("com.whatsapp:id/search_src_text").
		sendKeys("APPIUM APRIL WD 2020");
		
		Thread.sleep(2000);

		driver.findElementById("com.whatsapp:id/conversations_row_contact_name").click();


		driver.findElementById("com.whatsapp:id/entry").sendKeys(text);

		driver.findElementById("com.whatsapp:id/send").click();
		
		
		// way 1:
	//	new Activity("appPackage", "appActivity").setStopApp(false);
			


	}

}
