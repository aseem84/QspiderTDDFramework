package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class Scenario1WithDDTAndGU {

	public static void main(String[] args) throws InterruptedException, IOException {

		// Create Object of All Utility Classes
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();

		/* Read data from property file */
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");

		/* Read data from Excel File */
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);

		// Step 1: Launch the browser
		WebDriver driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);

		driver.get(URL);

		// Step 2: Login to Application
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		
//		lp.getUserNameEdt().sendKeys(USERNAME);
//		lp.getPasswordEdt().sendKeys(PASSWORD);
//		lp.getSubmitBtn().click();
		
		
		
		

		// Step 3: Navigate to contacts Link
		driver.findElement(By.linkText("Contacts")).click();

		// Step 4: Click on Create Contact Look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// Step 5: Create Contact With Mandatory fields and save
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 6: Validate for Contact
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(contactHeader);

		if (contactHeader.contains(LASTNAME)) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}

		// Step 7: Logout of App
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		sUtil.mouseHoverAction(driver, ele);

		Thread.sleep(1000);

		driver.findElement(By.linkText("Sign Out")).click();

		// Step 8: Close the browser
		driver.quit();

	}

}
