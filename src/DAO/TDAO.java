package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import Beans.HomeTweetBean;
import Beans.MyTweetsBean;
import Beans.TweetBean;
import java.util.Map;

public class TDAO {  						// This is the Tweets and following DAO

	Connection con = null;
	Connection con2=null;
	PreparedStatement ps = null;
	
	
	public TDAO() // Constructor initializes the Connection Object

	{
		try {

			con = ConnectionManager.getConnection(); // Getting a static connection object

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public String insertTweet(TweetBean tb) // Used to insert a tweet from a user
	{
		try{
			
			Date date = new Date();
			Timestamp t = new Timestamp(date.getTime());
		ps=con.prepareStatement("insert into tweet (user_id,created,message,tweet_id)values (?,?,?,? )");
		ps.setString(1,tb.getUname());
		ps.setTimestamp(2,t);
		ps.setString(3,tb.getTweet());
		ps.setInt(4,00 );
		ps.execute();
		
		return "success";
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return "error";
		}
		finally{
			
			try{
				if(ps !=null)
					ps.close();
					if(con!=null)
					con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public String follow(String uname, String funame) // Used to add the users to follow
	{
		try{
		ps=con.prepareStatement("insert into following (user_id,following_id) values (?,?)");
		ps.setString(1,uname);
		ps.setString(2, funame);
		if(ps.execute())
			return "success";
		return "error";
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return "error";
		}
finally{
			
			try{
				if(ps !=null)
					ps.close();
					if(con!=null)
					con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
	}

	public String unfollow(String uname, String fname)  //Used to unfollow a following user 
	{ 
		try{
		ps=con.prepareStatement("delete from following where user_id=? and following_id=?");
		ps.setString(2, uname);
		ps.setString(1, fname);
		ps.executeUpdate();
		return "success";
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return "error";
		}
		finally{
			try{
				if(ps !=null)
					ps.close();
					if(con!=null)
					con.close();
			}catch(SQLException e1)
			{
				e1.printStackTrace();
			}
		}
	}
	
	public MyTweetsBean getMyTweets(String uname) // To Get MyTweets To Edit

	{
		ResultSet rs;
		
		ArrayList<String> t_id =new ArrayList<String>();
		MyTweetsBean mtb=new MyTweetsBean();
		String message;
		Map<String,String> myTweets=new HashMap<String, String>();
		try{
		ps=con.prepareStatement("select tweet_id,user_id,message,created from tweet where user_id=? order by tweet_id desc");
		ps.setString(1,uname);
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			t_id.add(rs.getString("tweet_id"));
			message=rs.getString("message");
			myTweets.put(rs.getString("tweet_id"), message);
			
		}
		mtb.setMyTweets(myTweets);
		mtb.setT_id(t_id);
		
		return  mtb;
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return mtb;
		}
		finally{
			try{
				if(ps !=null)
					ps.close();
					if(con!=null)
					con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public String deleteTweet(String t_id)   //Used to delete the selected tweet of a user
	{
		try{
			ps=con.prepareStatement("delete from tweet where tweet_id=?");
			ps.setInt(1,Integer.parseInt(t_id));
			if(ps.executeUpdate()>0)
				return "success";
			else
				return "error";
			
		}catch(SQLException e)
		{
			e.printStackTrace();
			return "error";
			
		}
		finally{
			
			try{
				if(ps !=null)
					ps.close();
					if(con!=null)
					con.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		
	}

	public String editTweet(String t_id, String message) // Used to edit a particular tweet of user
	{
		try{
			ps=con.prepareStatement("update tweet set message=? where tweet_id=?");
			ps.setString(1, message);
			ps.setInt(2, Integer.parseInt(t_id));
			if(ps.executeUpdate()>0)
			{
				return "success";
			}
			else
			{
				return "error";
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return "error";
		}
		finally{
			try{
				if(ps !=null)
					ps.close();
					if(con!=null)
					con.close();
			}catch(SQLException e1)
			{
				e1.printStackTrace();
			}
		}
	}

	public HomeTweetBean getAllTweets(String uname)  // used to dynamically show the user and tweets of people he is following
	{
		HomeTweetBean htb=new HomeTweetBean();
		try{
			Class.forName("oracle.jdbc.OracleDriver");
    		String url="jdbc:oracle:thin:@localhost:1521:xe";
    		con2=DriverManager.getConnection(url,"twitter","demo");
    		
			ResultSet rs;
			ps=con2.prepareStatement("select user_id,message,created from tweet where user_id=? OR user_id in (select user_id from following where following_id=? ) order by tweet_id desc");
			ps.setString(1, uname);
			ps.setString(2, uname);
			rs=ps.executeQuery();
			ArrayList<String> unamel = new ArrayList<String>();
			ArrayList<String> message = new ArrayList<String>();
			ArrayList<String> timestamp = new ArrayList<String>();
			while(rs.next())
			{
				unamel.add((rs.getString("user_id")));
				message.add((rs.getString("message")));
				timestamp.add((rs.getTimestamp("created")).toString());
			}
			
			htb.setMessage(message);
			htb.setTimestamp(timestamp);
			htb.setUname(unamel);
			return htb;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return htb;
		}
		catch(ClassNotFoundException w)
		{
			w.printStackTrace();
			return htb;
		}
		finally{
			
			try{
				if(ps !=null)
					ps.close();
				if(con2!=null)
					con2.close();
				
			}catch(SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		
	}
}




