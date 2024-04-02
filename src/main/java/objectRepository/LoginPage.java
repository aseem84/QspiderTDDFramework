package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //Rule 1: Create a seperate pom class every web page
	
	//Rule 2: identify the web Elements using @FindBY and make them Private
	@FindBy(name = "user_name") 
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passwordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement submitBtn;
	
	//Rule 3: Create a constructor for initialisation
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this); 
	}

	//Rule 4: Provide getters
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//business library - generic method
	
	/**
	 * This method will perform login operation
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username,String password)
	{
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		submitBtn.click();
	}
	
	

}
