package com.SwagLabs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SwagLab_POM.LoginTest_POM;

@Listeners(com.SwagLab_Utils.Listerners.class)
public class loginTest extends Base {


	@Test(dataProvider = "loginTestDataProvider", dataProviderClass = DataProviderClass.class)
	public void loginTestWithValidCredentials(String userName, String password){
		
		LoginTest_POM logintest_pom = new LoginTest_POM(driver);
		try {
		logintest_pom.userName(userName);
		
		logintest_pom.password(password);
		
		logintest_pom.loginButton();}
		catch(Exception e){
			System.out.println("Test Case Failed due to "+e.getMessage());
			Assert.fail("loginTestWithValidCredentials failed");
		}
		
	}
}
