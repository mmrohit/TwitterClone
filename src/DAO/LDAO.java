package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.LoginSuccessBean;

public class LDAO {
	
	LoginSuccessBean lsb=new LoginSuccessBean();
	Connection con = null;
	PreparedStatement ps = null;
	int nfr,nfg;
		public LoginSuccessBean prepareLoginSuccessBean(String uname)
	{
			
			try {

				con = ConnectionManager.getConnection(); // Getting a static connection object

			} catch (SQLException e) {
				e.printStackTrace();
				return lsb;
			}
			
			
			
		lsb.setUname(uname);
		lsb.setTcount(this.tweetNo(uname));
		nfr=this.noOfFollowers(uname);
		lsb.setNfr(nfr);
		nfg=this.noOfFollowing(uname);
		lsb.setNfg(nfg);
		lsb.setFollowers(this.setFollowers(uname));
		lsb.setFollowing(this.setFollowing(uname));
		 
		return this.lsb;
		
	}
	public int noOfFollowers(String uname)
	{
		try{
			ResultSet rs;		
			ps=con.prepareStatement("select count(user_id) as count from FOLLOWING where user_id=?");
			ps.setString(1, uname);
			rs=ps.executeQuery();
			if(rs.next())
				return rs.getInt("count");
			return 0;
			
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					return 0;
					
				}
			
				
			}
	public int tweetNo(String uname)   // To retrieve no. of tweets of a user
	{
try{
	ResultSet rs;		
	ps=con.prepareStatement("select count (user_id) as count from TWEET where user_id=?");
	ps.setString(1, uname);
	rs=ps.executeQuery();
	if(rs.next())
		return rs.getInt("count");
	return 0;
	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return 0;		
	}
	}
	public int noOfFollowing(String uname)
	{
		try{
			ResultSet rs;		
			ps=con.prepareStatement("select count(user_id) as count from FOLLOWING where following_id=?");
			ps.setString(1, uname);
			rs=ps.executeQuery();
			if(rs.next())
				return rs.getInt("count");
			return 0;
			
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					return 0;
			
			}
	}
	public String[] setFollowers(String uname){
		String[] followers=new String[nfr];
		try{
			
			ResultSet rs;		
			ps=con.prepareStatement("select following_id from Following where user_id=?");
			ps.setString(1, uname);
			rs=ps.executeQuery();
			
			int i=0;
			while(rs.next())
				
			{
				followers[i++]=rs.getString("following_id");
				
			}//while
			return followers;
			
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					return followers;
			
				
			}
	
		
	}
	public String[] setFollowing(String uname)
	{
		String[] following=new String[nfg];
			try{
				ResultSet rs;
						
				ps=con.prepareStatement("select user_id from Following where following_id=?");
				ps.setString(1, uname);
				rs=ps.executeQuery();
				
				int i=0;
				while(rs.next())
					
				{
					following[i++]=rs.getString("user_id");
					
				}//while
				return following;
				
					}
					catch(SQLException e)
					{
						e.printStackTrace();
						return following;
						
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
}