package opusAutomationCustomerInfoPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInfoPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='taxExemptFlag' and @value='N']")
	WebElement TaxExemptNoButton;
	
	@FindBy(xpath="//input[@name='taxId']")
	WebElement TaxID;
	
	@FindBy(id="firstName")
	List<WebElement> FirstName;
	
	@FindBy(id="lastName")
	List<WebElement> LastName;
	
	@FindBy(xpath="//*[@id='changeWorkContactInfo']")
	WebElement PrimaryContactInfoNoButton;
	
	@FindBy(xpath="//*[@id='changeHomeContactInfo']")
	WebElement SecondaryContactInfoNoButton;
	
	@FindBy(xpath="//*[@id='primaryEmailOverride']")
	WebElement PrimaryEMailAddressNoButton;
	
	@FindBy(xpath="//*[@id='primaryPlaceOfUsageZipSameAsBillingZip']")
	WebElement ZIpCode;
	
	@FindBy(id="btnNext")
	List<WebElement> NextButton;
	
	public CustomerInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void FillCustomerInfoPage(String FedTaxID , String CustomerFirstName , String CustomerLastName)
	{
		TaxExemptNoButton.click();
		TaxID.sendKeys(FedTaxID);
		FirstName.get(1).sendKeys(CustomerFirstName);
		LastName.get(1).sendKeys(CustomerLastName);
		PrimaryContactInfoNoButton.click();
		SecondaryContactInfoNoButton.click();
		PrimaryEMailAddressNoButton.click();
		ZIpCode.click();
		NextButton.get(1).click();
	}

}
