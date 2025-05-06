package CRUDPOperations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import inJDBCUtil.JDBCUtil;

public class InsertmysqlQuery {
	public static void main(String[] args) {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
		 
		try {
			connection = JDBCUtil.getJdbcConnection();
			if(connection!=null) {
				String mysqlQuery = "insert into student(name,rollnum,result) values(?,?,?)";
				preparedStatement = connection.prepareStatement(mysqlQuery);
				if(preparedStatement!=null) {
					
					preparedStatement.setString(1, "Prajjwal");
					preparedStatement.setInt(2, 1234);
					preparedStatement.setString(3, "Pass");
					
					int rowaffected = preparedStatement.executeUpdate();
					
					if(rowaffected == 1) {
						System.out.println("Row inserted...");
					}else {
						System.out.println("Row not inserted...");
					}
					
				}
			}
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBCUtil.cleanUp(connection,preparedStatement,null);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
