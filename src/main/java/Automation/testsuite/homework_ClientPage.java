package Automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Automation.common.CommonBase;
import Automation.constant.CT_Account_Rise;
import Automation.pagelocator.Pagelocator_Rise;

public class homework_ClientPage extends CommonBase{

	@BeforeMethod
	@Parameters("browserTest")
	
	public void OpenBrowser(@Optional("Chrome") String browserName) {
		setupDriver(browserName);
		driver.get(Automation.constant.CT_Account_Rise.Web_URL);
		}
	
	private void assertClientsGroup(String clientsGroup) {
		
		List<WebElement> listClients = driver.findElements(By.xpath("//table[@id='client-table']//tbody//tr/child::td[5]/ul/li"));
		for(WebElement item:listClients) {
			String actual = item.getText();
			assertEquals(actual, clientsGroup);
			
		}
	}
	
	private void assertLabelList(String label) {
		
		List<WebElement> LabelList = driver.findElements(By.xpath("//table//tbody/tr/child::td[6]/span"));
		for(WebElement item:LabelList) {
			String actual = item.getText();
			assertEquals(actual, label);
		}
		
	}
	
	@Test(priority = 1)
	public void filterTaskByAssignedTo() throws InterruptedException{
		//loginsuccess
		Pagelocator_Rise login = new Pagelocator_Rise(driver);
		login.LoginFunction(CT_Account_Rise.Email,CT_Account_Rise.Password );
		
		String clientsGroup ="Gold";
		String label = "Inactive";
		
		//click Client   , click client, click show +; 
		click(By.xpath("//span[text()='Clients']"));
		click(By.xpath("//li/a[text()='Clients']"));
		click(By.xpath("//button[@class='btn btn-default show-filter-form-button']"));
		
		//click clients group, chon gold, 
		click(By.xpath("//div[@id='s2id_autogen7']"));
		type(By.xpath("(//input[@type='text' and @autocomplete='off'])[5]"),clientsGroup);
		typeKeyTabs(By.xpath("(//input[@type='text' and @autocomplete='off'])[5]"));
		
		//click click Label , chon Inactive s2id_autogen9
		click(By.xpath("//div[@id='s2id_autogen9']"));
		type(By.xpath("(//input[@type='text' and @autocomplete='off'])[5]"),label);
		typeKeyTabs(By.xpath("(//input[@type='text' and @autocomplete='off'])[5]"));
		
		
		Thread.sleep(3000);
		assertClientsGroup(clientsGroup);
		
		Thread.sleep(3000);
		assertLabelList(label);
		
		
		
	}
	@AfterMethod
	public void CloseBrowser() {
		quitDriver(driver);
	}

}
