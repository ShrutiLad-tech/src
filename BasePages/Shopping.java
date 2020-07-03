package BasePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoFunction.Home_PageNav;
import Util.Utils;

public class Shopping extends Home_PageNav
{
	public static WebElement getAddToCartBtn() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"center_column\"]/ul/li//span[contains(text(), \"Add to cart\")]"), 30);
	}
	
	public WebElement getAddedToCartModal() {
		return Utils.waitForElementPresence(driver, By.id("layer_cart"), 30);
	}
	
	public static WebElement getContinueShopingBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//span[@title=\"Continue shopping\"]"), 30);
	}
	
	public WebElement getProceedToCheckoutBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//span[contains(text(), \"Proceed to checkout\")]"), 30);
	}
	
	public WebElement getSuccessfullyAddedMessage() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2"), 30);
	}
}
