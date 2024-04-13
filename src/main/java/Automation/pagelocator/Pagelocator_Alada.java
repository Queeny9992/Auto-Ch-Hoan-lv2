package Automation.pagelocator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.Pagelocator;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.thread.ThreadExecutionException;
import Automation.common.CommonBase;




public class Pagelocator_Alada  extends CommonBase{
	
	private WebDriver driver;
	
		public Pagelocator_Alada(WebDriver _driver) {
		
		this.driver = _driver;
		PageFactory.initElements(driver, this);  
		//trong bản thân selenium, trong thư viện có sẵn 1  class có tên là PageFactory.class
		// lớp này thì bên trong có  thể accept các FindBy để mình có thể sử dụng được các findby ở dưới
	}
	



		// lập ra những xpath mà mình cần sử dụng ở dưới
		
	
		
	@FindBy(id="txtLoginUsername")
	WebElement TxtUsername;
	
	@FindBy(id="txtLoginPassword")
	WebElement TxtPass;
	
	@FindBy(xpath="//form[@id='frmLogin']//button[text()='ĐĂNG NHẬP']")
	WebElement BtnSubmit;
		
	@FindBy(xpath="//ul[@class='menu fright marbot0']//li[@id='showsub']")
	WebElement Avatar;
	
	@FindBy(xpath="//ul[@id='subulmenu']//p//a[text()='Chỉnh sửa thông tin']")
	WebElement BtnChangeInfor;
	
	private  By btn = By.xpath("//ul[@id='subulmenu']//p//a[text()='Chỉnh sửa thông tin']");
	
	@FindBy(xpath="//div//input[@name='fileupload']")
	WebElement BtnChangeAvatar;
	
	// tiếp theo sẽ thiết lập một hàm loginfunction với mục đích là hàm đăng nhập
	
	public void LoginFunction(String email, String pass) {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		TxtUsername.click();
		TxtUsername.sendKeys(email);
		TxtPass.click();
		TxtPass.sendKeys(pass);
		BtnSubmit.click();
			
		
	}
	
	
	public void ChangeInforAvatar(String img) {
		
		Avatar.click();
		
		clickJavaScript(btn);
		BtnChangeAvatar.click();
		BtnChangeAvatar.sendKeys(img);
		
	}
	
	
	
	
	
	
}
