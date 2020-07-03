package BasePages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoFunction.Home_PageNav;
import Util.Utils;

public class Clothes extends Home_PageNav
{
	public WebElement getWomenBtn() 
	{
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]"), 30);
	}
	
	public static WebElement getDressesBtn() 
	{
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]"), 30);
	}
	
	public WebElement getTShirtsBtn() 
	{
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]"), 30);
	}
	
	public WebElement getDressesDropDown() 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul"), 30);
	}
	
	public static WebElement getCasualDressesBtn() 
	{
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Casual Dresses\")]"), 30);
	}
	
	public static WebElement getEveningDressesBtn() 
	{
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Evening Dresses\")]"), 30);
	}
	
	public static WebElement getSummerDressesBtn() 
	{
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Summer Dresses\")]"), 30);
	}
	
	public static WebElement getSummerDressProduct(int dressNum) 
	{
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"center_column\"]/ul/li[" + dressNum + "]"), 30);	
	}
	
	public static List<WebElement> getDressesCount() 
	{
		return driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));	
	}
}
