package inJDBCUtil;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
	//task to get the properties from the application file and loading the driver with connection
	public static Connection getJdbcConnection() throws IOException,SQLException{
		FileInputStream FIS=new FileInputStream("Application.properties");// importing the file 
		Properties P=new Properties();//use to acquiring the properties of the file
		P.load(FIS);
		String url=P.getProperty("url");
		String user= P.getProperty("user");
		String password=P.getProperty("password");
		
		System.out.println(url);
		System.out.println(user);
		System.out.println(password);
		
		Connection connection =DriverManager.getConnection(url,user,password);
		return connection;
	}
public  static  void cleanUp(Connection connection ,PreparedStatement  statement,ResultSet resultset) throws SQLException {
	if(connection!=null) {
		connection.close();
		} if (statement!=null) {
			statement.close();
			}if(resultset!=null) {
				resultset.close();
			}
 	}

}
