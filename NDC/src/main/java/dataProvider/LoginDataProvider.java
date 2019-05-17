package dataProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class LoginDataProvider {
	
	File file = new File("./TestSheet.xlsx");
	public XSSFWorkbook workbook;
	FileInputStream fis;
	public List<String> getUserDetails() {
		List<String> userDetails = new ArrayList<String>();
		try {
			System.out.println("file Path : "+file.getCanonicalPath());
			fis =  new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			XSSFSheet worksheet = workbook.getSheet("Login");
			 for( int i=1; i<=worksheet.getLastRowNum(); i++)
			 {
				 for( int j=1; j<=worksheet.getRow(i).getLastCellNum()-1; j++) {
				 // Import data for Email.
			//userDetails.add(worksheet.getRow(1).getCell(0).getStringCellValue().toString());
			//userDetails.add(worksheet.getRow(1).getCell(1).getStringCellValue().toString());
				  userDetails.add(worksheet.getRow(i).getCell(j).getStringCellValue().toString()); 
			System.out.println("Values are :"+userDetails);
			 }
			     }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDetails;
	}
	
	
public String getUrlDetails(String url) throws InvalidFormatException{
		
		List<String> urlDetails = new ArrayList<String>();
		String NOT_EXIST = "URL is not available";
		try{
			fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			XSSFSheet worksheet = workbook.getSheet("URL");
			int n = worksheet.getLastRowNum();
			System.out.println("Total number of rows :"+n);
			for( int i=1; i<=worksheet.getLastRowNum(); i++)
			 {
				if(worksheet.getRow(i).getCell(0).getStringCellValue().toString().equalsIgnoreCase(url)){
					String newUrl = worksheet.getRow(i).getCell(1).getStringCellValue().toString();;
					return newUrl;
				}
				
			 }
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		return NOT_EXIST;
		
		
		
	}
}
