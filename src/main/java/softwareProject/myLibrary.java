package softwareProject;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class myLibrary {

	public ArrayList<book> books =new ArrayList<book>();
	public static ArrayList<user>registeredUsers =new ArrayList<user>();
	
	public static Hashtable<String,ArrayList<book>>borrowed=new Hashtable<String, ArrayList<book>>();
	book b,c,d;
	
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

}
