package softwareProject;

import static org.junit.Assert.assertFalse;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class adminLogoutSteps {
	
	public admin a;
	public adminLogoutSteps(admin ad) {
		System.out.println("logout feature");
		a=ad;
	}
	

	@Given("that the admin is logged in")
	public void that_the_admin_is_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
	    a.setLogState(true);
	}

	@When("the admin logs out")
	public void the_admin_logs_out() {
	    // Write code here that turns the phrase above into concrete actions
	   a.logout();
	}
	
	

}
