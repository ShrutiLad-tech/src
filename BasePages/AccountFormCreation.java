package BasePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import AutoFunction.Home_PageNav;
import Util.Utils;

public class AccountFormCreation extends Home_PageNav
{
	public static WebElement getAccountCreationForm() 
	{
		return Utils.waitForElementPresence(driver, By.id("account-creation_form"), 30);
	}
	
	public WebElement getCustomerTitleMr() 
	{
		return Utils.waitToBeClickable(driver, By.id("uniform-id_gender1"), 30);
	}
	
	public WebElement getCustomerTitleMrs() 
	{
		return Utils.waitToBeClickable(driver, By.id("uniform-id_gender2"), 30);
	}
	
	public static WebElement getCustomerFirstNameField() 
	{
		return Utils.waitForElementPresence(driver, By.id("customer_firstname"), 30);
	}
	
	public static WebElement getCustomerLastNameField() 
	{
		return Utils.waitForElementPresence(driver, By.id("customer_lastname"), 30);
	}
	
	public static WebElement getCustomerEmailField()
	{
		return Utils.waitForElementPresence(driver, By.id("email"), 30);
	}
	
	public static WebElement getCustomerPasswordField() 
	{
		return Utils.waitForElementPresence(driver, By.id("passwd"), 30);
	}
	
	public static Select selectCustomerDateOfBirthDay()
	{
		WebElement dayOfBirth = Utils.waitForElementPresence(driver, By.id("days"), 30);
		return new Select(dayOfBirth);
	}
	
	public static Select selectCustomerDateOfBirthMonth() 
	{
		WebElement monthOfBirth = Utils.waitForElementPresence(driver, By.id("months"), 30);
		return new Select(monthOfBirth);
	}
	
	public static Select selectCustomerDateOfBirthYear() 
	{
		WebElement yearOfBirth = Utils.waitForElementPresence(driver, By.id("years"), 30);
		return new Select(yearOfBirth);
	}
	
	public WebElement getFirstNameField() 
	{
		return Utils.waitForElementPresence(driver, By.id("firstname"), 30);
	}
	
	public WebElement getLastNameField() 
	{
		return Utils.waitForElementPresence(driver, By.id("lastname"), 30);
	}
	
	public WebElement getCompanyField() 
	{
		return Utils.waitForElementPresence(driver, By.id("company"), 30);
	}
	
	public static WebElement getAddressField() 
	{
		return Utils.waitForElementPresence(driver, By.id("address1"), 30);
	}
	
	public WebElement getAddressFieldTwo() 
	{
		return Utils.waitForElementPresence(driver, By.name("address2"), 30);
	}
	
	public static WebElement getCity() 
	{
		return Utils.waitForElementPresence(driver, By.id("city"), 30);
	}
	
	public static Select selectCountry() 
	{
		WebElement country = Utils.waitForElementPresence(driver, By.id("id_country"), 30);
		return new Select(country);
	}
	
	public static Select selectState() 
	{
		WebElement state = Utils.waitForElementPresence(driver, By.id("id_state"), 30);
		return new Select(state);
	}
	
	public static WebElement getPostalCodeField() 
	{
		return Utils.waitForElementPresence(driver, By.id("postcode"), 30);
	}
	
	public WebElement getAdditionalInformationField()
	{
		return Utils.waitForElementPresence(driver, By.id("other"), 30);
	}
	
	public static WebElement getHomePhoneField() 
	{
		return Utils.waitForElementPresence(driver, By.id("phone"), 30);
	}
	
	public static WebElement getMobilePhoneField() 
	{
		return Utils.waitForElementPresence(driver, By.id("phone_mobile"), 30);
	}
	
	public static WebElement getAddressAliasField() 
	{
		return Utils.waitForElementPresence(driver, By.id("alias"), 30);
	}
	
	public static WebElement getRegisterBtn() 
	{
		return Utils.waitToBeClickable(driver, By.id("submitAccount"), 30);
	}
	
	public static WebElement successfullyCreatedAccount()
	{
		return Utils.waitForElementPresence(driver, By.xpath("//p[contains(text(), \"Welcome to your account.\")]"), 30);
	}
	
	/**** SETTERS ****/
	
	public void setCustomerTitleMr() 
	{
		this.getCustomerTitleMr().click();
	}
	
	public void setCustomerTitleMrs() 
	{
		this.getCustomerTitleMrs().click();
	}
	
	public static WebElement setCustomerFirstNameField(String firstName) 
	
	{
		WebElement customerFirstNameField = getCustomerFirstNameField();
		customerFirstNameField.clear();
		customerFirstNameField.sendKeys(firstName);
		return customerFirstNameField;
	}
	
	public static WebElement setCustomerLastNameField(String lastName)
	{
		WebElement customerLastNameField = getCustomerLastNameField();
		customerLastNameField.clear();
		customerLastNameField.sendKeys(lastName);
		return customerLastNameField;
	}
	
	public static WebElement setCustomerEmailField(String email)
	{
		WebElement customerEmailField = getCustomerEmailField();
		customerEmailField.clear();
		customerEmailField.sendKeys(email);
		return customerEmailField;
	}
	
	public static void setCustomerPasswordField(String password) 
	{
		WebElement customerPasswordField = getCustomerPasswordField();
		customerPasswordField.clear();
		customerPasswordField.sendKeys(password);
	}
	
	public static void selectCustomerDateOfBirthDay(String day)
	{
		Select dayOfBirth = selectCustomerDateOfBirthDay();
		dayOfBirth.selectByValue(day);
	}
	
