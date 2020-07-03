package AutoFunction;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePages.HomePage;
import BasePages.Account;
import BasePages.NewAccountCreation;
import BasePages.AccountFormCreation;
import BasePages.SignInForm;

public class AccountCreation extends Home_PageNav
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
	public void authenticationPage() 
	{
		HomePage.clickSignin();

		Assert.assertTrue(NewAccountCreation.getAccountFormCreation().isDisplayed());
		Assert.assertTrue(NewAccountCreation.getCreatAccountEmailField().isDisplayed());
		Assert.assertTrue(NewAccountCreation.getCreateAccountBtn().isDisplayed());
		Assert.assertTrue(SignInForm.getSignInForm().isDisplayed());
	}

	@Test(priority = 2)
	public void authenticationPageEmailField() 
	{
		/* Without email*/
		NewAccountCreation.getCreateAccountBtn().click();

		Assert.assertTrue(NewAccountCreation.getEmailErrorMessage().isDisplayed());

		// Wrong email format 
		NewAccountCreation.setCreateAccountEmailField("abcde");
		NewAccountCreation.getCreateAccountBtn().click();

		Assert.assertTrue(NewAccountCreation.getEmailErrorMessage().isDisplayed());
		Assert.assertTrue(NewAccountCreation.getEmailFieldHighlightedRed().isDisplayed());

		// Registered email
		NewAccountCreation.setCreateAccountEmailField("abc@gmail.com");
		NewAccountCreation.getCreateAccountBtn().click();

		Assert.assertTrue(NewAccountCreation.getEmailBeenRegistered().isDisplayed());

		// Correct email
		NewAccountCreation.setCreateAccountEmailField("Arya.stark@gmail.com");
		NewAccountCreation.getCreateAccountBtn().click();

		Assert.assertTrue(AccountFormCreation.getAccountCreationForm().isDisplayed());
	}

	@Test(priority = 3)
	public void personalInfoFields() 
	{
		// With values
		AccountFormCreation.setCustomerFirstNameField("Arya");
		AccountFormCreation.setCustomerLastNameField("Stark");
		AccountFormCreation.setCustomerEmailField("arya.stark@gmail.com");
		AccountFormCreation.setCustomerPasswordField("tester");

		AccountFormCreation.getAccountCreationForm().click();

		Assert.assertTrue(AccountFormCreation.getFirstNameHighlightedGreen().isDisplayed());
		Assert.assertTrue(AccountFormCreation.getLastNameHighlightedGreen().isDisplayed());
		Assert.assertTrue(AccountFormCreation.getPasswordHighlightedGreen().isDisplayed());

		// Without values
		AccountFormCreation.setCustomerFirstNameField("");
		AccountFormCreation.setCustomerLastNameField("");
		AccountFormCreation.setCustomerEmailField("");
		AccountFormCreation.setCustomerPasswordField("");

		AccountFormCreation.getAccountCreationForm().click();
	}

	@Test(priority = 4)
	public void requiredFieldsEmpty() 
	{
		AccountFormCreation.getAddressAliasField().clear();
		AccountFormCreation.setCustomerEmailField("");
		AccountFormCreation.selectCountry("-");
		AccountFormCreation.getRegisterBtn().click();

		Assert.assertTrue(AccountFormCreation.getPhoneNumberError().isDisplayed());
		Assert.assertTrue(AccountFormCreation.getLastNameError().isDisplayed());
		Assert.assertTrue(AccountFormCreation.getFirstNameError().isDisplayed());
		Assert.assertTrue(AccountFormCreation.getEmailRequiredError().isDisplayed());
		Assert.assertTrue(AccountFormCreation.getPasswordRequiredError().isDisplayed());
		Assert.assertTrue(AccountFormCreation.getCountryRequiredError().isDisplayed());
		Assert.assertTrue(AccountFormCreation.getAddressRequiredError().isDisplayed());
		Assert.assertTrue(AccountFormCreation.getAddressAliasRequiredError().isDisplayed());
		Assert.assertTrue(AccountFormCreation.getCityRequiredError().isDisplayed());
		Assert.assertTrue(AccountFormCreation.getCountryUnselectedError().isDisplayed());

		AccountFormCreation.selectCountry("United States");
		AccountFormCreation.getRegisterBtn().click();

		Assert.assertTrue(AccountFormCreation.getStateRequredError().isDisplayed());
		Assert.assertTrue(AccountFormCreation.getPostalCodeError().isDisplayed());
	}

	@Test(priority = 5)
	public void requiredFieldsInputFormat() throws Exception {
		// Wrong format
		AccountFormCreation.setCustomerEmailField("Arya.stark@gmail.com");
		AccountFormCreation.setCustomerPasswordField("test");
		AccountFormCreation.setPostalCodeField("asd");
		AccountFormCreation.setHomePhoneField("asd");
		AccountFormCreation.setMobilePhoneField("asd");

		AccountFormCreation.getRegisterBtn().click();

		Assert.assertTrue(AccountFormCreation.getEmailInvalidError().isDisplayed());
		Assert.assertTrue(AccountFormCreation.getPasswordInvalidError().isDisplayed());
		Assert.assertTrue(AccountFormCreation.getPostalCodeError().isDisplayed());
		Assert.assertTrue(AccountFormCreation.getHomePhoneInvalidError().isDisplayed());
		Assert.assertTrue(AccountFormCreation.getMobilePhoneInvalidError().isDisplayed());

		// Correct format
		AccountFormCreation.setCustomerEmailField("email1@gmail.com");
		AccountFormCreation.setCustomerPasswordField("tester");
		AccountFormCreation.setPostalCodeField("21000");
		AccountFormCreation.setHomePhoneField("056");
		AccountFormCreation.setMobilePhoneField("065");

		Assert.assertTrue(AccountFormCreation.getEmailInvalidError().isDisplayed());
		Assert.assertTrue(AccountFormCreation.getPasswordInvalidError().isDisplayed());
		Assert.assertTrue(AccountFormCreation.getPostalCodeError().isDisplayed());
		Assert.assertTrue(AccountFormCreation.getHomePhoneInvalidError().isDisplayed());
		Assert.assertTrue(AccountFormCreation.getMobilePhoneInvalidError().isDisplayed());
	}

	@Test(priority = 6)
	public void createAccountSuccessfully() {
		// Required fields filled
		AccountFormCreation.setCustomerFirstNameField("John");
		AccountFormCreation.setCustomerLastNameField("Doe");
		AccountFormCreation.setCustomerPasswordField("tester123");
		AccountFormCreation.selectCustomerDateOfBirthDay("20");
		AccountFormCreation.selectCustomerDateOfBirthMonth("10");
		AccountFormCreation.selectCustomerDateOfBirthYear("2000");
		AccountFormCreation.setAddressField("Centar");
		AccountFormCreation.setCityField("Novi Sad");
		AccountFormCreation.selectState("7");
		AccountFormCreation.setPostalCodeField("21000");
		AccountFormCreation.setHomePhoneField("056");
		AccountFormCreation.setMobilePhoneField("066");
		AccountFormCreation.setAddressAliasField("My Address");
		AccountFormCreation.getRegisterBtn().click();

		Assert.assertTrue(AccountFormCreation.getEmailBeenRegistered().isDisplayed());

		AccountFormCreation.setCustomerPasswordField("tester123");
		AccountFormCreation.getRegisterBtn().click();

		Assert.assertTrue(AccountFormCreation.successfullyCreatedAccount().isDisplayed());
	}
}
