package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

public class simpleprogram {

	public static void main(String[] args) {
		//load the driver
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		
		String url = "jdbc:mysql://localhost:3306/zomato";
		String uid = "root";
		String pwd = "password";
		
		Connection dbConnection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			Class.forName(driverClassName);
			System.out.println("DRIVER loaded");
			//Establish connection
		 dbConnection= DriverManager.getConnection(url,uid,pwd);
			System.out.println("connected to db");
			
			//obtain some statements
			 stmt = dbConnection.createStatement();
			System.out.println("obtain the statement");
			
			//Execute the query
			String sqlQuery=
					"select rest_name,rest_branch_count ,rest_cuisine from  restaurant_master";
		     rs = stmt.executeQuery(sqlQuery);
			System.out.println("execute the sql SELECT query and obtained resultset");
			
			//in case of execute the sql SELECT query,obtain resultset and perform navigation
			while(rs.next())
			{
				String restaurantName = rs.getString(1);
				int branchCountCuisine = rs.getInt(2);
				String restaurantCuisine = rs.getString(3);
				System.out.println(restaurantName + ":" + branchCountCuisine +":"+restaurantCuisine);
				
				
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("unable to load the driver");
		}
		finally {
			//closing all the resources : resultset,connection,statements
			try {
				rs.close();
				stmt.close();
				dbConnection.close();
			}
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	}

}
