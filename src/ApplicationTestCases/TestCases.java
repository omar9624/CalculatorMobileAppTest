package ApplicationTestCases;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestCases extends Parameters{

	
	@BeforeTest
	public void setup() {
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ERROR DEVICE");

		File application = new File("src/Applications/calculator.apk");

		caps.setCapability(MobileCapabilityType.APP, application.getAbsolutePath());
	}

	@Test()
	public void ClickOnTheEvenNmber() throws IOException {
		driver = new AndroidDriver(new URL(url), caps);
		
		List<WebElement> buttonList = driver.findElements(By.className("android.widget.ImageButton"));
		
		for(var i=0 ; i < buttonList.size() ; i++) {
			
			WebElement button = buttonList.get(i);
			if(button.getAttribute("resource-id").contains("digit")) {
				int number = Integer.valueOf(button.getAttribute("content-desc")); 
				if(number%2 == 0) {
					button.click();
					
					TakeScreenshot();
				}
			}
		}
		
	}
}
