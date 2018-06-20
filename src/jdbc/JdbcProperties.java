package jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JdbcProperties {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Properties properties = new Properties();
		FileReader file = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			
			file= new FileReader("/home/bridgelabz/mycodes/jdbc/src/files/data.properties");
			properties.load(file);
			String name= properties.getProperty("user");
			
			pst = con.prepareStatement("select email from jdbc.mytable where name=?");
			pst.setString(1, name);
			rs = pst.executeQuery();
			if(rs.next()) {
				System.out.println("welcome "+name+",Email: "+rs.getString(1));
			}
			else
				System.out.println("Invalid User");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			if(rs!=null) {
				try {
					rs.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(pst!=null) {
				try {
					pst.close();
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
