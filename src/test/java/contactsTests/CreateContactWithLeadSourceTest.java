package contactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;

public class CreateContactWithLeadSourceTest extends BaseClass{
	
	@Test(groups = "RegressionSuite")
	public void createContactWithLead() throws EncryptedDocumentException, IOException
	{
		/* Read data from Excel File */
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
		String LEADSOURCE = eUtil.readDataFromExcel("Contacts", 4, 3);

		// Step 3: Navigate to contacts Link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();

		// Step 4: Click on Create Contact Look Up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickoncreateContactLookUpImg();

		// Step 5: Create Contact With Mandatory fields and save
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME, LEADSOURCE);

		// Step 6: Validate for Contact
		ContactInfoPage cip = new ContactInfoPage(driver);		
		String contactHeader = cip.captureHeaderText();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);

	}

}
