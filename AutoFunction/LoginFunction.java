package AutoFunction;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePages.Account;
import BasePages.HomePage;
import BasePages.SignInForm;

public class LoginFunction extends Home_PageNav
{
	@BeforeClass
	public void setup() throws IOException 
	{
		Home_PageNav.getURL();
		HomePage.clickSignin();
	}

	@AfterClass
	public void closeAll() 
	{
		Account.getAccountLogout().click();
		driver.quit();
	}

	@Test(priority = 1)
	public void loginPage() 
	{
		Assert.assertTrue(SignInForm.getSignInForm().isDisplayed());
		Assert.assertTrue(SignInForm.getSignInEmailField().isDisplayed());
		Assert.assertTrue(SignInForm.getSignInPasswordField().isDisplayed());
		Assert.assertTrue(SignInForm.getSignInBtn().isEnabled());
	}
//
//	@Test(priority = 2)
//	public void invalidCredentials() 
//	{
//		SignInForm.setEmailField("neki@email.com");
//		SignInForm.setPasswordField("sifra");
//		SignInForm.getSignInBtn().click();
//
//		Assert.assertTrue(SignInForm.getAuthenticationFailedError().isDisplayed());
//
//		SignInForm.setEmailField("email@email.email");
//		SignInForm.setPasswordField("sifra");
//		SignInForm.getSignInBtn().click();
//
//		Assert.assertTrue(SignInForm.getAuthenticationFailedError().isDisplayed());
//
//		SignInForm.setEmailField("mapkoct@gmail.com");
//		SignInForm.setPasswordField("asddsa");
//		SignInForm.getSignInBtn().click();
//
//		Assert.assertTrue(SignInForm.getAuthenticationFailedError().isDisplayed());
//
//	}
//
//	@Test(priority = 3)
//	public void loginWithoutCredentials() {
//		SignInForm.setEmailField("");
//		SignInForm.setPasswordField("asddsa");
//		SignInForm.getSignInBtn().click();
//
//		Assert.assertTrue(SignInForm.getEmailRequiredError().isDisplayed());
//
//		SignInForm.setEmailField("mapkoct@gmail.com");
//		SignInForm.setPasswordField("");
//		SignInForm.getSignInBtn().click();
//
//		Assert.assertTrue(SignInForm.getPasswordRequiredError().isDisplayed());
//
//		SignInForm.setEmailField("");
//		SignInForm.setPasswordField("");
//		SignInForm.getSignInBtn().click();
//
//		Assert.assertTrue(SignInForm.getEmailRequiredError().isDisplayed());
//	}
//
//	@Test(priority = 4)
//	public void emailFormat() 
//	{
//		SignInForm.setEmailField("email");
//		SignInForm.getSignInPasswordField().click();
//
//		Assert.assertTrue(SignInForm.getEmailHighlightedRed().isDisplayed());
//
//		SignInForm.setEmailField("email@email");
//		SignInForm.getSignInPasswordField().click();
//
//		Assert.assertTrue(SignInForm.getEmailHighlightedRed().isDisplayed());
//
//		SignInForm.setEmailField("email@email.email");
//		SignInForm.getSignInPasswordField().click();
//
//		Assert.assertTrue(SignInForm.getEmailHighlightedGreen().isDisplayed());
//	}
//
//	@Test(priority = 5)
//	public void successfulLogin() 
//	{
//		SignInForm.setPasswordField("tester123");
//		SignInForm.getSignInBtn().click();
//	}

}
