package ZenQ.SampleScript;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridWithJenkins {

	WebDriver driver;
	String nodeURL;

	@Parameters({ "Port" })
	@BeforeMethod()
	public void portCheckUp(String Port) throws MalformedURLException {
		if (Port.equalsIgnoreCase("4546")) {
			nodeURL = "http://192.168.43.126:4444/wd/hub";
			System.out.println("Chrome Browser Initiated");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setBrowserName("chrome");
			capabilities.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL(nodeURL), capabilities);
			driver.get("https://www.google.com/");
			driver.manage().window().maximize();
		}

		else if (Port.equalsIgnoreCase("5566")) {
			nodeURL = "http://192.168.43.126:4444/wd/hub";
			System.out.println("Firefox Browser Initiated");
			DesiredCapabilities capabilities1 = DesiredCapabilities.firefox();
			capabilities1.setBrowserName("firefox");
			capabilities1.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL(nodeURL), capabilities1);
			driver.get("https://www.google.com/");
			driver.manage().window().maximize();
		}
	}

	@Test
	public void sampleTest() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("Abhishek Srivastava");
		driver.findElement(By.name("q")).submit();
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
		System.out.println("Browser Closed");
	}
}