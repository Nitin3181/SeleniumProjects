package opusAutomationFanInfoPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FanInfoPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='fan']")
	WebElement FANid;
	
	@FindBy(xpath="//input[@id='btnShowCompanyInfo']")
	WebElement ShowCompanyInfoButton;
	
	@FindBy(xpath="//span[@id='withFanButton']/input[2]")
	WebElement NextButtononFANInfoPage;
	
	
	
	public FanInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void EnterFanDetails(String FAN)
	{
		FANid.sendKeys(FAN);
		ShowCompanyInfoButton.click();
		NextButtononFANInfoPage.click();
		
	}

}
