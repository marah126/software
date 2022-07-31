package softwareProject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import io.cucumber.java.it.Date;

//import testing.book;

public class user {
	String ID;
	String Name;
	String email;
	String address;
	String postal_code;
	String city;
	int lateBooks;
	
	
	public user() {
		System.out.println();
	}
	
	public user(String id,String name,String e,String add,String postal,String c) {
		ID=id;
		Name=name;
		email=e;
		address=add;
		postal_code=postal;
		city=c;
		lateBooks=0;
		//fine=0;
	}
	
	public boolean borrow(book b,ArrayList<book> books,Hashtable<String, ArrayList<book>> table) {
		//myLibrary l=new myLibrary();
		boolean user=false;
		boolean book=false;
		DateServer d=new  DateServer();
		book xx;
		//DateServer date = new DateServer;
		/*for (int i=0;i<myLibrary.registeredUsers.size();i++) {
			if (myLibrary.registeredUsers.get(i).ID.equals(this.ID)) {
				user=true;
				break;
			}
		}
		if(user==false) {
			JOptionPane.showInternalMessageDialog(null, "This user is not registered", "Error", JOptionPane.ERROR_MESSAGE);
			return false;*/
		
		
			for(int i=0;i<books.size();i++) {
				xx=books.get(i);
				if(b.code.equals(xx.code)==true) {
				book=true;
				break;
			}
			}
			if(book==false) {
				JOptionPane.showInternalMessageDialog(null, "This book is not available in the library", "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else {
				if(b.borrowed==true) {
					JOptionPane.showInternalMessageDialog(null, "you cant borrow this book because it is borrowed by some one else", "Error", JOptionPane.ERROR_MESSAGE);
					return false;
				}
				else {
					ArrayList<book>bb=new ArrayList<book>();
					if(table.containsKey(this.ID)==false) {
						bb.add(b);
						table.put(this.ID, bb);
						b.borrowed=true;
						b.borrowingDate=d.getDate();
						JOptionPane.showInternalMessageDialog(null, "user borrowed the book successfully", "success", JOptionPane.INFORMATION_MESSAGE);

						return true;
					}
					else {
						bb=table.get(this.ID);
						if(bb.size()==5) {
							JOptionPane.showInternalMessageDialog(null, "Sorry, this user borrowed 5 books the maximum allowed number", "Error", JOptionPane.ERROR_MESSAGE);
							return false;
						}
						else {
						bb.add(b);
						table.put(this.ID, bb);
						b.borrowed=true;
						b.borrowingDate=d.getDate();
						JOptionPane.showInternalMessageDialog(null, "user borrowed the book successfully", "success", JOptionPane.INFORMATION_MESSAGE);
						return true;
					}
					
				}
					
			}
			
		}
		//return user;
		
	
	}
	
	
	public String returnBook(book b,myLibrary l){
		ArrayList<book>w ;
		boolean f=false;
		for(int i=0;i<l.registeredUsers.size();i++) {
			
			if(this.ID.equals(l.registeredUsers.get(i).ID)) {
				f=true;
				if(l.borrowed.containsKey(this.ID)) {
					w=l.borrowed.get(this.ID);
					for(int j=0;j<w.size();j++) {
						if(b.code.equals(w.get(j).code)) {
							w.remove(i);
							b.borrowed=false;
							l.borrowed.put(this.ID, w);
							JOptionPane.showInternalMessageDialog(null, "user returned the book successfully", "success", JOptionPane.INFORMATION_MESSAGE);
							return " user returned the book successfully";
						}
						
					}
					
				}return "this book is not borrowed by you";
			}
		}
		if(f==false) {
		return "this user is not registered";
		}
		else
			return " " ;
	
		
		}
	
	public int countFine(int x) {
		int fine=lateBooks*x;
		return fine;
	}
	}


	

