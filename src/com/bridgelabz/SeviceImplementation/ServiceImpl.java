package com.bridgelabz.SeviceImplementation;

import com.bridgelabz.SeviceImplementation.DataBaseConnectionImpl;
import com.bridgelabz.Sevices.Service;
import com.bridgelabz.model.User;
import com.bridgelabz.registrationUtil.RegistrationUtility;

public class ServiceImpl implements Service {
	private static DataBaseConnectionImpl  dbConnect;
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
		
		dbConnect = new DataBaseConnectionImpl();
		dbConnect.registerUser(user);
		
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		RegistrationUtility.userStringInput();
		System.out.println("Enter Your Creditentials To login: ");
		dbConnect = new DataBaseConnectionImpl();
		dbConnect.selectUser();
		
	}

	
}
