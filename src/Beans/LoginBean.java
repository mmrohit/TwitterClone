package Beans;

public class LoginBean {   // The Bean Used for Authentication

	private String uname;
	private String pass;
	
	

	
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname.toLowerCase();
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
	
	
