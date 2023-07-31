package com.billing.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.billling.utilities.ElementUtil;
import com.billling.utilities.WaitUtil;


public class AddProductPage {
	ElementUtil elementUtil;
	WaitUtil waitUtil;
	WebDriver driver;
	@FindBy(xpath="//button[text()='End tour']")
	WebElement endtourButton;
	@FindBy(xpath="//span[text()='Products']")
	WebElement productsTextField;
	@FindBy(xpath="//a[text()='List Products']")
	WebElement listProductsTextField;
	@FindBy(xpath="//a[text()='Add Product']")
	WebElement addProductsTextField;
	@FindBy(xpath="//input[@id='name']")
	WebElement nameTextField;
	@FindBy(xpath="//span[@id='select2-brand_id-container']")
	WebElement brandTextField;
	@FindBy(xpath="//ul[@id='select2-brand_id-results']//li[3]")
	WebElement brandTypeTextField;
	@FindBy(xpath="//span[@id='select2-unit_id-container']")
	WebElement unitTextField;
	@FindBy(xpath="//ul[@id='select2-unit_id-results']//li[15]")
	WebElement unitBrandTextField;
	@FindBy(xpath="//span[@id='select2-barcode_type-container']")
	WebElement barcodeTextField;
	@FindBy(xpath="//ul[@id='select2-barcode_type-results']//li[3]")
	WebElement barcodeTypeTextField;
	@FindBy(xpath="//input[@id='alert_quantity']")
	WebElement alertTextField;
	@FindBy(xpath="//span[@id='select2-tax_type-container']")
	WebElement sellingTextField;
	@FindBy(xpath="//ul[@id='select2-tax_type-results']//li[2]")
	WebElement sellingpriceTextField;
	@FindBy(xpath="//span[@id='select2-type-container']")
	WebElement productTypeTextField;
	@FindBy(xpath="//ul[@id='select2-type-results']//li[1]")
	WebElement productTextField;
	@FindBy(xpath="//input[@id='single_dpp']")
	WebElement excludingTaxTextField;
	@FindBy(xpath="//input[@id='single_dpp_inc_tax']")
	WebElement includingTaxTextField;
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveTextField;
	@FindBy(xpath="//*[contains(text(),'Product added successfully')]")
	WebElement AddMsg;
	@FindBy(xpath="//input[@type='search']")
	WebElement searchTextField;
	@FindBy(xpath="//table[@id='product_table']//tbody//tr[1]//td[3]")
	WebElement searchProductCheck;
	@FindBy(xpath="//table[@id='product_table']//tbody//tr[10]//td[12]")
	WebElement deleteProductRow;
	@FindBy(xpath="//table[@id='product_table']//tbody//tr[10]//li[4]//a")
	WebElement deleteButton;
	@FindBy(xpath="//button[text()='OK']")
	WebElement okButton;
	@FindBy(xpath="//*[contains(text(),'Product deleted successfully')]")
	WebElement deleteMsg;
	
	public AddProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);// StatinitElements methods of PageFactory class for initializing WebElements.
		elementUtil=new ElementUtil(driver);
		waitUtil=new WaitUtil(driver);
	}

	public String verifyAddProduct(String name,String alert,String extax,String intax) {
		elementUtil.click(endtourButton);
		waitUtil.waitForElementClick(productsTextField);
		elementUtil.click(productsTextField);
		waitUtil.waitForElementClick(addProductsTextField);
		elementUtil.click(addProductsTextField);
		elementUtil.sendKeys(nameTextField, name);
		elementUtil.click( brandTextField);
		elementUtil.click( brandTypeTextField);
		elementUtil.click( unitTextField);
		elementUtil.click( unitBrandTextField);
		elementUtil.click( barcodeTextField);
		elementUtil.click(  barcodeTypeTextField);
		elementUtil.sendKeys(  alertTextField,alert);
		elementUtil.scrollIntoView(sellingTextField);
		elementUtil.click(sellingTextField);
		elementUtil.click(   sellingpriceTextField);
		elementUtil.click(productTypeTextField);
		elementUtil.click(productTextField);
		elementUtil.sendKeys(excludingTaxTextField, extax);
		elementUtil.sendKeys(includingTaxTextField, intax);
		elementUtil.click(saveTextField);
		waitUtil.waitForElementvisibile(AddMsg);
		String msg=elementUtil.getText(AddMsg);
		System.out.println(msg);
		return msg;

	}
	public String verifyProductSearch(String name) {
		elementUtil.click(endtourButton);
		waitUtil.waitForElementClick(productsTextField);
		elementUtil.click(productsTextField);
		elementUtil.click(listProductsTextField);
		elementUtil.sendKeys(searchTextField,name);
		waitUtil.waitForElementvisibile(searchProductCheck);
		String msg=elementUtil.getText(searchProductCheck);
		System.out.println(msg);
		return msg;
	}
	public String verifyDeleteProduct() {
		elementUtil.click(endtourButton);
		waitUtil.waitForElementClick(productsTextField);
		elementUtil.click(productsTextField);
		elementUtil.click(listProductsTextField);
		waitUtil.waitForElementClick(deleteProductRow);
		elementUtil.click(deleteProductRow);
		waitUtil.waitForElementClick(deleteButton);
		elementUtil.click(deleteButton);
		elementUtil.click(okButton);
		waitUtil.waitForElementvisibile(deleteMsg);
		String msg=elementUtil.getText(deleteMsg);
		System.out.println(msg);
		return msg;
	}
}
