package Beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyTweetsBean {  // The bean that contains only users tweets in order to perform edit and delete operations

	private Map<String,String> myTweets= new HashMap<String, String>(); 
	private ArrayList<String> t_id;
	
	public Map<String, String> getMyTweets() {
		return myTweets;
	}
	public void setMyTweets(Map<String, String> myTweets) {
		this.myTweets = myTweets;
	}
	public ArrayList<String> getT_id() {
		return t_id;
	}
	public void setT_id(ArrayList<String> t_id) {
		this.t_id = t_id;
	}
	
}
