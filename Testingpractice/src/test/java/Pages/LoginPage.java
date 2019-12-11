package Pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import BasePage.BaseClass;
import Reports.Report;

public class LoginPage extends BaseClass{
	
	
	/*
	public static LoginPage Email() throws IOException, InterruptedException, AWTException {
	
	BaseClass.robotScreenshot("Login");
		
	String s=BaseClass.configproperties("Excelfile");
		
	WebElement email= driver.findElement(By.xpath("//input[@id='email_create']"));
	email.sendKeys(BaseClass.readExcelData(s, "userdetails", 2, 1));
	
	WebElement create= driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));
	create.click();
	
	return null;
	
	}
	*/
	public static LoginPage Email(String emailData) throws IOException, InterruptedException, AWTException {
		
	BaseClass.robotScreenshot("Login");
		
	//String s=BaseClass.configproperties("Excelfile");
		
	WebElement email= driver.findElement(By.xpath("//input[@id='email_create']"));
	email.sendKeys(emailData);
	
	WebElement create= driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));
	create.click();
	
	return null;
	
	}
	
	
	
	public static LoginPage VerifyLoginPage() {
		
	WebElement createaccount= driver.findElement(By.xpath("//h1[@class='page-heading']"));
	String account1= createaccount.getText();
	   
	if(account1.contains("CREATE AN ACCOUNT"))
	{
		 System.out.println("valid login page");
		 Report.logTest("PASS", "Passed test case");
    }
	else
	{
	     System.out.println("invalid login page");
	     Report.logTest("FAIL", "Failed test case");
	}
	return null;
	
	
}


}
