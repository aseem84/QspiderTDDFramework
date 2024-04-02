package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	// declaration
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement CreateContactLookUpImg;

	// initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public WebElement getCreateContactLookUpImg() {
		return CreateContactLookUpImg;
	}
	
	//business library
	
	/**
	 * This method will click on create contact loop up image
	 */
	public void clickoncreateContactLookUpImg()
	{
		CreateContactLookUpImg.click();
	}
	
	
	
}
