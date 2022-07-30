package softwareProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
	public static void main(String args[]) {
		myLibrary l=new myLibrary();
		user test=new user("1234567", "Marah", "marah@gmail.com", "AlQuds street", "M5M2T5", "Nablus");
		l.registeredUsers.add(test);
		test=new user("1478523", "Sarah", "sarah@gmail.com", "Masaken", "S3S1T5", "Nablus");
		l.registeredUsers.add(test);
		book test2=new book("XP Programming Book", "Kent Beck", "Kent99" );
		l.books.add(test2);
		test2=new book("C++ Development", "Alu and Sami","Alu07" );
		l.books.add(test2);
		user u=new user();
		book b=new book();
		admin admin=new admin();
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));  
		while(true) {
			System.out.print("Please choose are you? "+"\n");
			System.out.print("1- User"+"\n");
			System.out.print("2- Admin "+"\n");
			System.out.print("3- Exit "+"\n");
			Scanner choice = new Scanner(System.in);
      		int a = choice.nextInt();
      		if(a==2) {
    			System.out.print("Please Enter the password:"+"\n");
    			String pass;
    			pass=choice.next();
    			if(admin.login(pass)) {
    				inter:while(true) {
    					
    		 	        System.out.print("1- Register user "+"\n");
    		 	        System.out.print("2- Search book "+"\n");
    		 	        System.out.print("3- Add book "+"\n");
    		 	        System.out.print("4- Unregister user "+"\n");
    		 	        System.out.print("5- print all registered user "+"\n");
    		 	        System.out.print("6- print all books in the library "+"\n");
    		 	        System.out.print("7- Back to main menue "+"\n");
    		 	       
    		 	        int aa;
    		 	        aa=choice.nextInt();
    		 	        
    		 	        switch(aa) {
    		 	        
    		 	        case 1:
    		 	        	System.out.print("please enter the user ID, name, email, address,postal code and city respectively and seperated by space:\n");
    		 	        	try {
    		 	        	String s=obj.readLine();
    		 	        	String ss[]=s.split(" ");
    		 	        	u=new user(ss[0],ss[1],ss[2],ss[3],ss[4],ss[5]);
    		 	        	System.out.println(admin.register(u, l));
    	
    		 	         }catch(Exception e) {
    		 	        	 e.printStackTrace();
    		 	         }
    		 	        	break;
    		 	        	
    		 	        case 2:
    		 	        	System.out.println("enter the string to search by:\n");
    		 	        	String st=choice.next();
    		 	        	ArrayList<book>bb;
    		 	        	bb=l.codeSearch(st);
    		 	        	if(bb.size()==0) {
    		 	        		System.out.println("no books found");
    		 	        	}
    		 	        	else {
    		 	        		System.out.println("these books found:");
	    		 	        	for(int i=0; i<bb.size();i++) {
	    		 	        		System.out.println("title="+bb.get(i).title+" auther="+bb.get(i).auther+" code="+bb.get(i).code);
	    		 	        	}
    		 	        	}
    		 	       
    		 	        break;
    		 	        
    		 	        case 3:
    		 	        	System.out.println("please enter book name,auther and code respectively and seperated by space:\n");
    		 	        	try {
    		 	        		String book=obj.readLine();
    		 	        		String arrBook[]=book.split(" ");
    		 	        		b=new book(arrBook[0],arrBook[1],arrBook[2]);
    		 	        		l.add(b, admin);
    		 	        		
    		 	        	}catch(Exception e) {
    		 	        		e.printStackTrace();
    		 	        	}
    		 	        	
    		 	        	break;
    		 	        	
    		 	        case 4:
    		 	        	System.out.println("enter the user id:\n");
    		 	        	String id=choice.next();
    		 	        	u=new user(id,"","","","","");
    		 	        	if(l.checkUser(u)) {
	    		 	        	for(int i=0;i<l.registeredUsers.size();i++) {
	    		 	        		if(l.registeredUsers.get(i).ID.equals(id))
	    		 	        			u=l.registeredUsers.get(i);
	    		 	        	}
	    		 	        	l.unregister(admin, u);
    		 	        	}else System.out.println("This user is not registered before in the library");
    		 	        		
    		 	        	l.unregister(admin, u);
    		 	        	break;
    		 	        	
    		 	        case 5:
    		 	        	for(int i=0;i<l.registeredUsers.size();i++) {
    		 	        		System.out.println(l.registeredUsers.get(i).ID+" "+l.registeredUsers.get(i).Name+" "+l.registeredUsers.get(i).email+" "+
    		 	        				l.registeredUsers.get(i).address+" "+l.registeredUsers.get(i).postal_code+" "+l.registeredUsers.get(i).city+" ");
    		 	        	}
    		 	        	
    		 	        	break;
    		 	        	
    		 	        case 6:
    		 	        	for(int i=0;i<l.books.size();i++){
    		 	        		System.out.println("title="+l.books.get(i).title+" auther="+l.books.get(i).auther+" code="+l.books.get(i).code);
    		 	        	}
    		 	        	break;
    		 	        	
    		 	       case 7:
    		 	    	   admin.setLogState(false);
   		 	        	break inter;
   		 	        	
    		 	        }
    				}
    			}
      		}else if(a==1) {
      			Scanner choice2 = new Scanner(System.in);
      			 System.out.print("Enter your ID"+"\n");
      			 String id=choice2.next();
      			 u=new user(id,"","","","","");
      			 if(l.checkUser(u)) {
      				 for(int i=0;i<l.registeredUsers.size();i++) {
      					 if(l.registeredUsers.get(i).ID.equals(id))
      						 u=l.registeredUsers.get(i);
      				 }
      				 
      				 label:while(true) {
		      				 System.out.print("please choose a number:"+"\n");
		      				 System.out.print("1- Borrow book "+"\n");
		         	         System.out.print("2- Return book "+"\n");
		         	         System.out.print("3- Search book "+"\n");
		         	        System.out.print("4- print all books i have borrowed "+"\n");
		         	        System.out.print("5- Back to main menue "+"\n");
		         	        
		    	      		 int x = choice2.nextInt();
		    		    switch (x) {
		    		    case 1:
		    		    	boolean r=false;
		    		    	System.out.print("enter the book code:\n");
		    		    	String code=choice2.next();
		    		    	for(int i=0;i<l.books.size();i++) {
		    		    		if(l.books.get(i).code.equals(code)) {
		    		    			r=true;
		    		    			b=l.books.get(i);
		    		    		}	
		    		    	}
		    		    	if(r==false)
		    		    		b=new book("","",code);
		    		    	
		    		        l.borrow(b, u);
		    		        
		    		        break;
		    		        
		    		    case 2:
		    		    	System.out.print("enter the book code:\n");
		    		    	String codd=choice2.next();
		    		    	b=new book("","",codd);
		    		    	u.returnBook(b, l);
		    		    	
		    		    	break;
		    		    	
		    		    case 3:
		    		    	System.out.println("enter the string to search by:\n");
			 	        	String st=choice.next();
			 	        	ArrayList<book>bb;
			 	        	bb=l.codeSearch(st);
			 	        	if(bb.size()==0) {
			 	        		System.out.println("no books found");
			 	        	}
			 	        	else {
			 	        		System.out.println("these books found:");
				 	        	for(int i=0; i<bb.size();i++) {
				 	        		System.out.println("title="+bb.get(i).title+" auther="+bb.get(i).auther+" code="+bb.get(i).code);
				 	        	}
			 	        	}
			 	        	
			 	        	break;
			 	        	
		    		    case 4:
		    		    	ArrayList<book>z=new ArrayList<book>();
		    		    	boolean f=l.borrowed.containsKey(u.ID);
		    		    	if(f==false)
		    		    		System.out.println("you dont have boroowed books");
		    		    	else {
		    		    		z=l.borrowed.get(u.ID);
			    		    	for(int i=0;i<z.size();i++) {
			    		    		System.out.println("title="+z.get(i).title+" auther="+z.get(i).auther+" code="+z.get(i).code);
			    		    	}
		    		    	}
		    		    	break;
			 	        	
		    		    case 5:
		    		    	break label;
		    		    }//switch
      				 }//while
      			 }//user
      			 else
      				System.out.print("you are not register in the library"+"\n");
      			 
      			
      		}
      		else if(a==3) {
      			java.lang.System.exit(0);
      		}
      		else {
    			System.out.print("Incorrect input"+"\n");
    				
      		}
 			
		}
	}

}
