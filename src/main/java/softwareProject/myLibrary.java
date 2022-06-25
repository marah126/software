package softwareProject;

import java.util.ArrayList;

public class myLibrary {

	ArrayList<book> books =new ArrayList<book>();

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

	public void print() {
		System.out.println(books.size());
		
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