	public static void selectCustomerDateOfBirthMonth(String month)
	{
		Select monthOfBirth = selectCustomerDateOfBirthMonth();
		monthOfBirth.selectByValue(month);
	}
	
	public static void selectCustomerDateOfBirthYear(String year) 
	{
		Select yearOfBirth = selectCustomerDateOfBirthYear();
		yearOfBirth.selectByValue(year);
	}
	
	public void setCompanyField(String company) 
	{
		WebElement companyField = this.getCompanyField();
		companyField.clear();
		companyField.sendKeys(company);
	}
	
	public static void setAddressField(String address) 
	{
		WebElement addressField = getAddressField();
		addressField.clear();
		addressField.sendKeys(address);
	}
	
	public void setAddressFieldTwo(String addresTwo) 
	{
		WebElement addresField = this.getAddressFieldTwo();
		addresField.clear();
		addresField.sendKeys(addresTwo);
	}
	
	public static void setCityField(String city) 
	{
		WebElement cityField = getCity();
		cityField.clear();
		cityField.sendKeys(city);
	}
	
	public static void selectState(String state) 
	{
		Select selectState = selectState();
		selectState.selectByValue(state);
	}
	
	public static void setPostalCodeField(String zip)
	{
		WebElement postalCode = getPostalCodeField();
		postalCode.clear();
		postalCode.sendKeys(zip);
	}
	
	public static void selectCountry(String country) 
	{
		Select selectCountry = selectCountry();
		selectCountry.selectByVisibleText(country);
	}
	
	public void setAdditionalInfo(String info) 
	{
		WebElement additionalInfo = this.getAdditionalInformationField();
		additionalInfo.clear();
		additionalInfo.sendKeys(info);
	}
	
	public static void setHomePhoneField(String phone) 
	{
		WebElement homePhone = getHomePhoneField();
		homePhone.clear();
		homePhone.sendKeys(phone);
	}
	
	public static void setMobilePhoneField(String phone) 
	{
		WebElement mobilePhone = getMobilePhoneField();
		mobilePhone.clear();
		mobilePhone.sendKeys(phone);
	}
	
	public static void setAddressAliasField(String alias) 
	{
		WebElement addressAlias = getAddressAliasField();
		addressAlias.clear();
		addressAlias.sendKeys(alias);
	}
	
	/*Errors*/
	public WebElement getErrorPanel() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"You must register\")]/../.."), 30);
	}
	
	public static WebElement getPhoneNumberError() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"You must register at least one phone number.\")]"), 30);
	}
	
	public static WebElement getHomePhoneInvalidError() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"phone\")]"), 30);
	}
	
	public static WebElement getMobilePhoneInvalidError() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"phone_mobile\")]"), 30);
	}
	
	public static WebElement getLastNameError() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//b[contains(text(), \"lastname\")]"), 30);
	}
	
	public WebElement getLastNameInvalidError() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"lastname\")]"), 30);
	}
	
	public static WebElement getFirstNameError() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//b[contains(text(), \"firstname\")]"), 30);
	}
	
	public WebElement getFirstNameInvalidError() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"firstname\")]"), 30);
	}
	
	public static WebElement getEmailRequiredError() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//b[contains(text(), \"lastname\")]"), 30);
	}
	
	public static WebElement getEmailInvalidError() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"email\")]"), 30);
	}
	
	public static WebElement getEmailBeenRegistered() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"An account using this\")]"), 30);
	}
	
	public static WebElement getPasswordRequiredError() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//b[contains(text(), \"passwd\")]"), 30);
	}
	
	public static WebElement getPasswordInvalidError() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"passwd\")]"), 30);
	}
	
	public static WebElement getCountryRequiredError() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//b[contains(text(), \"id_country\")]"), 30);
	}
	
	public static WebElement getAddressAliasRequiredError() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//b[contains(text(), \"alias\")]"), 30);
	}
	
	public static WebElement getAddressRequiredError() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//b[contains(text(), \"address1\")]"), 30);
	}
	
	public static WebElement getCityRequiredError() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//b[contains(text(), \"city\")]"), 30);
	}
	
	public static WebElement getCountryUnselectedError() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Country is invalid\")]"), 30);
	}
	
	public static WebElement getStateRequredError() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"This country requires you to choose a State.\")]"), 30);
	}
	
	public static WebElement getPostalCodeError() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"The Zip/Postal code you\")]"), 30);
	}
	
	
	/****** HIGHLIGHTED ERRORS ******/
	public static WebElement getFirstNameHighlightedGreen() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"required form-group form-ok\"]//input[@id=\"customer_firstname\"]"), 30);
	}
	
	public WebElement getFirstNameHighlightedRed() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"required form-group form-error\"]//input[@id=\"customer_firstname\"]"), 30);
	}
	
	public static WebElement getLastNameHighlightedGreen() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"required form-group form-ok\"]//input[@id=\"customer_lastname\"]"), 30);
	}
	
	public WebElement getLastNameHighlightedRed() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"required form-group form-error\"]//input[@id=\"customer_lastname\"]"), 30);
	}
	
	public WebElement getEmailHighlightedGreen() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"required form-group form-ok\"]//input[@id=\"email\"]"), 30);
	}
	
	public WebElement getEmailHighlightedRed() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"required form-group form-error\"]//input[@id=\"email\"]"), 30);
	}
	
	public static WebElement getPasswordHighlightedGreen() 
	
	{
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"required password form-group form-ok\"]//input[@id=\"passwd\"]"), 30);
	}
	
	public WebElement getPasswordHighlightedRed() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"required password form-group form-error\"]//input[@id=\"passwd\"]"), 30);
	}
	
}
