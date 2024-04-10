package Automation.constant;

import org.testng.annotations.DataProvider;

public class DataProviderRise {

	@DataProvider(name="data_Rise_Login")
	public Object[][] dataRise() {
		
		return new Object[][] {
			{"admin@demo.com","riseDemo","Admin"},
			{"admin@demo.com","riseDemo","Admin"},
			{"client@demo.com","riseDemo","Client"},
			{"client@demo.com","riseDemo","Client"},

	};
	
	}
	@DataProvider(name = "data_Rise_Fail_Login")
	public Object[][] dataRiseFail() {
		
		return new Object[][] {
			{"admink@demo.com","riseDemo","Admin"},
			{"admin@demo.com","kriseDemo","Admin"},
			{"clientk@demo.com","riseDemo","Client"},
			{"client@demo.com","kriseDemo","Client"},

	};
	
	}
	
	@DataProvider(name ="data_Rise_Input_Empty_Fail_Login")
	public Object [][] dataRiseInPutEmpty(){
		
		return new Object [][] {
			{" ", "riseDemo"," "},
			{" ", " "," "},
			{"admin@demo.com", " "," "},
			
	};
		
		
	}	
	
	
}
