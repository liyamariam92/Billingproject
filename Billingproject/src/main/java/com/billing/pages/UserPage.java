package com.billing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.billling.utilities.ElementUtil;
import com.billling.utilities.WaitUtil;

public class UserPage {
	ElementUtil elementUtil;
	WaitUtil waitUtil;
	WebDriver driver;
	@FindBy(xpath="//button[text()='End tour']")
	WebElement endtourButton;
	@FindBy(xpath="//span[text()='User Management']")
	WebElement userManagement;
	@FindBy(xpath="//span[contains(text(),'Users')]")
	WebElement userField;
	@FindBy(xpath="//a[text()=' Add']")
	WebElement addField;
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstNameTextField;
	@FindBy(xpath="//input[@id='email']")
	WebElement emailTextField;
	@FindBy(xpath="//span[@id='select2-role-container']")
	WebElement roleField;
	@FindBy(xpath="//ul[@id='select2-role-results']//li[2]")
	WebElement roleTypeField;
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordTextField;
	@FindBy(xpath="//input[@id='confirm_password']")
	WebElement confirmPasswordTextField;
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButtonField;
	@FindBy(xpath="//*[contains(text(),'User added successfully')]")
	WebElement AddMsg;
	@FindBy(xpath="//input[@type='search']")
	WebElement searchButtonField;
	@FindBy(xpath="//table[@id='users_table']//tbody//tr[1]//td[2]")
	WebElement searchNameCheck;
	@FindBy(xpath="//table[@id='users_table']//tbody//tr[7]//button[text()=' Delete']")
	WebElement rowDeleteButtonField;
	@FindBy(xpath="//button[text()='OK']")
	WebElement deleteButtonField;
	@FindBy(xpath="//*[contains(text(),'User deleted successfully')]")
	WebElement deleteMsg;
	public UserPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver,this);// StatinitElements methods of PageFactory class for initializing WebElements.
		elementUtil=new ElementUtil(driver);
		waitUtil=new WaitUtil(driver);

	}
	public String verifyUserManagement(String name,String email,String pass,String pass1) {
		elementUtil.click(endtourButton);
		elementUtil.click(userManagement);
		waitUtil.waitForElementClick(userField);
		elementUtil.click(userField);
		elementUtil.click(addField);
		elementUtil.click(userManagement);
		elementUtil.sendKeys(firstNameTextField,name);
		elementUtil.sendKeys(emailTextField, email);
		elementUtil.click(roleField);
		elementUtil.click(roleTypeField);
		elementUtil.sendKeys(passwordTextField, pass);
		elementUtil.sendKeys(confirmPasswordTextField,pass1);
		elementUtil.click(saveButtonField);
		waitUtil.waitForElementvisibile(AddMsg);
		String msg=elementUtil.getText(AddMsg);
		System.out.println(msg);
		return msg;
	}
	public String verifyUserDelete() {
		elementUtil.click(endtourButton);
		elementUtil.click(userManagement);
		waitUtil.waitForElementClick(userField);
		elementUtil.click(userField);
		waitUtil.waitForElementClick(rowDeleteButtonField);
		elementUtil.click(rowDeleteButtonField);
		elementUtil.click(deleteButtonField);
		waitUtil.waitForElementvisibile(deleteMsg);
		String msg=elementUtil.getText(deleteMsg);
		System.out.println(msg);
		return msg;
	}
	public String verifyUserSearch(String name)
	{
		elementUtil.click(endtourButton);
		elementUtil.click(userManagement);
		waitUtil.waitForElementClick(userField);
		elementUtil.click(userField);
		waitUtil.waitForElementClick(searchButtonField);
		elementUtil.sendKeys(searchButtonField, name);	
		waitUtil.waitForElementvisibile(searchNameCheck);
		String msg=elementUtil.getText(searchNameCheck);
		System.out.println(msg);
		return msg;
	
		// TODO Auto-generated method stub
		
	}

}
