package opusAutomationLoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//child::td/child::input[@type='text']")
	WebElement LoginUserName;
	
	@FindBy(name="password")
	WebElement LoginPassword;
	
	@FindBy(name="btnSubmit")
	WebElement LoginPageSubmitButton;
	
	@FindBy(xpath="//input[@type='button']")
	WebElement PasswordConfirmationSubmitButton;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void LoginToApplication(String Username,String Password)
	{
		LoginUserName.sendKeys(Username);
		LoginPassword.sendKeys(Password);
		LoginPageSubmitButton.click();
		PasswordConfirmationSubmitButton.click();
	}
	
	
	
	

}
