package softwareProject;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchSteps {
	
	public myLibrary l;
	public book b;
	public admin user=new admin();
	String title ,auther,code;
	
	boolean resultFlag=false;
	
	ArrayList<book> Result=new ArrayList<book>();
	
	public searchSteps(myLibrary lib, admin a) {
		System.out.println("search feature");
		l=lib;
		user=a;
	}
	
	@Given("these books are contained in the library")
	public void these_books_are_contained_in_the_library(io.cucumber.datatable.DataTable dataTable) {
		  for(int i=0; i<4;i++) {
			   title=dataTable.cell(i,0);
			   auther=dataTable.cell(i,1);
			   code=dataTable.cell(i,2);
			   
			   b=new book(title,auther,code);
			   l.add(b,user);
		   }
	
	}

	@When("the user searches for the text {string}")
	public void the_user_searches_for_the_text(String string) {
	      Result=l.codeSearch(string);
	}

	@Then("the book with code {string} is found")
	public void the_book_with_code_is_found(String string) {
	    // assertTrue(Result.size()==1);
	     assertTrue(Result.get(0).code.equals(string) );
	     /*System.out.println(Result.size());
			for(int i=0;i<Result.size();i++) {
				System.out.println(Result.get(i));
				
			}*/ 
	     
	}

	@Then("no books are found")
	public void no_books_are_found() {
		assertTrue(Result.isEmpty());
	   
	}

	@Then("the books with code {string} and {string} are found")
	public void the_books_with_code_and_are_found(String string, String string2) {
		// assertTrue(Result.size()==2);
		/*System.out.println(Result.size());
		for(int i=0;i<Result.size();i++) {
			System.out.println(Result.get(i).code);
			
		}*/
	     assertTrue(Result.get(0).code.equals(string) && Result.get(1).code.equals(string2));
	}

}
