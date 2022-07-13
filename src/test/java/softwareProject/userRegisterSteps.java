package softwareProject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class userRegisterSteps {

	public admin a;
	public user u;
	//public myLibrary lib;
	
	String s;
	int before;
	int after;
	
	public userRegisterSteps(admin aa) {
		a=aa;
		//lib=l;
	}
	
	@Given("these usere are registered in the library")
	public void these_usere_are_registered_in_the_library(io.cucumber.datatable.DataTable dataTable) {
		String id,name,email,add,postal,city;
	
			for(int i=0; i<3;i++) {
				   id=dataTable.cell(i,0);
				   name=dataTable.cell(i,1);
				   email=dataTable.cell(i,2);
				   add=dataTable.cell(i,3);
				   postal=dataTable.cell(i,4);
				   city=dataTable.cell(i,5);
				   
				   u=new user(id,name,email,add,postal,city);
				   myLibrary.registeredUsers.add(u);
		}
			before=myLibrary.registeredUsers.size();
					
	}

	@Given("there is a user with ID {string} , name {string} , email {string} , address {string} ,postal code {string} , and city {string}")
	public void there_is_a_user_with_id_name_email_address_postal_code_and_city(String id, String name, String email, String address, String postal, String city) {
	     u=new user(id,name,email,address,postal,city);
	}

	@When("admin tries to register a user")
	public void admin_tries_to_register_a_user() {
		s=a.register(u);
		after=myLibrary.registeredUsers.size();
	   
	}

	@Then("an error massage {string} should display")
	public void an_error_massage_should_display(String string) {
	    assertEquals(string,s);
	    assertEquals(before, after);
	}
	
	@Then("an information message {string} should displayed")
	public void an_information_message_should_displayed(String string) {
		assertEquals(string,s);
	    assertEquals(before+1, after);
	}


	
}
