package BasePages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import AutoFunction.Home_PageNav;

public class HomePage extends Home_PageNav
{
	/*Verify SgnIn*/
	public static void clickSignin()
	{
		WebElement element = driver.findElement(By.xpath("//a[contains(text(), \"Sign in\")]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
	}	
}
