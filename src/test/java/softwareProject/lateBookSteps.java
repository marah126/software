package softwareProject;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class lateBookSteps {
	 user u=new user("1234567","marah","marah@gmail.com ","AlQuds street","M5M2T5","Nablus");
	 book b=new book( "XP Programming Book","Kent Beck","Kent99");
	 myLibrary l;
	 
	 int xx;
	 public lateBookSteps(myLibrary ll) {
		l=ll; 
	}
	 
	@Given("the user has borrowed a book")
	public void the_user_has_borrowed_a_book() {
	   l.books.add(b);
	   l.registeredUsers.add(u);
	   l.borrow(b, u);
	}

	@Given("{int} days have passed")
	public void days_have_passed(Integer int1) {
		b.borrowingDate=b.borrowingDate.minusDays(int1);
		 xx=int1;
	}

	@Given("the fine for one late book is {int} NIS")
	public void the_fine_for_one_late_book_is_nis(Integer int1) {
	    l.setFine(int1);
	   
	}

	@Then("the user has Late books")
	public void the_user_has_late_books() {
	   assertTrue(l.lateBooks(u, xx));
	   
	}

	@Then("the user has to pay a fine of {int} NIS")
	public void the_user_has_to_pay_a_fine_of_nis(Integer int1) {
	    int z=u.countFine(l.getFine());
	    assertTrue(z==int1); 
	}

}
