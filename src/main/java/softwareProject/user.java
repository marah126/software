package softwareProject;

import java.util.ArrayList;

import javax.swing.JOptionPane;

//import testing.book;

public class user {
	String ID;
	String Name;
	String email;
	String address;
	String postal_code;
	String city;
	
	
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
	}
	
	public boolean borrow(book b,myLibrary l) {
		//myLibrary l=new myLibrary();
		boolean user=false;
		boolean book=false;
		book xx;
		for (int i=0;i<myLibrary.registeredUsers.size();i++) {
			if (myLibrary.registeredUsers.get(i).ID.equals(this.ID)) {
				user=true;
				break;
			}
		}
		if(user==false) {
			JOptionPane.showInternalMessageDialog(null, "This user is not registered", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else {
			for(int i=0;i<l.books.size();i++) {
				xx=l.books.get(i);
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
					if(myLibrary.borrowed.containsKey(this.ID)==false) {
						bb.add(b);
						myLibrary.borrowed.put(this.ID, bb);
						b.borrowed=true;
						JOptionPane.showInternalMessageDialog(null, "user borrowed the book successfully", "success", JOptionPane.INFORMATION_MESSAGE);

						return true;
					}
					else {
						bb=myLibrary.borrowed.get(this.ID);
						if(bb.size()==5) {
							JOptionPane.showInternalMessageDialog(null, "Sorry, this user borrowed 5 books the maximum allowed number", "Error", JOptionPane.ERROR_MESSAGE);
							return false;
						}
						else {
						bb.add(b);
						myLibrary.borrowed.put(this.ID, bb);
						b.borrowed=true;
						JOptionPane.showInternalMessageDialog(null, "user borrowed the book successfully", "success", JOptionPane.INFORMATION_MESSAGE);
						return true;
					}
					
				}
					
			}
			
		}
		//return user;
		
	}
	}
	
	
	public String returnBook(book b,myLibrary l){
		ArrayList<book>w ;
		for(int i=0;i<myLibrary.registeredUsers.size();i++) {
			
			if(this.ID.equals(myLibrary.registeredUsers.get(i).ID)) {
				
				if(myLibrary.borrowed.containsKey(this.ID)) {
					w=myLibrary.borrowed.get(this.ID);
					for(int j=0;j<w.size();j++) {
						if(b.code.equals(w.get(j).code)) {
							w.remove(i);
							b.borrowed=false;
							myLibrary.borrowed.put(this.ID, w);
							JOptionPane.showInternalMessageDialog(null, "user returned the book successfully", "success", JOptionPane.INFORMATION_MESSAGE);
							return " user returned the book successfully";
						}
						
					}
					return "this book is not borrowed by you";
				}
			}
		}
		return "this user is not registered";
		
	
		
		}
	}


	

