package glue;

import BasePage.BaseClass;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SigninPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	
	@Given("^user launches the browser$")
	public void user_launches_the_browser() throws Throwable {
	   
		BaseClass.launch();
		
	}

	@Given("^opens the application$")
	public void opens_the_application() throws Throwable {
	    
		BaseClass.launchapp();
		
	}

	@When("^click on signin button$")
	public void click_on_signin_button() throws Throwable {
	    
		HomePage.clickSignIn();
		
	}
/*
	@Then("^go to email verification page$")
	public void go_to_email_verification_page() throws Throwable {
	    
		LoginPage.Email();
		
	}
*/
	@Then("^verify the result$")
	public void verify_the_result() throws Throwable {
	    
		LoginPage.VerifyLoginPage();
	
		
	}

	@Then("^should not go to email verification page$")
	public void should_not_go_to_email_verification_page() throws Throwable {
	   
		LoginPage.VerifyLoginPage();
		
	}
	
	
	
	
	

	/*
	@Given("^user enters email id and clicks on create button$")
	public void user_enters_email_id_and_clicks_on_create_button() throws Throwable {
	  
		LoginPage.Email();
		
	}
	*/
	@Given("^user enters email id and clicks on create button (.*)$")
	public void userEntersEmaildIdfromFeature(String emailData) throws Throwable
	{
		LoginPage.Email(emailData);
	}

	@When("^user enters the required details$")
	public void user_enters_the_required_details() throws Throwable {
	    
		SigninPage.userdetails();
	}

	@When("^clicks on submit button$")
	public void clicks_on_submit_button() throws Throwable {
	    
		SigninPage.register();
		
	}

	@Then("^account should be created$")
	public void account_should_be_created() throws Throwable {
	    
		SigninPage.verification();
		
	}

	@Then("^account should not be created$")
	public void account_should_not_be_created() throws Throwable {
	    
		SigninPage.verification();
	}
	
	@Then("^Close the browser$")
	public void close_the_browser() throws Throwable {
	    
		BaseClass.DriverClose();
		
	}



	
}
