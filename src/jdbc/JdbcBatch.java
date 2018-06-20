package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcBatch {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
	
		String query1="insert into jdbc.mytable(name,email) values('simran','simmi2@gmail.com')";
		String query2="insert into jdbc.mytable(name,email) values('varun','vrer54@gmail.com')";
		String query3="delete from jdbc.mytable where email='vrer54@gmail.com'";
		String query4="insert into jdbc.mytable(name,email) values('pratik','pp22@yahoo.com')";
		try {
	
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			st=con.createStatement();
			st.addBatch(query1);
			st.addBatch(query2);
			st.addBatch(query3);
			st.addBatch(query4);
			st.executeBatch();
			System.out.println("Tables Updated");
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			if(st!=null) {
				try {
					st.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
