package CRUDPOperations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import inJDBCUtil.JDBCUtil;

public class DeleteQuery {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
			 
			try {
				connection = JDBCUtil.getJdbcConnection();
				if(connection!=null) {
					Scanner scan = new Scanner(System.in);
					String mysqlQuery = "delete from student where id = ? ";
					preparedStatement = connection.prepareStatement(mysqlQuery);
					if(preparedStatement!=null) {
						System.out.println("Enter the id which you want to delete : ");
						int id = scan.nextInt();
						
						
						preparedStatement.setInt(1, id);
						
						int rowaffected = preparedStatement.executeUpdate();
						
						if(rowaffected == 1) {
							System.out.println("Row Deleted...");
						}else {
							System.out.println("Row not Deleted...");
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
