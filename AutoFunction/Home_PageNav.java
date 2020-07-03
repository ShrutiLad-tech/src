package AutoFunction;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Home_PageNav 
{
	public static WebDriver driver;
	
	public static void getURL() throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Auto_Assignment\\Jar Files\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}
}
