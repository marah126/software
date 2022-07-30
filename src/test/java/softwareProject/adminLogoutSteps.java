package softwareProject;

import static org.junit.Assert.assertFalse;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class adminLogoutSteps {
	
	public admin a;
	public adminLogoutSteps(admin ad) {
		a=ad;
	}
	

	@Given("that the admin is logged in")
	public void that_the_admin_is_logged_in() {
	    a.setLogState(true);
	}

	@When("the admin logs out")
	public void the_admin_logs_out() {
	   a.logout();
	}
	
	

}
