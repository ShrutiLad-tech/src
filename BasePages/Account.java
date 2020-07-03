package BasePages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoFunction.Home_PageNav;
import Util.Utils;

public class Account extends Home_PageNav
{
	public static WebElement getAccountBtn() 
	{
		return Utils.waitToBeClickable(driver, By.xpath("//a[@title=\"View my customer account\"]"), 30);
	}
		
	public static WebElement getAccountLogout() 
	{
		return Utils.waitToBeClickable(driver, By.xpath("//a[@title=\"Log me out\"]"), 30);
	}
		
	public static WebElement getAccountOrderHistoryBtn() 
	{
		return Utils.waitToBeClickable(driver, By.xpath("//span[contains(text(), \"Order history and details\")]"), 30);
	}
		
	public static WebElement getAccountOrderListTable() 
	{
		return Utils.waitToBeClickable(driver, By.xpath("//table[@id=\"order-list\"]"), 30);
	}
		
	public static List<WebElement> getAccountOrdersLis() 
	{
		return driver.findElements(By.xpath("//table[@id=\"order-list\"]/tbody/tr"));
	}
}
