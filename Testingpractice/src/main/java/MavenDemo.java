import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MavenDemo {
	
	public static boolean stringcomparison(String previous, String present) {
		   
		   if(present.equalsIgnoreCase(previous))
		   {
			   return true;
		   }
		   else
		   {
			   return false;
		   }
		
	}
	
	public static void selectByText(WebElement ele, String value)
	{
		Select s=new Select(ele);
				s.selectByVisibleText(value);
		System.out.println("Testing");
	}

	public static String readExcelData(String path, String excelSheet, int excelRow, int excelCell ) throws IOException
	{
		File f=new File(path);
		FileInputStream fis1=new FileInputStream(f);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis1);
		XSSFSheet sheet=wb.getSheet(excelSheet);
		XSSFRow row=sheet.getRow(excelRow);
		XSSFCell cell=row.getCell(excelCell);
		System.out.println(cell.getStringCellValue());
		return cell.getStringCellValue();
	}

	
	
	public static void main(String[] args) throws IOException, InterruptedException {


		
		/*
		System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM AUTOMATION\\chromedriver_win32\\chromedriver.exe");
	
		System.out.println("Property set successfully");
		
		WebDriver driver= new ChromeDriver();
		
	    FileInputStream f= new FileInputStream ("C:\\Users\\my pc\\Desktop\\SELENIUM CONFIGURATION\\Testingpractice\\src\\test\\resources\\config.properties");
	    
	    Properties prop= new Properties();
	    prop.load(f);
	    
	    driver.get(prop.getProperty("URL"));
	    
	    WebElement signin= driver.findElement(By.xpath("//a[@class='login']"));
		signin.click();
		
		Thread.sleep(5000);
		
		String s= prop.getProperty("Excelfile");
		
		WebElement create= driver.findElement(By.xpath("//input[@id='email_create']"));
		create.sendKeys(MavenDemo.readExcelData(s, "userdetails", 2, 1));
		
		WebElement create1= driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));
		create1.click();
		
		Thread.sleep(5000);
		
		WebElement gender2 = driver.findElement(By.xpath("//*[@id=\"id_gender2\"]"));
		gender2.click();
			
		WebElement firstnme= driver.findElement(By.id("customer_firstname"));
	    firstnme.sendKeys(MavenDemo.readExcelData(s, "userdetails", 3, 1));
			
		WebElement lastnme= driver.findElement(By.id("customer_lastname"));
		lastnme.sendKeys(MavenDemo.readExcelData(s, "userdetails", 4, 1));
		
		WebElement mail= driver.findElement(By.xpath("//*[@id=\"email\"]"));
		
		String present= mail.getAttribute("value");
		String previous= MavenDemo.readExcelData(s, "userdetails", 2, 1);
		
		boolean str= MavenDemo.stringcomparison(previous, present);

		System.out.println(str);
		
		WebElement fstnme= driver.findElement(By.xpath("//input[@id='firstname']"));
		
		String previous1= fstnme.getAttribute("value");
		String present1=  MavenDemo.readExcelData(s, "userdetails", 3, 1);
		
		boolean str1= MavenDemo.stringcomparison(previous1, present1);
		
		System.out.println(str1);
	
        WebElement lstnme= driver.findElement(By.xpath("//input[@id='lastname']"));
		
		String previous2= lstnme.getAttribute("value");
		String present2=  MavenDemo.readExcelData(s, "userdetails", 4, 1);
		
		boolean str2= MavenDemo.stringcomparison(previous2, present2);
		
		System.out.println(str2);
		
		WebElement password= driver.findElement(By.name("passwd"));
		password.sendKeys(MavenDemo.readExcelData(s, "userdetails", 5, 1));
	
		String dob= MavenDemo.readExcelData(s, "userdetails", 17, 1);
		System.out.println(dob);
		
		String day, month, year;
		String date1[]= dob.split("-");
		day= date1[0];
     	month= date1[1];
		year= date1[2];
		
		WebElement dod= driver.findElement(By.xpath("//*[@id=\"days\"]"));
	    dod.sendKeys(day);
	       
	    WebElement dom= driver.findElement(By.xpath("//*[@id=\"months\"]"));
	    
	    FileInputStream f1= new FileInputStream("C:\\Users\\my pc\\Desktop\\SELENIUM CONFIGURATION\\Testingpractice\\src\\test\\resources\\month.properties");
	    
	    Properties prop1= new Properties();
	    prop1.load(f1);
	    
	    dom.sendKeys(prop1.getProperty(month));
	    
	    WebElement doy= driver.findElement(By.xpath("//*[@id=\"years\"]"));
	    doy.sendKeys(year);
		
		WebElement check= driver.findElement(By.xpath("//*[@id=\"optin\"]"));
	   	check.click();
	
	    WebElement company= driver.findElement(By.xpath("//*[@id=\"company\"]"));
		company.sendKeys(MavenDemo.readExcelData(s, "userdetails", 6, 1));
		   
	    WebElement address1 =driver.findElement(By.id("address1"));
		address1.sendKeys(MavenDemo.readExcelData(s, "userdetails", 7, 1));
		   
		WebElement address2= driver.findElement(By.xpath("//*[@id=\"address2\"]"));
		address2.sendKeys(MavenDemo.readExcelData(s, "userdetails", 8, 1));
		   
		WebElement city= driver.findElement(By.xpath("//*[@id=\"city\"]"));
		city.sendKeys(MavenDemo.readExcelData(s, "userdetails", 9, 1));
		 
	    WebElement dropdown1= driver.findElement(By.xpath("//*[@id=\"id_state\"]"));
		String state= MavenDemo.readExcelData(s, "userdetails", 10, 1);
	    MavenDemo.selectByText(dropdown1, state);
		   
		WebElement postcode1= driver.findElement(By.id("postcode"));
		postcode1.sendKeys(MavenDemo.readExcelData(s, "userdetails", 11, 1));
		  
		WebElement country1= driver.findElement(By.id("id_country"));
		String country= MavenDemo.readExcelData(s, "userdetails", 12, 1);
	    MavenDemo.selectByText(country1, country);
		   
		WebElement additional= driver.findElement(By.id("other"));
		additional.sendKeys(MavenDemo.readExcelData(s, "userdetails", 13, 1));
		   
		WebElement phone1= driver.findElement(By.id("phone"));
		phone1.sendKeys(MavenDemo.readExcelData(s, "userdetails", 14, 1));
		   
	    WebElement phonemobile= driver.findElement(By.id("phone_mobile"));
		phonemobile.sendKeys(MavenDemo.readExcelData(s, "userdetails", 15, 1));
	       
		WebElement alias= driver.findElement(By.id("alias"));
		alias.clear();
		alias.sendKeys(MavenDemo.readExcelData(s, "userdetails", 16, 1));
	   	
	   	
	}


*/
	}
}
