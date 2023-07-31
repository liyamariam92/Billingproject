package com.billing.tests;


import org.testng.annotations.Test;
import com.billing.pages.LoginPage;
import com.billling.utilities.ElementUtil;


public class LoginTest extends BaseTest {
	@Test(priority=1,groups= {"sanity"})
	public void verifyLoginUsingValidCredentials() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginPageUsingValidCredentials(ElementUtil.getPropertyValue("username"),ElementUtil.getPropertyValue("password"));
	}
	
}


