package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import Beans.LoginBean;
import Beans.RegisterBean;
import Beans.UpdateBean;
import Beans.UserDataBean;

public class DAO{

	Connection con = null;
	PreparedStatement ps = null;

	public DAO() // Constructor initializes the Connection Object

	{
		try {

			con = ConnectionManager.getConnection(); // Getting a static connection object

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public String insert(RegisterBean newuser)  // Used to register a new
     { 
													// twitter user
		try {
			Date date = new Date();
			Timestamp t = new Timestamp(date.getTime());
			ps = con.prepareStatement("insert into person (user_id,password,fullname,email,joined,active) values (?,?,?,?,?,?)");
			ps.setString(1, newuser.getUname());
			ps.setString(2, newuser.getPass());
			ps.setString(3, newuser.getFname());
			ps.setString(4, newuser.getMail());
			ps.setTimestamp(5, t);
			ps.setInt(6, 1);

			if (ps.execute()) {
				return "success"; // If registration has been added to Person Table
			}
		}// try
		catch (SQLException e) {
			e.printStackTrace();
			return "error"; // If username or email already exists
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return "success";
	}// Insert Operation Ends Here

	
	public String authenticate(LoginBean lb)  // Used to authenticate login information
	{
		try
		{
		ResultSet rs;
		ps=con.prepareStatement("select * from person where user_id=? AND password=?");
		ps.setString(1, lb.getUname());
		ps.setString(2, lb.getPass());
		rs=ps.executeQuery();
		if(rs.next())
			return "success";
		return "input";
	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return "input";
		}
		finally
		{
			try
			{
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
		
	}// Authenticate ends

	
	public String delete(String username) {		//Used when user wants to delete his account
		
		try{
			int i;
			ps=con.prepareStatement("delete from person where user_id=?");
			ps.setString(1, username);
			
			i=ps.executeUpdate();
			if(i>0)
				return "success";
			return "error";
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "error";
		}
		finally
		{
			try
			{
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

	
	public String update(UpdateBean ub) {           // Used to update the profile of User
		
		try{
				
		ps=con.prepareStatement("update person set email=?,fullname=?,password=? where user_id=?");
		ps.setString(1, ub.getMail());
		ps.setString(2, ub.getFname());
		ps.setString(3,ub.getNpass());
		ps.setString(4, ub.getUname());
		int i=ps.executeUpdate();
		if(i>0)
			return "success";
		else
			return "error";
		
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return "error";
		}
		finally{
			try
			{
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
	
	public UserDataBean getData(String uname){     // To populate Profile page in order to update
		try{
			UserDataBean udb=new UserDataBean();
			ps=con.prepareStatement("select fullname,email from person where user_id='"+uname+"'");
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				udb.setFullname(rs.getString("fullname"));
				udb.setEmail(rs.getString("email"));
			}
			
			return udb;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
			
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
	
	public boolean passCheck(String uname, String cpass) // To check for passwords where ever required
	{
		try{
		ResultSet rs;
		ps=con.prepareStatement("select password from person where user_id='"+uname+"'");
		rs=ps.executeQuery();
		if(rs.next())
		{
			if(rs.getString(1).equals(cpass))
				return true;
			else
				return false;
		}else
			return false;
	}catch(SQLException e)
	{
		e.printStackTrace();
		return false;
		
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

	public String getPass(String uname)				// Password required for re login update
	{
		try{
		ResultSet rs;
		ps=con.prepareStatement("select password from person where user_id=?");
		ps.setString(1, uname);
		rs=ps.executeQuery();
		if(rs.next())
		{
			
			return rs.getString("password");
		
		}
			return "Test";
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return "";
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
	ArrayList<String> result=new ArrayList<String>();
	public ArrayList<String> search(String key)			// Returns an array list of all the members who matches search pattern
	{
		try{
		ResultSet rs;
		ps=con.prepareStatement("select user_id from person where user_id like ? or (email like ? or fullname like ?) ");
				ps.setString(1, "%"+key+"%");
				ps.setString(2, "%"+key+"%");
				ps.setString(3, "%"+key+"%");
				rs=ps.executeQuery();
				
				while(rs.next())
				{
					
					result.add(rs.getString("user_id"));
				}
		
				return result;
		}catch(SQLException e)
		{
			e.printStackTrace();
			return result;
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
	

}