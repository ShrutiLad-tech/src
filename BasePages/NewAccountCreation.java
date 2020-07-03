package BasePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoFunction.Home_PageNav;
import Util.Utils;

public class NewAccountCreation extends Home_PageNav
{
	public static WebElement getCreateAccountForm() 
	{
		return Utils.waitForElementPresence(driver, By.id("create-account_form"), 30);
	}
	
	public static WebElement getCreatAccountEmailField() 
	{
		return Utils.waitForElementPresence(driver, By.id("email_create"), 30);
	}
	
	public static WebElement getCreateAccountBtn() 
	{
		return Utils.waitToBeClickable(driver, By.xpath("//button[@id=\"SubmitCreate\"]"), 30);
	}
	
	public static void setCreateAccountEmailField(String email) 
	{
		WebElement element = NewAccountCreation.getCreatAccountEmailField();
		element.clear();
		element.sendKeys(email);
	}
	
	/****** ERRORS ******/
	public static WebElement getEmailFieldHighlightedRed() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"form-group form-error\"]"), 30);
	}
	
	public WebElement getEmailFieldHighlightedGreen() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"form-group form-ok\"]"), 30);
	}
	
	public static WebElement getEmailErrorMessage() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Invalid email address.\")]"), 30);
	}
	
	public static WebElement getEmailBeenRegistered() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"An account using this email\")]"), 30);
	}

	public static WebElement getAccountFormCreation() 
	{
		return null;
	}
}