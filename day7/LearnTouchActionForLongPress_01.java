package day7;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class LearnTouchActionForLongPress_01 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.oneplus.mms");
		dc.setCapability("appActivity", "com.android.mms.ui.ConversationList");
		dc.setCapability("deviceName", "OnePlus+");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("noReset", true);

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Thread.sleep(3000);

		driver.findElementById("com.oneplus.mms:id/action_search_conversation").click();
		//driver.findElementByAccessibilityId("Search messages").click();

		Thread.sleep(2000);
		driver.findElementById("com.oneplus.mms:id/search_src_text").sendKeys("TL Sarath");
		System.out.println("completed");

		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/"
				+ "android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/"
				+ "android.widget.RelativeLayout/android.widget.TextView[1]").click();

		WebElement eleMsg = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"You sent a message\"]/"
				+ "android.widget.LinearLayout[1]/android.widget.LinearLayout");

		// LongPress
		TouchAction<?> action =  new TouchAction<>(driver)
				.longPress(LongPressOptions.longPressOptions()
						.withElement(ElementOption.element(eleMsg))
						.withDuration(Duration.ofSeconds(2)))
						.release()
						.perform();
		
		String text = driver.findElementByXPath("//*[@text='View details']").getText();
		System.out.println(text);
		
		




	}



}
