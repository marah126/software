package softwareProject;

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
			System.out.println("you are logged in now ");
		}
		else
			System.out.println("you are not logged in ");
		return logState;
	}

	public void logout() {
		// TODO Auto-generated method stub
		if(logState ==false ) {
			System.out.println("you are not logged in, you should log in first to log out ");
		}
		else {
			logState=false;
			System.out.println("log out successfull");

		}
		
	}
	

}
