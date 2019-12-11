package Pages;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hpsf.Property;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BasePage.BaseClass;

public class HomePage extends BaseClass{

public static HomePage clickSignIn() throws IOException, AWTException {    

		    driver.get(BaseClass.configproperties("URL"));
		    
		    BaseClass.robotScreenshot("Homepage");
		    
		    WebElement signin= driver.findElement(By.xpath("//a[@class='login']"));
			signin.click();
			return null;
			
	}
}
