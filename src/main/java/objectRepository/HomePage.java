package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;


public class HomePage extends SeleniumUtility {
	
	//Declaration - webelements - dropdowns,windows, frames, mousehovering,
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLnk;
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSingoutLnk() {
		return signoutLnk;
	}
	
	//Business LIbrary
	
	/**
	 * This method will click on contacts link in home page
	 */
	public void clickOnContactsLink()
	{
		contactsLnk.click();
	}
	
	/** 
	 * This method will logout of the Application
	 * @param driver
	 * @throws InterruptedException
	 */
	public void logoutOfApp(WebDriver driver) throws InterruptedException
	{
		mouseHoverAction(driver, administratorImg);
		Thread.sleep(1000);
		signoutLnk.click();
		
	}
	
	
	
	
	

}
