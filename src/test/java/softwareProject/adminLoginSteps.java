package softwareProject;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class adminLoginSteps {
	
	public admin a;
	public String pass;
	
	public adminLoginSteps(admin ad) {
		a=ad;
	}
@Given("that the admin is not logged in")
public void that_the_admin_is_not_logged_in() {
    // Write code here that turns the phrase above into concrete actions
	a.setLogState(false);
   
}

@Given("the password is {string}")
public void the_password_is(String string) {
    // Write code here that turns the phrase above into concrete actions
    
    pass=string;
}

@Then("the admin login succeeds")
public void the_admin_login_succeeds() {
    // Write code here that turns the phrase above into concrete actions
    assertTrue(a.login(pass));
}

@Then("the admin is logged in")
public void the_admin_is_logged_in() {
    // Write code here that turns the phrase above into concrete actions
	assertTrue(a.getLogState());

}

@Then("the admin login fails")
public void the_admin_login_fails() {
    // Write code here that turns the phrase above into concrete actions
   assertFalse(a.login(pass));
}

@Then("the admin is not logged in")
public void the_admin_is_not_logged_in() {
    // Write code here that turns the phrase above into concrete actions
	assertFalse(a.getLogState());
  
}



}
