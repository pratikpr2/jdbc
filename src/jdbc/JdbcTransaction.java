package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import utility.JdbcUtility;

public class JdbcTransaction {

	public static void main(String[] args) {
	
		Connection con = null;
		PreparedStatement pst=null;
		Savepoint save=null;
		
		String query = "insert into jdbc.mytable(name,email) values(?,?)";
		String query2= "insert into jdbc.mytable(name,email) values(?,?)";
		
		System.out.println("Enter Name: ");
		String name = JdbcUtility.userStringInput();
		System.out.println("Enter Email: ");
		String email = JdbcUtility.userStringInput();
		System.out.println("Enter Name: ");
		String name1 = JdbcUtility.userStringInput();
		System.out.println("Enter Email: ");
		String email2 = JdbcUtility.userStringInput();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			con.setAutoCommit(false);
			save = con.setSavepoint();
			pst = con.prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, email);
			pst.executeUpdate();
	
			System.out.println("1: Commit");
			System.out.println("2: RollBack");
			if(JdbcUtility.userIntegerInput()==1) {
				con.commit();
				System.out.println("Commited");
			}
			else {
				con.rollback(save);
				System.out.println("Rolled Back");
				con.commit();
			}
			save = con.setSavepoint();
			pst = con.prepareStatement(query);
			pst.setString(1, name1);
			pst.setString(2, email2);
			pst.executeUpdate();
			System.out.println("1: Commit");
			System.out.println("2: RollBack");
			if(JdbcUtility.userIntegerInput()==1) {
				con.commit();
				System.out.println("Commited");
			}
			else {
				con.rollback(save);
				System.out.println("Rolled Back");
				con.commit();
			}
			
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
