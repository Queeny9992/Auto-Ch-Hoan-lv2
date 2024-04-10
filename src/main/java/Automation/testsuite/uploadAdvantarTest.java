package Automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Automation.common.CommonBase;

public class uploadAdvantarTest extends CommonBase{
	
	@BeforeMethod
	public void openPage()
	{
		driver = initChromeDriver("https://demo.guru99.com/test/upload/");
	}
	
	@Test
	public void uploadAdvantarTest() {
		WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
		uploadElement.sendKeys("/Users/admin/Desktop/hôhho.jpg.sb-bc629bee-4G4K0L");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.name("send")).click();
		pause(3000);
	}
}
