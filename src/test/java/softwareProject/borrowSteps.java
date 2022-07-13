package softwareProject;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class borrowSteps {
	
	public user u;
	public book b;
	public myLibrary l;
	boolean flag;
	
	public borrowSteps(myLibrary ll) {
		//u=uu;
	//	b=bb;
		l=ll;
	}
	@Given("these usere registered in the library")
	public void these_usere_registered_in_the_library(io.cucumber.datatable.DataTable dataTable) {
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
	}

	@Given("these books contained in the library")
	public void these_books_contained_in_the_library(io.cucumber.datatable.DataTable dataTable) {
		System.out.println("adding book from borrow");
		String title ,auther,code;
		admin ad=new admin();
	    ad.logState=true;
		for(int i=0; i<5;i++) {
			   title=dataTable.cell(i,0);
			   auther=dataTable.cell(i,1);
			   code=dataTable.cell(i,2);
			   
			   b=new book(title,auther,code);
			   l.add(b,ad);
		   }
	}

	@Given("these books borrowed")
	public void these_books_borrowed(io.cucumber.datatable.DataTable dataTable) {
	    
	}

	@Given("there is a user has ID {string} , name {string} , email {string} , address {string} ,postal code {string} , and city {string}")
	public void there_is_a_user_has_id_name_email_address_postal_code_and_city(String id, String name, String email, String address, String postal, String city) {
	    u=new user(id,name,email,address,postal,city);
	}

	@Given("there is a book with title {string} , auther {string} and code {string}")
	public void there_is_a_book_with_title_auther_and_code(String title, String auther, String code) {
	    b=new book(title,auther,code);
	}

	@When("the user tries to borrow this book")
	public void the_user_tries_to_borrow_this_book() {
	    flag=u.borrow(b,l);
	}

	@Then("error massage {string} should display")
	public void error_massage_should_display(String string) {
	    assertFalse(flag);
	    //assertFalse(b.borrowed);
	}

	@Given("the book is borrowed")
	public void the_book_is_borrowed() {
	    b.borrowed=true;   
	}

	@Given("the book is not borrowed")
	public void the_book_is_not_borrowed() {
	    b.borrowed=false;
	}

	@Then("the boorowing should success")
	public void the_boorowing_should_success() {
	   assertTrue(flag);
	   assertTrue(b.borrowed);
	}

	@Given("this user has borrowed maximum books")
	public void this_user_has_borrowed_maximum_books() {
	    ArrayList<book>x=l.books;
	    System.out.println(x.size());
	    myLibrary.borrowed.put(u.ID, x);
	}

}
