package com.crm.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.testbase.TestBase;

public class TestUtil extends TestBase{
public static	long PAGE_LOAD_TIMEOUT=20;
public static long IMPLICITLY_WAIT=20;

String TEST_DATA_PATH="C:\\Users\\SHIVAM\\eclipse-workspace\\freeCrmProject\\"
		+ "src\\main\\java\\com\\crm\\qa\\testdata\\FreCrmTestdata.xlsx";
public XSSFWorkbook book;
public XSSFSheet sheet;

public void switchtoframe(String name) {
	driver.switchTo().frame(name);
}
public void switchtoframe(int index) {
	driver.switchTo().frame(index);
}

public Object[][] getCrmTestData(String sheetName) {
	FileInputStream fis=null;
	try {
		fis = new FileInputStream(TEST_DATA_PATH);
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	 try {
		book=new XSSFWorkbook(fis);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	 sheet = book.getSheet(sheetName);
	 Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	 
	 for(int i=0;i<sheet.getLastRowNum();i++) {
		 for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
			 data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			 
		
		 }
	 }
	 return data;
	
}
public static void takeScreenshotAtEndOfTest() throws IOException {
	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String currentdir=System.getProperty("user.dir");
	FileUtils.copyFile(srcFile, new File(currentdir +"/screenshot/" +System.currentTimeMillis()+".png"));
}
}
