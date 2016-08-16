package Beans;

import java.util.ArrayList;

public class HomeTweetBean {       // The Bean Used To Display Tweets On Home Page

	ArrayList<String> uname,message,timestamp;

	public ArrayList<String> getUname() {
		return uname;
	}

	public void setUname(ArrayList<String> uname) {
		this.uname = uname;
	}

	public ArrayList<String> getMessage() {
		return message;
	}

	public void setMessage(ArrayList<String> message) {
		this.message = message;
	}

	public ArrayList<String> getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(ArrayList<String> timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
