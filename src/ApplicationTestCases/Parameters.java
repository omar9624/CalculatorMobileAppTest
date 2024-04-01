package ApplicationTestCases;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.asserts.Assertion;


import io.appium.java_client.android.AndroidDriver;

public class Parameters {
	
	DesiredCapabilities caps = new DesiredCapabilities();

	AndroidDriver driver;
	
	Assertion myAssert = new Assertion();
	
	String url = "http://127.0.0.1:4723/wd/hub";

	
	public void TakeScreenshot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File file = ts.getScreenshotAs(OutputType.FILE);
		
		LocalDateTime date =  LocalDateTime.now();
		System.out.println(date);
		
		String filename = date.toString().replace(":", "-");
		
		FileUtils.copyFile(file, new File("./src/images/"+filename+".jpg"));
	}
}
