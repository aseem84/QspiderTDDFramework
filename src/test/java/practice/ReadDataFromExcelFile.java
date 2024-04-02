package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step 1: Open the document in Java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2: Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: Navigate to required sheet
		Sheet sh = wb.getSheet("Contacts");
		
		//Step 4: Navigate to required row
		Row rw = sh.getRow(1);
		
		//Step 5: Navigate to required cell
		Cell cl = rw.getCell(2);
		
		//Step 6: Capture the data
		String value = cl.getStringCellValue();
		System.out.println(value);
		
		//Step 7: Close the workbook
		wb.close();
		
		
	}

}

