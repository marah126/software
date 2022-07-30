package softwareProject;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class borrowSteps {
	
	public user u;
	public book b;
	public myLibrary l;
	boolean flag;
	book b1,b2;
	public borrowSteps(myLibrary ll) {
		
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
			   l.registeredUsers.add(u);
	}
	}

	@Given("these books contained in the library")
	public void these_books_contained_in_the_library(io.cucumber.datatable.DataTable dataTable) {
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
	   flag= l.borrow(b, u);
	}

	@Then("error massage {string} should display")
	public void error_massage_should_display(String string) {
	    assertFalse(flag);
	   // assertFalse(b.borrowed);
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
	    l.borrowed.put(u.ID, x);
	}
	
	@Given("a book with code {string} is in the library")
	public void a_book_with_code_is_in_the_library(String string) {
	    b1=new book("title","auther",string);
	    l.books.add(b1);
	}

	@Given("book with code {string} is in the library")
	public void book_with_code_is_in_the_library(String string) {
	    b2=new book("title2","auther2",string);
	    l.books.add(b2);
	}

	@When("the user borrows the book with code {string}")
	public void the_user_borrows_the_book_with_code(String string) {
	    l.borrow(b2, u);
	}

	@When("{int} day have passed")
	public void day_have_passed(Integer int1) {
	    b2.borrowingDate=b2.borrowingDate.minusDays(int1);
	    l.lateBooks(u, 21);
	}
	
	@When("the user borrow the book with code {string}")
	public void the_user_borrow_the_book_with_code(String string) {
	    flag=l.borrow(b1, u);
	}


	@Then("the book with code {string} is not borrowed by the user")
	public void the_book_with_code_is_not_borrowed_by_the_user(String string) {
		assertTrue(b1.code.equals(string));
	    assertFalse(b1.borrowed);
	}

	@Then("error massage {string} is given")
	public void error_massage_is_given(String string) {
	    assertFalse(flag);
	}
 

	@Then("the user has to pay fine of {int} NIS")
	public void the_user_has_to_pay_fine_of_nis(Integer int1) {
	   l.setFine(int1);
	    assertTrue(u.countFine(int1)==int1);
	}
	@When("the user returns the book with code {string}")
	public void the_user_returns_the_book_with_code(String string) {
	    u.returnBook(b2, l);
	}

}
