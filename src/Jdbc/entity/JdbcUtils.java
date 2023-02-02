package Jdbc.entity;
import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtils {

	public static Connection obtainConnection() throws Exception
	{
		String driverClassName="com.mysql.cj.jdbc.Driver";
		Class.forName(driverClassName);
		
		String URL="jdbc:mysql://localhost:3306/java?useSSL=false";
		String UID="root";
		String PWD="root";
		
		Connection dbConnection=DriverManager.getConnection(URL,UID,PWD);
		return dbConnection;
	}
}
