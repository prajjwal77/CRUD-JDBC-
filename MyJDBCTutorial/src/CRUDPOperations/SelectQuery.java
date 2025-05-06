package CRUDPOperations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import inJDBCUtil.JDBCUtil;

public class SelectQuery {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Scanner scan = new Scanner(System.in);
		try {
			connection = JDBCUtil.getJdbcConnection();
					
			if(connection!=null) {
				String mysqlQuery = "select * from student where id = ?";
				preparedStatement = connection.prepareStatement(mysqlQuery);
				
				if(preparedStatement != null) {
					System.out.println("Enter the id which you want to ge from database of MYSQL. ");
					int id = scan.nextInt();
					preparedStatement.setInt(1, id);
					
					resultSet = preparedStatement.executeQuery();
					
					if(resultSet != null) {
						if(resultSet.next()) {
							System.out.println("Id\tName\t\tRollNo\t\tResult");
							System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t\t"+resultSet.getString(4));
						}
					}
				}
			}
		}catch (IOException | SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				JDBCUtil.cleanUp(connection, preparedStatement, resultSet);
				scan.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
}
