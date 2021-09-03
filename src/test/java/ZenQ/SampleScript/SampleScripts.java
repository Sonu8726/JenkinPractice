package ZenQ.SampleScript;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SampleScripts {

	WebDriver driver;
	WebDriverWait wait;

	@Test(priority = 0)
	public void launchURL() {
		driver.get("https://www.phptravels.net/flights");
		System.out.println("1=browser launched");
	}

	@Test(priority = 1)
	public void selectSourcePlace() {
		driver.findElement(By.id("autocomplete")).sendKeys("DEL");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='autocomplete-result'][1]")));
		driver.findElement(By.xpath("//div[@class='autocomplete-result'][1]")).click();
		System.out.print("2=");
		System.out.println("src place selected");
	}

	@Test(priority = 2)
	public void selectDestinationPlace() {
		driver.findElement(By.id("autocomplete2")).sendKeys("DEL");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='autocomplete-result'][1]")));
		driver.findElement(By.xpath("//div[@class='autocomplete-result'][1]")).click();
		System.out.print("3=");
		System.out.println("dest place selected");
	}

	@Test(priority = 3)
	public void clickOnSearchFlight() {

		driver.findElement(By.cssSelector("#flights-search")).click();
		System.out.print("4=");
		System.out.println("Searching flight");
	}

	@BeforeClass
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 5);
	}

	@AfterClass
	public void afterTest() {
		driver.close();
	}

}