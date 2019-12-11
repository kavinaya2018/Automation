package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		
//features="src\\test\\resources\\TestCases\\SignUp.feature", glue= {"glue"},
features="src\\test\\resources\\TestCases\\signUpwithScenarioOutline.feature", glue= {"glue","hooks"}


//tags="@AccountCreation"


)

public class testrunner {

}
