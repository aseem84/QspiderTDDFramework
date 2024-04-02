package contactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateNewContactTest extends BaseClass {

	@Test(groups = "SmokeSuite")
	public void createContactWithMandatoryfields() throws IOException, InterruptedException
	{
		/* Read data from Excel File */
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);

		// Step 3: Navigate to contacts Link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();

		// Step 4: Click on Create Contact Look Up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickoncreateContactLookUpImg();

		// Step 5: Create Contact With Mandatory fields and save
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		
		// Step 6: Validate for Contact
		ContactInfoPage cip = new ContactInfoPage(driver);		
		String contactHeader = cip.captureHeaderText();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);


	}
	
	@Test
	public void sample()
	{
		System.out.println("demo");
	}

}
