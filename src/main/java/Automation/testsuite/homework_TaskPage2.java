package Automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Automation.common.CommonBase;
import Automation.constant.CT_Account_Rise;
import Automation.constant.CT_Account_Rise;
import Automation.pagelocator.Pagelocator_Rise;


public class homework_TaskPage2 extends CommonBase{

	@BeforeMethod
	@Parameters("browserTest")

	public void OpenBrowser(@Optional("Chrome") String browserName) {
		setupDriver(browserName);
		driver.get(Automation.constant.CT_Account_Rise.Web_URL);
		}
	
	//Assigned to hien thi ten nguoi assigned
	private void assertListAssignedTo(String AssignedTovalueFilter) {
		List<WebElement> listAssignedTo = driver.findElements(By.xpath("//table[@id='task-table']//tbody//tr/child::td[7]/a"));
		for(WebElement item:listAssignedTo) {
			String actual = item.getText();
			assertEquals(actual, AssignedTovalueFilter);
		}
	}
	//Lable hien thi o cot Title
	private void assertListLabel(String AssertLabelValue) {
		List<WebElement> listLabel_Title = driver.findElements(By.xpath("//table[@id='task-table']//tbody//tr/child::td[2]/span/span[text()='Design']"));
		for(WebElement item:listLabel_Title) {
			String actual = item.getText();
			assertEquals(actual, AssertLabelValue);
		}
	}
	
	
	
	
	//Priority hien thi o cot Title, vì nó ko có text nên phải so sánh element
	
