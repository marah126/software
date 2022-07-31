package softwareProject;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class admin {

	boolean logState;
	String password;
	
	
	public admin() {
		password="adminadmin";
		logState=false;
	}
	
	public void setLogState(boolean b) {
		// TODO Auto-generated method stub
		logState=b;
	}

	
	public boolean login(String pass) {
		// TODO Auto-generated method stub
		if(logState) {
			System.out.println("you are already logged in");
			return false;
		}
		else {
			if(this.password.equals(pass)) {
				System.out.println("successfull log in");
				logState=true;
				return true;
		
			}
			else {
				System.out.println("wrong password");
				return false;
			}
		}
	}

	public boolean getLogState() {
		if(logState) {
			//System.out.println("you are logged in now ");
		}
		//else
			//System.out.println("you are not logged in ");
		return logState;
	}

	public void logout() {
		// TODO Auto-generated method stub
		if(logState ==false ) {
		//	System.out.println("you are not logged in, you should log in first to log out ");
		}
		else {
			logState=false;
			//System.out.println("log out successfull");

		}
		
	}
	
	public String register(user u,myLibrary l) {
		//myLibrary l =new myLibrary();
		if(logState==false) {
			
			JOptionPane.showInternalMessageDialog(null, "Admin login is required", "Error", JOptionPane.ERROR_MESSAGE);
			return "Admin login is required";
		}
		else {
			for(int i=0;i<l.registeredUsers.size();i++) {
				if(u.ID.equals(l.registeredUsers.get(i).ID)) {
					JOptionPane.showInternalMessageDialog(null, "user is alreay registered", "Error", JOptionPane.ERROR_MESSAGE);

					return "user is alreay registered";
				}
			}
			l.registeredUsers.add(u);
			JOptionPane.showInternalMessageDialog(null, "user registered succefully", "success", JOptionPane.INFORMATION_MESSAGE);

			return "user registered succefully";
		}
		
	}
	

}
