package Automation.testsuite;

import Automation.common.CommonBase;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Automation.constant.CT_Account_Alada;
import Automation.constant.CT_Account_Rise;
import Automation.pagelocator.Pagelocator_Alada;



public class ChangeAvatar extends CommonBase{
	
	@BeforeMethod
	
	public void OpenChromeDriver() {
		driver = initChromeDriver(CT_Account_Alada.Web_URL);
	}
	
	@Test(priority = 1)
	
	public void LoginSuccess() {
		
		Pagelocator_Alada page = new Pagelocator_Alada(driver);
		page.LoginFunction(CT_Account_Alada.Email, CT_Account_Alada.Password);
		assertTrue(driver.findElement(CT_Account_Alada.Main_Page).isDisplayed());
	}
	
	
	@Test(priority = 2)
	
	public void ChangeAva() {
		Pagelocator_Alada page = new Pagelocator_Alada(driver);
		page.LoginFunction(CT_Account_Alada.Email, CT_Account_Alada.Password);
		page.ChangeInforAvatar("/Users/admin/Desktop/hôhho.jpg.sb-bc629bee-4G4K0L");
		assertTrue(driver.findElement(By.xpath("/Users/admin/Desktop/hôhho.jpg.sb-bc629bee-4G4K0L")).isDisplayed());
	}
	
	//@AfterMethod
	//public void CloseBrowser() {
	//	quitDriver(driver);
	//}
	
	
}
