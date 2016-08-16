package Beans;

public class RegisterBean { // The Bean Used for registration details
	
	
	

	private String uname,pass,fname,mail,rpass;

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

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getRpass() {
		return rpass;
	}

	public void setRpass(String rpass) {
		this.rpass = rpass;
	}
	
	
	
	
}
