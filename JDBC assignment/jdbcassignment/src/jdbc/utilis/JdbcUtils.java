package jdbc.utilis;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtils {
	//This is a utility class for obtaining a Connection and returning the same.
	public static Connection getConnection() throws Exception {
		//Here, 'Class.forName()' is not used because it is not needed.
		//The driver gets loaded automatically.
		String url = "jdbc:mysql://localhost:3306/artical_master";
		String uid = "root";
		String pwd = "tanmay123";
		Connection dbConnection = 
				DriverManager.getConnection(url, uid, pwd);
		return dbConnection;
	}
}