package defineStep;


import java.util.List;

import coreAction.Initialize;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junitRunner.Runner2;
import pageFunctions.LoginTestPF;
public class AmazonImplementation2 extends Initialize{
	
	//LoginTestPF lpf = new LoginTestPF(driver);
	
	
	@Given("^users open login page$")
	public void users_open_login_page() throws Throwable {
		System.out.println("Opening amazon URL");
		System.out.println("Driver : "+driver);
		//driver.get("http://www.amazon.in");
		
		
		}

	@When("^user enters credentials$")
	public void user_enters_credentials() throws Throwable {
		lpf.clickYourOrders();
		List<String> l = ldp.getUserDetails();
		String userName = l.get(0);
		String pass = l.get(1);
		lpf.setUsername(userName);
		lpf.clickLogin();
		lpf.setPass(pass);
		
	}

	@And("^click submit button$")
	public void click_submit_button() throws Throwable {
		lpf.clickLogin();
		
	}

	@Then("^user sees the login page$")
	public void user_sees_the_login_page() throws Throwable {
	    System.out.println("Successful login");
	}

}
