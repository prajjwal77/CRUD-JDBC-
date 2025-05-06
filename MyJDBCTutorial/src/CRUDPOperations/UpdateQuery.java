package CRUDPOperations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import inJDBCUtil.JDBCUtil;

public class UpdateQuery {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
			 
			try {
				connection = JDBCUtil.getJdbcConnection();
				if(connection!=null) {
					Scanner scan = new Scanner(System.in);
					String mysqlQuery = "update student set result=? where id = ? ";
					preparedStatement = connection.prepareStatement(mysqlQuery);
					if(preparedStatement!=null) {
						System.out.println("Enter the id which you want to update result : ");
						int id = scan.nextInt();
						
						System.out.println("Enter the updated reslut : ");
						String result = scan.next();
						
						
						preparedStatement.setString(1, result);
						preparedStatement.setInt(2, id);
						
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
