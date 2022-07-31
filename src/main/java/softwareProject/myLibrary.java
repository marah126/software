package softwareProject;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Hashtable;
import java.util.List;

import javax.swing.JOptionPane;


import java.time.Duration;

public class myLibrary {

	public ArrayList<book> books =new ArrayList<book>();
	public  ArrayList<user>registeredUsers =new ArrayList<user>();
	
	public  Hashtable<String,ArrayList<book>>borrowed=new Hashtable<String, ArrayList<book>>();
	book b,c,d;
	int  fine;
	
	DateServer date=new DateServer();
	
	public void add(book b, admin user) {
		// TODO Auto-generated method stub
		if( user.getLogState()==false) {
			System.out.println("you can't add books");
		}
		else {
			books.add(b);
			
		}
	}

	public ArrayList<book> codeSearch(String string) {
		book b;
		ArrayList<book>results=new ArrayList<book>();
		for(int i=0 ;i<books.size();i++) {
			if(books.get(i).code.contains(string)) {
				b=books.get(i);
				results.add(b);
			}
			
			if(books.get(i).auther.contains(string)) {
				b=books.get(i);
				results.add(b);
			}
			
			if(books.get(i).title.contains(string)) {
				b=books.get(i);
				results.add(b);
			}
			
		}
		
		return results;

		
	}

	
	

	public boolean isContained(String string, String string2, String string3) {
		boolean found =false;
		for (int i=0;i<books.size();i++) {
			if(books.get(i).title.equals(string) && books.get(i).auther.equals(string2) && books.get(i).code.equals(string3) )
				found= true;
		
			else 
				found= false;
		}
		return found;
					
	}
	
	public void setFine(int x) {
		
		fine=x;
	}
	
	public  int getFine() {
		return fine;
	}
	
	public boolean checkUser(user u) {
		//boolean f=false;
		for (int i=0;i<registeredUsers.size();i++) {
			if (registeredUsers.get(i).ID.equals(u.ID)) {
				//f=true;
				return true;
			}
		}
		
			JOptionPane.showInternalMessageDialog(null, "This user is not registered", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		
	}
	
	public boolean borrow(book b,user u) {
		
		boolean f=checkUser(u);
		if(f) {
			f=lateBooks(u, 21);
			if(f==false) {
				if(u.countFine(getFine())!=0) {
					JOptionPane.showInternalMessageDialog(null, "Cant borrow book,you have fines", "Error", JOptionPane.ERROR_MESSAGE);
					return false;
					}
				f=u.borrow(b, books,borrowed);
				return f;
			}
			else return false;
		}
		
		else {	
			return f;
		}
	}
	
	
	
	public boolean lateBooks(user u,int day) {
		LocalDate today=date.getDate();
		Duration diff;
		long difference;
		ArrayList<book>x=new ArrayList<book>();
		if(borrowed.containsKey(u.ID)) {
			x=borrowed.get(u.ID);
			for(int i=0;i<x.size();i++) {
				diff=Duration.between( x.get(i).borrowingDate.atStartOfDay(),today.atStartOfDay());
				difference=diff.toDays();
				
				if(difference ==day || difference > day) {
					u.lateBooks++;
					return true;
				}
			}
		}
		return false;
		
	}
 
}
