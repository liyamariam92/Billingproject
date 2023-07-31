package com.billing.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.billing.pages.LoginPage;
import com.billling.utilities.ElementUtil;
import com.billling.utilities.FakerUtility;
import com.billing.pages.UserPage;
public class UserPageTest extends BaseTest{
	@Test
	public void verifyUserAdd() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginPageUsingValidCredentials(ElementUtil.getPropertyValue("username"),ElementUtil.getPropertyValue("password"));
		UserPage userpage=new UserPage(driver);
		String msg=userpage.verifyUserManagement("talia",FakerUtility.emailID(),"691512","691512");
		Assert.assertEquals(msg,"User added successfully");
	}
	@Test
	public void verifyUserDelete() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginPageUsingValidCredentials(ElementUtil.getPropertyValue("username"),ElementUtil.getPropertyValue("password"));
		UserPage userpage=new UserPage(driver);
		String msg= userpage.verifyUserDelete();
		Assert.assertEquals(msg,"User deleted successfully");
		
	}
	@Test
	public void verifyUserSearch() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginPageUsingValidCredentials(ElementUtil.getPropertyValue("username"),ElementUtil.getPropertyValue("password"));
		UserPage userpage=new UserPage(driver);
		String msg=userpage.verifyUserSearch("talia"); 
		Assert.assertEquals(msg,"talia");
	}
}