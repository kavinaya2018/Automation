package BasePage;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	
	protected static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentHtmlReporter report;
	public static ExtentTest test;
	public static String scenarioName;
	
	public static String configproperties(String key) throws IOException {
		
		 FileInputStream f= new FileInputStream ("C:\\Users\\my pc\\Desktop\\SELENIUM CONFIGURATION\\Testingpractice\\src\\test\\resources\\config.properties");
		 Properties prop= new Properties();
		 prop.load(f);
		 String value=prop.getProperty(key);
		 return value;
		 }
	
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
	
	
	
	public static void launch() {

		System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM AUTOMATION\\chromedriver_win32\\chromedriver.exe");
	
		System.out.println("Property set successfully");
		
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	
	public static void launchapp() throws IOException {
		
		 FileInputStream f= new FileInputStream ("C:\\Users\\my pc\\Desktop\\SELENIUM CONFIGURATION\\Testingpractice\\src\\test\\resources\\config.properties");
		 Properties prop= new Properties();
		 prop.load(f);
		
		driver.get(prop.getProperty("URL"));
		

		
		
	}
	
	
		
	public static void Screenshot(String fileName) throws IOException {

		TakesScreenshot screenShot = (TakesScreenshot) driver;

		File src = screenShot.getScreenshotAs(OutputType.FILE);

		File dest = new File("C:\\Users\\my pc\\Desktop\\SELENIUM CONFIGURATION\\NEWProject\\src\\" + fileName + ".png");

		FileHandler.copy(src, dest);

	}

	
	
	
	public static void robotScreenshot(String fileName) throws AWTException, IOException {

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

		Rectangle rect = new Rectangle(dimension);

		Robot robo = new Robot();

		BufferedImage src = robo.createScreenCapture(rect);

		File dest = new File("C:\\Users\\my pc\\Desktop\\SELENIUM CONFIGURATION\\Testingpractice\\src\\main\\java\\" + fileName + ".png");

		ImageIO.write(src, "png", dest);

	}
	
	
	public static void DriverClose() {
		
		driver.close();
	}




}
