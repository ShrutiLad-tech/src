package BasePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoFunction.Home_PageNav;
import Util.Utils;

public class SignInForm extends Home_PageNav
{
	public static WebElement getSignInForm() 
	{
		return Utils.waitForElementPresence(driver, By.id("login_form"), 30);
	}
	
	public static WebElement getSignInEmailField() 
	{
		return Utils.waitForElementPresence(driver, By.id("email"), 30);
	}
	
	public static WebElement getSignInPasswordField() 
	{
		return Utils.waitForElementPresence(driver, By.id("passwd"), 30);
	}
	
	public static WebElement getSignInBtn() 
	{
		return Utils.waitForElementPresence(driver, By.id("SubmitLogin"), 30);
	}
	
	public static void setEmailField(String mail) 
	{
		WebElement email = SignInForm.getSignInEmailField();
		email.clear();
		email.sendKeys(mail);
	}
	
	public static void setPasswordField(String pass) 
	{
		WebElement password = SignInForm.getSignInPasswordField();
		password.clear();
		password.sendKeys(pass);
	}
	
	/****** ERRORS ******/
	public static WebElement getEmailRequiredError() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"An email address required.\")]"), 30);
	}
	
	public WebElement getEmailInvalidError() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Invalid email address.\")]"), 30);
	}
	
	public static WebElement getAuthenticationFailedError() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Authentication failed.\")]"), 30);
	}
	
	public static WebElement getPasswordRequiredError() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Password is required.\")]"), 30);
	}
	
	public WebElement getInvalidPasswordError() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Invalid password\")]"), 30);
	}
	
	/****** HIGHLIGHTED ERRORS ******/
	
	public static WebElement getEmailHighlightedRed() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"form-group form-error\"]//input[@id=\"email\"]"), 30);
	}
	
	public static WebElement getEmailHighlightedGreen() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"form-group form-ok\"]//input[@id=\"email\"]"), 30);
	}
}
