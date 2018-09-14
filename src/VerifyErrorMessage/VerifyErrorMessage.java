package VerifyErrorMessage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyErrorMessage {
	
	@Test
	public void Check() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Chetan\\Softs\\SeleniumSuite\\WebDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.gmail.com");
		
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		Thread.sleep(2000);
		
		String actual_Error = driver.findElement(By.xpath("//div[contains(text(),'Enter an email or phone number')]")).getText();
		String expected_Error = "Enter an email or phone number";
		
		//Type-1
		Assert.assertEquals(actual_Error, expected_Error );
		
		//Type-2
		//Assert.assertTrue(actual_Error.contains("Enter an email or phone number"));
		System.out.println("Test successfully completed.");
		driver.close();
	}
}
