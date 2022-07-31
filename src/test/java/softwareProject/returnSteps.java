package softwareProject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class returnSteps {
	
	public user u;
	public book b;
	public myLibrary l;
	String s;
	public returnSteps(myLibrary ll) {
		l=ll;
	}
	
	@Given("there is a user  ID {string} , name {string} , email {string} , address {string} , postal code {string} , city {string}")
	public void there_is_a_user_id_name_email_address_postal_code_city(String id, String name, String email, String address, String postal, String city) {
	    u=new user(id,name,email,address,postal,city);
	}

	@Given("there is a book with title {string} , auther {string} , code {string}")
	public void there_is_a_book_with_title_auther_code(String title, String auther, String code) {
	    b=new book(title,auther,code);
	    l.books.add(b);
	}
	

	@Given("user is registered in library")
	public void user_is_registered_in_library() {
		l.registeredUsers.add(u);
	}
	
	@Given("the user has borrowed this book")
	public void the_user_has_borrowed_this_book() {
	    
	    l.borrow(b, u);
	}
	@When("action \\(return) happens")
	public void action_return_happens() {
	   s= u.returnBook(b, l);
	   System.out.println(s);
	}

	@Then("the book not be borrowed")
	public void the_book_not_be_borrowed() {
	    assertFalse(b.borrowed);
	}

	@Then("error message should  display {string}")
	public void error_message_should_display(String string) {
	    assertEquals(s,string);
	}

}
