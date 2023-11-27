package jdbcc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnector {
	public static Connection getConnection()
	{  
		Connection con=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost/propertyassist","root","");
		    System.out.println("Successfull!");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
		
	}	
		public static void main(String[] args) 
		{
	
		// TODO Auto-generated method stub
        getConnection();
	    }
}