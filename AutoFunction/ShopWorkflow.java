package AutoFunction;

import java.awt.Desktop.Action;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePages.HomePage;
import BasePages.Account;
import BasePages.Cart;
import BasePages.CartSummary;
import BasePages.Clothes;
import BasePages.Shopping;
import BasePages.SignInForm;

public class ShopWorkflow extends Home_PageNav
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
	public void selectChlotes() 
	{
		Assert.assertTrue(Clothes.getDressesBtn().isDisplayed());

		Assert.assertTrue(Clothes.getSummerDressesBtn().isDisplayed());
		Assert.assertTrue(Clothes.getCasualDressesBtn().isDisplayed());
		Assert.assertTrue(Clothes.getEveningDressesBtn().isDisplayed());

		Assert.assertTrue(Clothes.getSummerDressProduct(1).isDisplayed());
		Assert.assertTrue(Clothes.getSummerDressProduct(2).isDisplayed());
		Assert.assertTrue(Clothes.getSummerDressProduct(3).isDisplayed());
		Assert.assertEquals(Clothes.getDressesCount().size(), 3);

		Actions action = null;
		action.moveToElement(Clothes.getSummerDressProduct(1)).perform();
		action.moveToElement(Shopping.getAddToCartBtn()).perform();

		Assert.assertTrue(Shopping.getAddToCartBtn().isDisplayed());

		action.click(Shopping.getAddToCartBtn()).build().perform();
		action.click(Shopping.getContinueShopingBtn()).build().perform();

		Assert.assertTrue(Shopping.getContinueShopingBtn().isDisplayed());

		action.moveToElement(Cart.getCartTab()).perform();

		Assert.assertEquals(Cart.getCartProductsQty().size(), 1);

		// 2. dress
		action.moveToElement(Clothes.getDressesBtn()).perform();

		Assert.assertTrue(Clothes.getCasualDressesBtn().isDisplayed());

		action.moveToElement(Clothes.getCasualDressesBtn()).perform();
		Clothes.getCasualDressesBtn().click();
		action.moveToElement(Clothes.getSummerDressProduct(1)).perform();
		action.moveToElement(Shopping.getAddToCartBtn()).perform();
		action.click(Shopping.getAddToCartBtn()).build().perform();

		Assert.assertTrue(Shopping.getAddToCartBtn().isDisplayed());

		action.click(Shopping.getContinueShopingBtn()).build().perform();
		action.moveToElement(Cart.getCartTab()).perform();

		Assert.assertEquals(Cart.getCartProductsQty().size(), 2);

		// 3. dress
		action.moveToElement(Clothes.getDressesBtn()).perform();

		Assert.assertTrue(Clothes.getEveningDressesBtn().isDisplayed());

		action.moveToElement(Clothes.getEveningDressesBtn()).perform();
		Clothes.getEveningDressesBtn().click();
		action.moveToElement(Clothes.getSummerDressProduct(1)).perform();
		action.moveToElement(Shopping.getAddToCartBtn()).perform();
		action.click(Shopping.getAddToCartBtn()).build().perform();

		Assert.assertTrue(Shopping.getAddToCartBtn().isDisplayed());

		action.click(Shopping.getContinueShopingBtn()).build().perform();
		action.moveToElement(Cart.getCartTab()).perform();

		Assert.assertEquals(Cart.getCartProductsQty().size(), 3);
	}

	@Test(priority = 3)
	public void deleteCartProducts() {
		Assert.assertEquals(Cart.getCartProductsQty().size(), 3);

		Actions action = null;
		action.moveToElement(Cart.getCartTab()).perform();
		action.moveToElement(Cart.getCartProductDeleteX(2)).perform();
		action.click(Cart.getCartProductDeleteX(2)).build().perform();
		action.moveToElement(Clothes.getDressesBtn()).perform();
		action.moveToElement(Clothes.getEveningDressesBtn()).perform();
		Clothes.getEveningDressesBtn().click();
		action.moveToElement(Cart.getCartTab()).perform();

		Assert.assertEquals(Cart.getCartProductsQty().size(), 2);
	}

	@Test(priority = 4)
	public void checkingCartProductsQtyAndPrice() {
		Assert.assertEquals(Cart.getCartProductsQty().size(), 2);

		Actions action = null;
		action.moveToElement(Clothes.getDressesBtn()).perform();
		action.moveToElement(Clothes.getEveningDressesBtn()).perform();
		action.moveToElement(Clothes.getSummerDressProduct(1)).perform();
		action.moveToElement(Shopping.getAddToCartBtn()).perform();
		action.click(Shopping.getAddToCartBtn()).build().perform();
		action.click(Shopping.getContinueShopingBtn()).build().perform();

		action.moveToElement(Cart.getCartTab()).perform();
		action.moveToElement(Cart.getCartProductsQty(1)).perform();

		Assert.assertEquals(Cart.getCartProductsQty(1).getText(), "1");

		action.moveToElement(Cart.getCartProductsQty(2)).perform();

		Assert.assertEquals(Cart.getCartProductsQty(2).getText(), "2");

		action.moveToElement(Cart.getCartShipingCost()).perform();

		Assert.assertEquals(Cart.getCartShipingCost().getText(), "$2.00");

		action.moveToElement(Cart.getCartTotalPrice()).perform();

		Assert.assertEquals(Cart.getCartTotalPrice().getText(), "$132.96");
	}

	@Test(priority = 5)
	public void continueToShoppingSummary() {
		Actions action = null;
		action.moveToElement(Cart.getCartTab()).perform();
		action.moveToElement(Cart.getCartTabCheckOutBtn()).perform();

		Assert.assertTrue(Cart.getCartTabCheckOutBtn().isDisplayed());

		action.click(Cart.getCartTabCheckOutBtn()).build().perform();
	}

	@Test(priority = 6)
	public void checkIsOrderVisibleInOrderHistorySection() {
		Account.getAccountBtn().click();

		Assert.assertTrue(Account.getAccountOrderHistoryBtn().isDisplayed());

		Account.getAccountOrderHistoryBtn().click();

		Assert.assertTrue(Account.getAccountOrderListTable().isDisplayed());

		Account.getAccountBtn().click();
		Account.getAccountOrderHistoryBtn().click();

		Assert.assertEquals(Account.getAccountOrdersLis().size(), 1);
	}
}
