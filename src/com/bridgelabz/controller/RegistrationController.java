
package com.bridgelabz.controller;

import com.bridgelabz.registrationUtil.RegistrationUtility;
import com.bridgelabz.serviceImplementation.DataBaseConnectionPstImpl;
import com.bridgelabz.serviceImplementation.UserServiceImpl;
import com.bridgelabz.services.DataBaseConnection;
import com.bridgelabz.services.UserService;

public class RegistrationController {

	private static int option;
	public static void main(String[] args) {
		
		UserService service = new UserServiceImpl();
		
		System.out.println("        Welcome User !!!");
		System.out.println("Enter Valid Option To Continue...");
		
		while(option !=3) {
			System.out.println("1: Login       ||      2: Register");
			System.out.println("           3: Exit");
			option = RegistrationUtility.userIntegerInput();
			switch(option) {
			case 1:
				service.login();
				break;
			case 2:
				service.register();
				break;
			case 3:
				System.out.println("             Exiting ...");
				service.closeConnection();
				System.out.println("All Connections Closed SuccessFully !");
				break;
			default:
				System.out.println("Invalid option");
			}
		}
		
	}
	
}
