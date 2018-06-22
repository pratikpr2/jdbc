package com.bridgelabz.serviceImplementation;

import com.bridgelabz.model.User;
import com.bridgelabz.registrationUtil.RegistrationUtility;
import com.bridgelabz.serviceImplementation.DataBaseConnectionPstImpl;
import com.bridgelabz.services.DataBaseConnection;
import com.bridgelabz.services.UserService;

public class UserServiceImpl implements UserService {
	private DataBaseConnection  dbConnect;
	boolean b;
	@Override
	public void register() {
		// TODO Auto-generated method stub
		RegistrationUtility.userStringInput();
		System.out.println("Welcome New User");
		User user = new User();
		user.setName(RegistrationUtility.getName());
		user.setEmail(RegistrationUtility.getEmail());
		user.setPassword(RegistrationUtility.getPassword());
		user.setGender(RegistrationUtility.getGender());
		user.setPhoneNumber(RegistrationUtility.getPhoneNum());
		
		dbConnect = new DatabaseConnectionStImpl();
		dbConnect.getConnection();
		dbConnect.registerUser(user);
		
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		RegistrationUtility.userStringInput();
		
		dbConnect = new DatabaseConnectionStImpl();
		dbConnect.getConnection();
		System.out.println("Enter Your Creditentials To login: ");
		dbConnect.selectUser();
		
	}

	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		dbConnect.closeConnection();
	}

	
}
