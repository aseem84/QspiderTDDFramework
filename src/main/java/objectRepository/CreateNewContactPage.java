package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;


public class CreateNewContactPage extends SeleniumUtility{
	
	@FindBy(name = "lastname")
	private WebElement LastNameEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;
	

	// initiliazation
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

    //business library
	
	/**
	 * This method will create new contact
	 * @param lastname
	 */
	public void createNewContact(String lastname)
	{
		LastNameEdt.sendKeys(lastname);
		SaveBtn.click();
	}
	
	/**
	 * This method will create new contact with lead source drop down
	 * @param lastname
	 * @param leadSourceValue
	 */
	public void createNewContact(String lastname, String leadSourceValue)
	{
		LastNameEdt.sendKeys(lastname);
		handleDropDown(leadSourceDropDown, leadSourceValue);
		SaveBtn.click();
	}
	
	
	
	
	
	
	
	
	
	

}
