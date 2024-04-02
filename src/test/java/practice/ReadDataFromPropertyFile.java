package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	
	public static void main(String[] args) throws IOException {
		
		//Step 1: Open the document in Java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2: Create an Object of Properties class from Java.util
		Properties p = new Properties();
		
		//Step 3: Load the file input stream to properties
		p.load(fis);
		
		//Step 4: provide the key and read the value
		String value = p.getProperty("username");
		System.out.println(value);
		
		
		
	}

}
