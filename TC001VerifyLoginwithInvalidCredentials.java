package opusAutomationLoginPage;




//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;


import opusAutomationtestBase.testBase;

public class TC001VerifyLoginwithInvalidCredentials extends testBase {
	
	
	
	@BeforeTest
	public void setup()
	{
		
		//launchingfirefoxDriver();
		launchingIEDriver();
		driver.get(URL);
		
		
	}
	
	@Test
	public void verifyLoginwithInvalidCredentials()
	{
		
	}

	@AfterClass
	public void endTest()
	{
		//driver.close();
	}
}
