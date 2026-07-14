package DailyTaskSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectivity {
		
		public static Connection conn()
		{
			Connection con=null;
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/DailyTaskDatabase","root","anisha@123");
				
				if(con!=null)
				{
					System.out.println("Connected...");
				}
				else
				{
					System.out.println("Not connected.");
				}
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				
				e.printStackTrace();
			}
			return con;
		}

}
