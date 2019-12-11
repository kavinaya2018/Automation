package Reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BasePage.BaseClass;

public class Report extends BaseClass {
	
	public static void logTest(String result, String desc) {

		if (result.equalsIgnoreCase("Pass")) 
		{
			test.log(Status.PASS, "");

		} 
		 else if (result.equalsIgnoreCase("Fail")) 
		{
			test.log(Status.FAIL, "");
		} 
		else if (result.equalsIgnoreCase("Info")) 
		{
			test.log(Status.INFO, "Info");

		}
	
		
		
		
		
		
		
	}

}
