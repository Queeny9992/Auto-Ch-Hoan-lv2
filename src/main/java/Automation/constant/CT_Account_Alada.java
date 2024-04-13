package Automation.constant;

import org.openqa.selenium.By;

public class CT_Account_Alada {

		public static By TextBox_Email = By.id("txtLoginUsername");
		public static By TextBox_Pass = By.id("txtLoginPassword");
		public static By Btn_Login = By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG NHẬP']");
		public static By Main_Page = By.xpath("//li[@id='cate-default']//span[text()='NỔI BẬT']");
		
		
		public static String Web_URL = "https://alada.vn/tai-khoan/dang-nhap.html";
		public static String Email = "Caoson402@gmail.com";
		public static String Password ="Caoson1!";
		public static String NewPassword="";
		
}
