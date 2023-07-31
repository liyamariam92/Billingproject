package com.billing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.billling.utilities.ElementUtil;
import com.billling.utilities.WaitUtil;


public class LoginPage {
	ElementUtil elementUtil;
	WaitUtil waitUtil;
	WebDriver driver;
	@FindBy(name="username")
	WebElement userNameTextField;
	@FindBy(name="password")
	WebElement passwordTextField;
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginField;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);// StatinitElements methods of PageFactory class for initializing WebElements.
		elementUtil=new ElementUtil(driver);
		waitUtil=new WaitUtil(driver);  

	}
	public void loginPageUsingValidCredentials(String username, String password)
	{
		elementUtil.sendKeys(userNameTextField,username);
		elementUtil.sendKeys(passwordTextField,password);
		elementUtil.click(loginField);
	}
}
