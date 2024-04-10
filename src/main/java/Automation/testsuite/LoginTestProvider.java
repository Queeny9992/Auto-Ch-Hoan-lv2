package Automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.sql.Driver;
import Automation.constant.DataProviderRise;
import Automation.pagelocator.LoginPageFactory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Automation.common.CommonBase;
import Automation.constant.CT_Account;

public class LoginTestProvider extends CommonBase {
	
	@BeforeMethod
	public void OpenChrome() throws InterruptedException
	{
		driver = initChromeDriver(CT_Account.webURL);
	}
	
	
	
	@Test(dataProvider = "data_Rise_Login", dataProviderClass = DataProviderRise.class)
	public void loginSuccess(String username, String password, String role)
	{
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction1(username, password, role);
		assertTrue(isElementPresent(CT_Account.MAIN_PAGE));
		System.out.println("login successfully  with role is " + role);
		
	}
	
	
	@Test(dataProvider = "data_Rise_Fail_Login", dataProviderClass = DataProviderRise.class)
	public void loginFail(String username, String password, String role) {
		
		LoginPageFactory loginFailed = new LoginPageFactory(driver);
		loginFailed.LoginFunction1(username, password, "");
		assertTrue(isElementPresent(CT_Account.LOGIN_FAIL));
		System.out.println("login failed done test ");
	}
	
	
	@Test(dataProvider = "data_Rise_Input_Empty_Fail_Login", dataProviderClass = DataProviderRise.class)
	public void loginFailInputEmpty( String username, String password, String role ) {
		
		LoginPageFactory LoginFailInPutEmpty = new LoginPageFactory(driver);
		LoginFailInPutEmpty.LoginFunction1(username, password, "");
		assertTrue(isElementPresent(CT_Account.LOGIN_FAIL));
		System.out.println("login failed done test for empty input");
		
		
	}
	@AfterMethod
	public void closeBrowser() {
		quitDriver(driver);
	}
	
	}

