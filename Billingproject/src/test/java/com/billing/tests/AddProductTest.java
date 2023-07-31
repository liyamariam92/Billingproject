package com.billing.tests;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.billing.constants.Constants;
import com.billing.pages.AddProductPage;
import com.billing.pages.LoginPage;
import com.billling.utilities.ExcelRead;


public class AddProductTest extends BaseTest{
	@Test(dataProvider="userData",priority=1,groups= {"sanity","regression"},retryAnalyzer = generaltests.Retry.class)
	public void verifyAddProductPage(String name,String alert,String extax,String intax) {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginPageUsingValidCredentials("admin","123123");
		AddProductPage addproductpage=new AddProductPage(driver);
		String msg=addproductpage.verifyAddProduct(name,alert,extax,intax);
		Assert.assertEquals(msg, "Product added successfully");
	}
	@Test
	public void verifyAddProductSearch() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginPageUsingValidCredentials("admin","123123");
		AddProductPage addproductpage=new AddProductPage(driver);
		String msg=addproductpage.verifyProductSearch("milk");
		Assert.assertEquals(msg,"milk");
	}
	@Test
	public void verifyProductDeletion() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginPageUsingValidCredentials("admin","123123");
		AddProductPage addproductpage=new AddProductPage(driver);
		String msg=addproductpage.verifyDeleteProduct();
		Assert.assertEquals(msg,"Product deleted successfully");

	}
	@DataProvider()
	public Object[] [] userData() throws InvalidFormatException, IOException {
		Object[] [] data=ExcelRead.getDataFromExcel(Constants.testData,"Sheet1");
		return data;
	}
}
