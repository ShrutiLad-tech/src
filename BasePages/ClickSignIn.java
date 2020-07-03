package BasePages;

import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import AutoFunction.Home_PageNav;

public class ClickSignIn
{
	@BeforeTest
	public void LounchURL() throws IOException 
	{
		Home_PageNav.getURL();
	}

	@Test
	public void clickSignIn() throws InterruptedException, IOException 
	{
		HomePage.clickSignin();
	}
}
