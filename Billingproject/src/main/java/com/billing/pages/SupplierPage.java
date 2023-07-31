package com.billing.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.billling.utilities.ElementUtil;
import com.billling.utilities.WaitUtil;
public class SupplierPage {
	ElementUtil elementUtil;
	WaitUtil waitUtil;
	WebDriver driver;
	@FindBy(xpath="//button[text()='End tour']")
	WebElement endtourButton;
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement contactButton;
	@FindBy(xpath="//a[text()=' Suppliers']")
	WebElement suppliersField;
	@FindBy(xpath="//button[text()=' Add']")
	WebElement addProductsField;
	@FindBy(xpath="//select[@id='contact_type']")
	WebElement contactTypeField;
	@FindBy(xpath="//input[@name='name']")
	WebElement nameTextField;
	@FindBy(xpath="//input[@name='supplier_business_name']")
	WebElement buisnessNameTextField;
	@FindBy(xpath="//input[@name='mobile']")
	WebElement phoneNumberTextField;
	@FindBy(xpath="//input[@id='city']")
	WebElement cityTextField;
	@FindBy(xpath="//input[@id='state']")
	WebElement stateTextField;
	@FindBy(xpath="//input[@id='country']")
	WebElement countryTextField;
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButtonField;
	@FindBy(xpath="//input[@type='search']")
	WebElement searchButtonField;
	@FindBy(xpath="//table[@id='contact_table']//tbody//tr[1]//td[7]//button")
	WebElement actionsButtonField;
	@FindBy(xpath="//table[@id='contact_table']//tbody//tr[1]//li[3]//a")
	WebElement deleteButton;
	@FindBy(xpath="//button[text()='OK']")
	WebElement okButton;
	@FindBy(xpath="//*[contains(text(),'Contact deleted successfully')]")
	WebElement deleteMsg;
	@FindBy(xpath="//table[@id='contact_table']//tbody//tr[2]//td[3]")
	WebElement searchNameCheck;
	@FindBy(xpath="//*[contains(text(),'Contact added successfully')]")
	WebElement AddMsg;
	public SupplierPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);// StatinitElements methods of PageFactory class for initializing WebElements.
		elementUtil=new ElementUtil(driver);
		waitUtil=new WaitUtil(driver);
	}
	public String verifyAddSupplier(String name,String name1,String number,String city,String state,String country) {
		elementUtil.click(endtourButton);
		elementUtil.click(contactButton);
		waitUtil.waitForElementClick(suppliersField);
		elementUtil.click(suppliersField);
		waitUtil.waitForElementClick(addProductsField);
		elementUtil.click(addProductsField);
		waitUtil.waitForElementClick(contactTypeField);
		elementUtil.selectDropdown(contactTypeField, "visibletext","Suppliers");
		elementUtil.sendKeys(nameTextField,name);
		waitUtil.waitForElementClick(buisnessNameTextField);
		elementUtil.sendKeys(buisnessNameTextField, name1);
		elementUtil.sendKeys(phoneNumberTextField, number);
		elementUtil.sendKeys(cityTextField, city);
		elementUtil.sendKeys(stateTextField, state);
		elementUtil.sendKeys(countryTextField, country);
		elementUtil.click(saveButtonField);
		waitUtil.waitForElementvisibile(AddMsg);
		String msg=elementUtil.getText(AddMsg);
		System.out.println(msg);
		return msg;

	}
	public String verifySupplierSearchDelete() {
		elementUtil.click(endtourButton);
		elementUtil.click(contactButton);
		waitUtil.waitForElementClick(suppliersField);
		elementUtil.click(suppliersField);
		elementUtil.sendKeys(searchButtonField,"talia");
		waitUtil.waitForElementClick(actionsButtonField);
		elementUtil.click(actionsButtonField);
		waitUtil.waitForElementClick(deleteButton);
		elementUtil.click(deleteButton);
		elementUtil.click(okButton);
		waitUtil.waitForElementvisibile(deleteMsg);
		String msg=elementUtil.getText(deleteMsg);
		System.out.println(msg);
		return msg;

	}
	public String verifySearchSupplier(String name)
	{
		elementUtil.click(endtourButton);
		elementUtil.click(contactButton);
		waitUtil.waitForElementClick(suppliersField);
		elementUtil.click(suppliersField);
		waitUtil.waitForElementClick(searchButtonField);
		elementUtil.sendKeys(searchButtonField, name);
		waitUtil.waitForElementvisibile(searchNameCheck);
		String msg=elementUtil.getText(searchNameCheck);
		System.out.println(msg);
		return msg;
	}

}