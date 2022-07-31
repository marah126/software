package softwareProject;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;

import io.cucumber.java.it.Date;

public class book {
	String title;
	String auther;
	String code;
	boolean borrowed;
	LocalDate borrowingDate; 
	public book() {
		
	}
	public book(String t,String a,String c) {
		title=t;
		auther=a;
		code=c;
		borrowed =false;
		borrowingDate=LocalDate.now();		
	}
}