	public static boolean assertElementPresent(WebDriver driver, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element != null; // Trả về true nếu phần tử tồn tại
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false; // Trả về false nếu không tìm thấy phần tử
        }
    }

	//check status - check 1 status
			private void assertListstatus(String AssertStatusValue) {
				List<WebElement> listStatus = driver.findElements(By.xpath("//table[@id='task-table']//tbody//tr/child::td[9]/a"));
				for (WebElement item:listStatus) {
					String actual = item.getText();
					assertEquals(actual, AssertStatusValue);
							
				}
			}
			
			
	// check status - check > 1 status, check nhieu status
			private boolean checkFilterStatus(String AssertStatusValue1, String AssertStatusValue2) {
				boolean result=false;
				List<WebElement> listRelatedTo = driver.findElements(By.xpath("//table[@id='task-table']//tbody//tr/child::td[9]/a"));// Element chứa cột status
				for (WebElement item : listRelatedTo) {
					String actual = item.getText(); // Nếu text của Status là filter1 và filter2
					if(actual.equalsIgnoreCase(AssertStatusValue1)||actual.equalsIgnoreCase(AssertStatusValue2))
					{
						result = true;// thì kqua là True
					}
					else result = false; // Ngược lại thì kqua là False
				}
				return result;// Trả về kqua
			}
		
		
	
	
	@Test(priority = 1)
	public void filterTaskByAssignedTo() throws InterruptedException{
		//loginsuccess
		Pagelocator_Rise login = new Pagelocator_Rise(driver);
		login.LoginFunction(CT_Account_Rise.Email,CT_Account_Rise.Password );
		
		//click Task, click show filter +, chon project, chon data, chon assignedTo Jonh Do
		String AssignedTovalueFilter="John Doe";
		String valueFilter = "Data Analysis and Insights";
		String TeamMemberValue = "John Doe";
		
		click(By.xpath("//span[text()='Tasks']"));
		click(By.xpath("//button[@class='btn btn-default show-filter-form-button']"));
		//chon project
		click(By.xpath("//div[@id='s2id_autogen5']"));
		type(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"), "Project");
		typeKeyTabs(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"));
		
		//chon data
		click(By.xpath("//div[@id='s2id_autogen7']"));
		type(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"),valueFilter) ;
		typeKeyTabs(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"));
		
		//chon assignedTo Jonh Do  
		click(By.xpath("//div[@id='s2id_autogen11']"));
		type(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"),TeamMemberValue);
		typeKeyTabs(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"));
		
		Thread.sleep(3000);
		assertListAssignedTo(AssignedTovalueFilter);
	}
	
	
	@Test(priority=2)
	public void filterTaskByLabel() throws InterruptedException{
		Pagelocator_Rise login = new Pagelocator_Rise(driver);
		login.LoginFunction(CT_Account_Rise.Email,CT_Account_Rise.Password );
		
		String AssertLabelValue ="Design";
		String AssignedTovalueFilter ="Sara Ann";
		
		//click Task, click show filter +
		click(By.xpath("//span[text()='Tasks']"));
		click(By.xpath("//button[@class='btn btn-default show-filter-form-button']"));
		//click Team memmber , chon gia tri Sara Ann
		click(By.xpath("//div[@id='s2id_autogen11']"));
		type(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"),AssignedTovalueFilter);
		typeKeyTabs(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"));
		
		//click Label va chon label -- Design
		click(By.xpath("//div[@id='s2id_autogen15']"));
		type(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"),AssertLabelValue);
		typeKeyTabs(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"));
		
		Thread.sleep(3000);
		assertListAssignedTo(AssignedTovalueFilter);
		
		Thread.sleep(3000);
		assertListLabel(AssertLabelValue);
		
		
		

	}
	
	
	@Test(priority=3)
		
	public void filterTaskByPriority()  throws InterruptedException{
		Pagelocator_Rise login = new Pagelocator_Rise(driver);
		login.LoginFunction(CT_Account_Rise.Email,CT_Account_Rise.Password );		
		
		String AssertPriorityValue ="Critical";
		String AssignedTovalueFilter ="Sara Ann";
		String AssertLabelValue = "Design";
		By locator = By.xpath("//table[@id='task-table']//tbody//tr/child::td[2]/span[@title='Priority: Critical ']");
		
		//click Task, click show filter +
		click(By.xpath("//span[text()='Tasks']"));
		click(By.xpath("//button[@class='btn btn-default show-filter-form-button']"));
		
		//click Team memmber , chon gia tri Sara Ann
		click(By.xpath("//div[@id='s2id_autogen11']"));
		type(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"),AssignedTovalueFilter);
		typeKeyTabs(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"));
		
		//click Label va chon label -- Design
		click(By.xpath("//div[@id='s2id_autogen15']"));
		type(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"),AssertLabelValue);
		typeKeyTabs(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]")); 
		
		//click Priority va chon Critical
		click(By.xpath("//div[@id='s2id_autogen13']"));
		type(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"),AssertPriorityValue);
		typeKeyTabs(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"));
		
		
		Thread.sleep(3000);
		assertListAssignedTo(AssignedTovalueFilter);
		
		Thread.sleep(3000);
		assertListLabel(AssertLabelValue);
		
		Thread.sleep(3000);
		boolean isElementPresent = assertElementPresent(driver, locator);
		if (isElementPresent) {
            System.out.println("Phần tử Critical có tồn tại trên trang.");
        } else {
            System.out.println("Phần tử không tồn tại trên trang.");
        }

	}
	
	@Test(priority=4)  //kiem tra theo trang thai status - kiem tra 1 trang thai 
	public void filterByStatus() throws InterruptedException{
		Pagelocator_Rise login = new Pagelocator_Rise(driver);
		login.LoginFunction(CT_Account_Rise.Email,CT_Account_Rise.Password );
		
		String AssertLabelValue ="Design";
		String AssignedTovalueFilter ="Sara Ann";
		String AssertStatusValue ="Done";
		
		//click Task, click show filter +
		click(By.xpath("//span[text()='Tasks']"));
		click(By.xpath("//button[@class='btn btn-default show-filter-form-button']"));
				
		//click Team memmber , chon gia tri Sara Ann
		click(By.xpath("//div[@id='s2id_autogen11']"));
		type(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"),AssignedTovalueFilter);
		typeKeyTabs(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"));
				
		//click Label va chon label -- Design
		click(By.xpath("//div[@id='s2id_autogen15']"));
		type(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"),AssertLabelValue);
		typeKeyTabs(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"));
		
		//click Status , kiem tra cac gia gia tri cua no da select hay chua, neu da select roi thi xoa di, va chon lai cai minh muon select
		click(By.xpath("//div/span/button[@type='button']"));

		click(By.xpath("//ul/li[text()='To do']"));// bo click toto
		click(By.xpath("//ul/li[text()='In progress']"));
		click(By.xpath("//ul/li[text()='Review']"));
		click(By.xpath("//ul/li[text()='Done']"));		//click Done
		
		Thread.sleep(3000);
		assertListstatus(AssertStatusValue);
		
	}
	
	@Test(priority = 5) //kiem tra theo status -nhieu status 1 luc
	public void filterByMultiStatus() throws InterruptedException{
		Pagelocator_Rise login = new Pagelocator_Rise(driver);
		login.LoginFunction(CT_Account_Rise.Email,CT_Account_Rise.Password );
		
		String AssertLabelValue ="Design";
		String AssignedTovalueFilter ="Sara Ann";
		String AssertStatusValue1 ="Done";
		String AssertStatusValue2 ="In progress";

		
		//click Task, click show filter +
		click(By.xpath("//span[text()='Tasks']"));
		click(By.xpath("//button[@class='btn btn-default show-filter-form-button']"));
				
		//click Team memmber , chon gia tri Sara Ann
		click(By.xpath("//div[@id='s2id_autogen11']"));
		type(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"),AssignedTovalueFilter);
		typeKeyTabs(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"));
				
		//click Label va chon label -- Design
		click(By.xpath("//div[@id='s2id_autogen15']"));
		type(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"),AssertLabelValue);
		typeKeyTabs(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"));
		
		//click Status , kiem tra cac gia gia tri cua no da select hay chua, neu da select roi thi xoa di, va chon lai cai minh muon select
		click(By.xpath("//div/span/button[@type='button']"));

		click(By.xpath("//ul/li[text()='To do']"));// bo click toto
		click(By.xpath("//ul/li[text()='Review']"));
		click(By.xpath("//ul/li[text()='Done']"));		//click Done
		
		Thread.sleep(3000);
		checkFilterStatus(AssertStatusValue1,AssertStatusValue2);
		
	}

	@Test(priority = 6) //Test filter ngay thang
	public void FilterDeadline() throws InterruptedException{
		Pagelocator_Rise login = new Pagelocator_Rise(driver);
		login.LoginFunction(CT_Account_Rise.Email,CT_Account_Rise.Password );
		
	}
	
	
	
	
	@AfterMethod
	public void CloseBrowser() {
		quitDriver(driver);
	}
	
}
