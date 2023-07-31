package com.billing.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.billing.pages.LoginPage;
import com.billing.pages.SupplierPage;
import com.billling.utilities.ElementUtil;
import com.billling.utilities.FakerUtility;

public class SupplierPageTest extends BaseTest {
	@Test


	public void verifySupplierPageAddFunctionality  () {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginPageUsingValidCredentials(ElementUtil.getPropertyValue("username"),ElementUtil.getPropertyValue("password"));
		SupplierPage supplierpage=new SupplierPage(driver);
		String msg=supplierpage.verifyAddSupplier("talia","k92","6779799","jaipur","rajasthan","india");
		Assert.assertEquals(msg,"Contact added successfully");
	}
	@Test
	public void verifySupplierPageSearchFunctionality()
	{ 
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginPageUsingValidCredentials(ElementUtil.getPropertyValue("username"),ElementUtil.getPropertyValue("password"));
		SupplierPage supplierpage=new SupplierPage(driver);
		String msg=supplierpage.verifySearchSupplier("talia");  
		Assert.assertEquals(msg,"talia");
	}
	@Test
	public void verifySupplierPageDeleteFunctionality()
	{ 
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginPageUsingValidCredentials(ElementUtil.getPropertyValue("username"),ElementUtil.getPropertyValue("password"));
		SupplierPage supplierpage=new SupplierPage(driver);
		String msg= supplierpage.verifySupplierSearchDelete();
		Assert.assertEquals(msg,"Contact deleted successfully");

	}
}
