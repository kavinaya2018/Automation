package Pages;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePage.BaseClass;

public class SigninPage extends BaseClass{
	
	public static SigninPage userdetails() throws IOException, InterruptedException, AWTException {
	
	BaseClass.robotScreenshot("Signin");	
		
	String s=BaseClass.configproperties("Excelfile");
	
	Thread.sleep(4000);
	WebElement gender2 = driver.findElement(By.xpath("//*[@id=\"id_gender2\"]"));
	gender2.click();
	
	Thread.sleep(4000);
	
	WebElement firstnme= driver.findElement(By.xpath("//input[@id='customer_firstname']"));
    firstnme.sendKeys(BaseClass.readExcelData(s, "userdetails", 3, 1));
		
	WebElement lastnme= driver.findElement(By.id("customer_lastname"));
	lastnme.sendKeys(BaseClass.readExcelData(s, "userdetails", 4, 1));
	
	WebElement mail= driver.findElement(By.xpath("//*[@id=\"email\"]"));
	
	String present= mail.getAttribute("value");
	String previous= BaseClass.readExcelData(s, "userdetails", 2, 1);
	
	boolean str= BaseClass.stringcomparison(previous, present);

	System.out.println(str);
	
	WebElement fstnme= driver.findElement(By.xpath("//input[@id='firstname']"));
	
	String previous1= fstnme.getAttribute("value");
	String present1=  BaseClass.readExcelData(s, "userdetails", 3, 1);
	
	boolean str1= BaseClass.stringcomparison(previous1, present1);
	
	System.out.println(str1);

    WebElement lstnme= driver.findElement(By.xpath("//input[@id='lastname']"));
	
	String previous2= lstnme.getAttribute("value");
	String present2=  BaseClass.readExcelData(s, "userdetails", 4, 1);
	
	boolean str2= BaseClass.stringcomparison(previous2, present2);
	
	System.out.println(str2);
	
	WebElement password= driver.findElement(By.name("passwd"));
	password.sendKeys(BaseClass.readExcelData(s, "userdetails", 5, 1));

	String dob= BaseClass.readExcelData(s, "userdetails", 17, 1);
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
	company.sendKeys(BaseClass.readExcelData(s, "userdetails", 6, 1));
	   
    WebElement address1 =driver.findElement(By.id("address1"));
	address1.sendKeys(BaseClass.readExcelData(s, "userdetails", 7, 1));
	   
	WebElement address2= driver.findElement(By.xpath("//*[@id=\"address2\"]"));
	address2.sendKeys(BaseClass.readExcelData(s, "userdetails", 8, 1));
	   
	WebElement city= driver.findElement(By.xpath("//*[@id=\"city\"]"));
	city.sendKeys(BaseClass.readExcelData(s, "userdetails", 9, 1));
	 
    WebElement dropdown1= driver.findElement(By.xpath("//*[@id=\"id_state\"]"));
	String state= BaseClass.readExcelData(s, "userdetails", 10, 1);
    BaseClass.selectByText(dropdown1, state);
	   
	WebElement postcode1= driver.findElement(By.id("postcode"));
	postcode1.sendKeys(BaseClass.readExcelData(s, "userdetails", 11, 1));
	  
	WebElement country1= driver.findElement(By.id("id_country"));
	String country= BaseClass.readExcelData(s, "userdetails", 12, 1);
    BaseClass.selectByText(country1, country);
	   
	WebElement additional= driver.findElement(By.id("other"));
	additional.sendKeys(BaseClass.readExcelData(s, "userdetails", 13, 1));
	   
	WebElement phone1= driver.findElement(By.id("phone"));
	phone1.sendKeys(BaseClass.readExcelData(s, "userdetails", 14, 1));
	   
    WebElement phonemobile= driver.findElement(By.id("phone_mobile"));
	phonemobile.sendKeys(BaseClass.readExcelData(s, "userdetails", 15, 1));
       
	WebElement alias= driver.findElement(By.id("alias"));
	alias.clear();
	alias.sendKeys(BaseClass.readExcelData(s, "userdetails", 16, 1));
	
	System.out.println("form filled");
	return null;
	}

	
	
	public static SigninPage register() {
	
	WebElement register= driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span"));
	register.click();
	return null;
	
	}
	
	
	
	public static SigninPage verification() {
		
		WebElement account= driver.findElement(By.xpath("//p[@class='info-account']"));
		String account1= account.getText();
		   
		if(account1.contains("Welcome to your account"))
		{
			 System.out.println("account created");
	    }
		else
		{
		     System.out.println("not created");
		}
		
		return null;
		
		
	}

}
