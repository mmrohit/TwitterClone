package DAO;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {

static Connection con=null;
 static Connection con2=null;
	
	
	public static Connection getConnection() throws SQLException		// To create a connection that can be used in any DAO
	{
		try{
			Class.forName("oracle.jdbc.OracleDriver");						
    		String url="jdbc:oracle:thin:@localhost:1521:xe";
    		con=DriverManager.getConnection(url,"twitter","demo");
    	    		
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		if(con==null)													// In case the con expires return a new con
		{
			try{
			Class.forName("oracle.jdbc.OracleDriver");
    		String url="jdbc:oracle:thin:@localhost:1521:xe";
			con2=DriverManager.getConnection(url,"twitter","demo");
		}catch(ClassNotFoundException e )
		{
			e.printStackTrace();
		}
		}
		return con;
	}//get connection method
	
}// ConnectionManager class
