package softwareProject;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class unregisterSteps {
	user u;
	myLibrary l;
	admin a;
	
	public unregisterSteps(myLibrary ll,admin aa) {
		l=ll;
		a=aa;
	}
	@Given("a user with ID {string} , name {string} , email {string} , address {string} ,postal code {string} , and city {string} id registered in the library")
	public void a_user_with_id_name_email_address_postal_code_and_city_id_registered_in_the_library(String id, String name, String email, String address, String code, String city) {
	    u=new user(id,name,email,address,code,city);
	    l.registeredUsers.add(u);
	}
	
	@Given("admin is logged in")
	public void admin_is_logged_in() {
	    a.setLogState(true);
	}


	@When("the try to unregister the user")
	public void the_try_to_unregister_the_user() {
	    l.unregister(a, u);
	}

	@Then("the user is out of the library")
	public void the_user_is_out_of_the_library() {
	    assertFalse(l.checkUser(u));
	}
	
	@Given("user has borrowed book")
	public void user_has_borrowed_book() {
	   book b=new book();
	   ArrayList<book>books=new ArrayList<book>();
	   l.borrowed.put(u.ID, books);
	}

	@Then("the user sould still in the library")
	public void the_user_sould_still_in_the_library() {
	    assertTrue(l.checkUser(u));
	}

	@Given("user has unpaid fine")
	public void user_has_unpaid_fine() {
	    u.lateBooks++;
	    u.countFine(30);
	}
}
