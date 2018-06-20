package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class StoredProcedure {

	public static void main(String[] args) {

		Connection con = null;
		CallableStatement cst= null;
		ResultSet rs = null;
		String query ="call jdbc.getMailCount()";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			cst = con.prepareCall(query);
			rs = cst.executeQuery();
			if(rs.next())
				System.out.println("Total Users: "+rs.getInt(1));
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			if(cst!=null) {
				try {
					cst.close();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}
	
}
