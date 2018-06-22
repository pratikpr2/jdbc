package com.bridgelabz.serviceImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.model.User;
import com.bridgelabz.registrationUtil.RegistrationUtility;
import com.bridgelabz.services.DataBaseConnection;

public class DataBaseConnectionPstImpl implements DataBaseConnection {

	static Connection con = null ;
	Statement st = null;
	PreparedStatement pst=null;
	ResultSet rs = null;
	
	@Override
	public void getConnection() {
		// TODO Auto-generated method stub
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("    ******Driver Loaded*****");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("    *Connection Established*");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void selectUser() {
		// TODO Auto-generated method stub
		System.out.println("Enter Your Email: ");
		String email = RegistrationUtility.userStringInput();
		System.out.println("Enter Your Password: ");
		String passWord = RegistrationUtility.userStringInput();
		
		String query = "select name from user.registration where email = ? and password = ?";
		try {
			
			pst = con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, passWord );
			
			rs = pst.executeQuery();
			
			if(rs.next()) {                                 
				String user = rs.getString(1);
				System.out.println("Welcome :"+ user);
			}
			else {
				System.out.println("Invalid User !");
				System.out.println("Please Register !");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		String name = user.getName();
		String email = user.getEmail();
		String password = user.getPassword();
		String phoneNumber=user.getPhoneNumber();
		String gender = user.getGender();
		
		String query = "insert into user.registration values(0,?,?,?,?,?)";
		try {
			if(checkUser(email)) {

				pst = con.prepareStatement(query);
				pst.setString(1, name);
				pst.setString(2, email);
				pst.setString(3, password);
				pst.setString(4, phoneNumber);
				pst.setString(5, gender);
				pst.executeUpdate();
				System.out.println("New User Added...!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean checkUser(String email) {
		String search = "select email from user.registration";
		boolean b=true;
		try {
			st = con.createStatement();
			rs = st.executeQuery(search);
			
			
			while(rs.next()) {
				if(rs.getString(1).equals(email)) {
					System.out.println("User Email Already Exists");
					b=false;
					return b;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return b;
	}
	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		if(rs!=null) {
			try {
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(pst!=null) {
			try {
				pst.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
