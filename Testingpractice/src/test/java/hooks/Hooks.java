package hooks;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BasePage.BaseClass;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BaseClass {
	
	@Before
	public void setup() throws IOException
	{
		
		BaseClass.launch();
		BaseClass.launchapp();
		
		report = new ExtentHtmlReporter("report.html");
		extent= new ExtentReports();
		extent.attachReporter(report);
		test= extent.createTest(scenarioName, "SignUp");
		
		
	}
	
	@After
	public void tearDown()
	{
		extent.flush();
		driver.close();
		driver.quit();
	}

}
