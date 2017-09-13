package opusAutomationE2Emodule;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import opusAutomationCustomerInfoPage.CustomerInfoPage;
import opusAutomationFanInfoPage.FanInfoPage;
import opusAutomationHomePage.HomePage;
import opusAutomationLoginPage.LoginPage;
import opusAutomationexcelReader.ExcelReader;
import opusAutomationtestBase.testBase;

public class TC01Activation extends testBase {
	
	public static final Logger log = Logger.getLogger(TC01Activation.class.getName());	
	
 LoginPage loginpage;
 HomePage  homepage;
 FanInfoPage faninfopage;
 CustomerInfoPage CIPage;
 ExcelReader ereader;
	
  @BeforeTest
  public void setup()
	{
		
		//launchingfirefoxDriver();
		init();
		
		
	}
  
  @Test
  public void activatingIphone() throws Exception {
	  
	  log.info("===============Start Activaton =========================");
	  //ExcelReader
	  ereader = new ExcelReader();
	  //Login Page
	 loginpage = new LoginPage(driver);
	 loginpage.LoginToApplication(ereader.ReadExcel("UserDetails",1,0), ereader.ReadExcel("UserDetails",1,1));
	  //store selection page
	  Select objselect = new Select(driver.findElement(By.xpath(".//select[@class='storeId']")));
	  objselect.selectByVisibleText("CARE - TWILIGHT PHX CARE");
	  driver.findElement(By.xpath(".//button[@id='btnLogin']")).click();
	  
	  //Home page
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  driver.switchTo().frame(1);
	  homepage = new HomePage(driver);
	  homepage.ClickWirelessButton();
	  
	  //FAN info Page
      faninfopage = new FanInfoPage(driver);
      faninfopage.EnterFanDetails(ereader.ReadExcel("FAN ID",1,1));
	  
	  //Customer Info Page
      CIPage = new CustomerInfoPage(driver);
      CIPage.FillCustomerInfoPage("110000110", "Nitin", "Test");
	  
	  //pop ups
	  driver.findElement(By.xpath(".//*[@id='addressValidationPopUp']/div[2]/div/span/input[2]")).click();
	  driver.findElement(By.xpath(" .//*[@id='continueexisitngbanpopup']")).click();
	  
	  //credit validation page
	  driver.findElement(By.xpath(".//input[@id='bntUpdate']")).click();
	  System.out.println("No of blue buttons:"+driver.findElements(By.xpath(".//input[@class='blueButton']")).size());
	  driver.findElement(By.xpath(".//span[@class='floatRight']/input")).click();
	  
	  //Device page
	  //selecting color
	  driver.findElement(By.xpath(".//span[@id='Jet Black#6497A#869.99 ']/child::span[@id='#000000']")).click();
	  //select Device
	  driver.findElement(By.xpath(".//input[@id='selectBtn-iPhone7Plus' and @name='selectequipment']")).click();
	  //select term
	  driver.findElement(By.xpath(".//input[@id='selected_plan_NE30M80P']")).click();
	  //Add to Cart Button
	  driver.findElement(By.id("addtocart-iPhone7Plus")).click();
	  //Continue to Rate plan page Pop up
	  driver.findElement(By.xpath("//input[@class='blueButton addrateplan']")).click();
	  
	  //Rate Plan and Feature Page
	  //Rate Plan Type
	  Select objselect2 = new Select(driver.findElement(By.xpath(".//*[@id='availRatePlansSelect']")));
	  objselect2.selectByVisibleText("Individual");
	  //Rate Plan
	  driver.findElement(By.xpath(".//input[@id='CN1NM0A80' and @type='radio']")).click();
	  driver.findElement(By.xpath(".//*[@id='addRatePlanBtn']")).click();
	  //Feature
	  String s = driver.findElement(By.xpath(".//*[@id='Line-1-carouseltab-WGDATA-subcat']/table/tbody/tr[11]/td[1]/div[2]/div/div[1]")).getText();
	  System.out.println("Feature name is : "+s);
	  //System.out.println("No of elements with Data name "+driver.findElements(By.name("WGDATA")).size());
	  driver.findElement(By.xpath(".//*[@id='Line-1-carouseltab-WGDATA-subcat']/table/tbody/tr[11]/td[1]/div[1]/input")).click();
	  driver.findElement(By.xpath(".//*[@id='continueNewActiBtn']")).click();
	  //Insurance Pop up
	  driver.findElement(By.xpath(".//input[@class='redButton' and @type='submit']")).click();
	  
	  //Reserve CTN Page
	  //First Name on reserve CTN page
	  driver.findElement(By.id("primaryUserFirstName")).sendKeys("Nitin");
	  //Select CTN
	  String CTN = driver.findElement(By.xpath(".//*[@id='selectedCtn']/option[5]")).getText();
	  System.out.println(CTN);
	  driver.findElement(By.xpath(".//*[@id='selectedCtn']/option[5]")).click();
	  //Reserve Number button
	  driver.findElement(By.xpath(".//input[@class='greenButton reserveNumber' and @onclick='reserveNumber()']")).click();
	  //Next Button
	  /*WebDriverWait wait = new WebDriverWait(driver, 20);

	  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[@class='greenbutton' and @value='Unreserve']")));*/
	  
	  
	  Thread.sleep(15000);
	  driver.findElement(By.xpath(".//*[@class='blueButton' and @value='Next >']")).click();
	  
	  //Down Payment Page
	  //Next Button on DP Page
	  driver.findElement(By.xpath(".//input[@class='blueButton' and @id='btnNext']")).click();
	  
	  //Review/Summary Page
	  //Monthly charges
	  String z = driver.findElement(By.xpath(".//*[@id='ctnSummaryDiv']/div[3]/div[3]")).getText();
	  System.out.println("Monthly charges for this order is : "+z);
	  //Next Button on review Page
	  driver.findElement(By.xpath(".//input[@class='blueButton' and @id='ActvNextButton']")).click();
	  
	  //Checkout page
	  driver.findElement(By.id("selectAllCtns")).click();
	  //Pay and Ship Button
	  driver.findElement(By.id("goToPayAndShip")).click();
	  
	  //Shipping page
	  //Shipping type
	  driver.findElement(By.id("selectedFeeType_5")).click();
	  Select objselect3 = new Select(driver.findElement(By.xpath(".//*[@name='shippingMethodStd' and @id='shippingMethod']")));
	  objselect3.selectByVisibleText("Default Standard ($0.00)");
	  //1st Email Address
	  driver.findElement(By.id("email1")).sendKeys("ns8980@att.com");
	  //driver.findElement(By.xpath(".//input[@name=email1CustomerType and @onclick='processCustomerEmail()']")).click();
	  //T&C Email Address
	  driver.findElement(By.xpath(".//input[@name='orderStatusEmail']")).sendKeys("ns8980@att.com");
	  driver.findElement(By.xpath(".//input[@name='orderStatusConfirmEmail']")).sendKeys("ns8980@att.com");
	  //Next Button
	  driver.findElement(By.xpath(".//*[@class='blueButton' and @id='btnSubmit']")).click();
	  
	  //Payment page
	  //Credit check box
	  driver.findElement(By.id("bold_credit_card")).click();
	  //Agree Term above Yes
	  driver.findElement(By.xpath(".//input[@name='rdo' and @value='Yes']")).click();
	  //Credit Card
	  driver.findElement(By.id("cardHolderName")).sendKeys("Master");
	  driver.findElement(By.id("cardNumber")).sendKeys("5122761231011106");
	  driver.findElement(By.id("expMonth")).sendKeys("12");
	  driver.findElement(By.id("expYear")).sendKeys("2017");
	  driver.findElement(By.id("verificationCode1")).sendKeys("234");
	  driver.findElement(By.id("opusmobileccSubmit")).click();
	  
	  //Submit Button
	  driver.findElement(By.xpath(".//*[@id='btnSubmit' and @value='Submit Order']")).click();
	  
	  //Order COnfirmation page
	  String y = driver.findElement(By.xpath(".//*[@id='front']/div[59]/div[3]/div[1]/div/div[2]/div[2]/div/div[5]")).getText();
	  System.out.println("OPUS order number is : "+y);
	  
	  log.info("=========================END TEST ========================");
  }
  
  

  
}
