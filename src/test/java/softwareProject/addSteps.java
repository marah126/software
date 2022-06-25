package softwareProject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class addSteps {
	
	public admin admistrator;
	public myLibrary l;
	public book b;
	
	public addSteps(myLibrary ll,admin aa) {
		l=ll;
		admistrator=aa;
		
	}
	

	@Given("that the administrator is logged in")
	public void that_the_administrator_is_logged_in() {
		admistrator.setLogState(true);
	}

	@Given("there is a book with title {string}, author {string}, and signature {string}")
	public void there_is_a_book_with_title_author_and_signature(String string, String string2, String string3) {
	    b=new book(string,string2,string3);
	    
	}

	@When("the book is added to the library")
	public void the_book_is_added_to_the_library() {
	    l.add(b, admistrator);
	}

	@Then("the book with title {string}, author {string}, and signature {string} is contained in the library")
	public void the_book_with_title_author_and_signature_is_contained_in_the_library(String string, String string2, String string3) {
	    assertTrue(l.books.size()==1);
	    assertTrue( l.isContained(string,string2,string3));
	}

	@Given("that the administrator is not logged in")
	public void that_the_administrator_is_not_logged_in() {
		admistrator.setLogState(false);
	}

	@Then("the error message {string} is given")
	public void the_error_message_is_given(String string) {
		assertTrue(l.books.size()==0);
	    assertEquals(string, "Administrator login required");
	}


}
