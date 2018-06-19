package com.bridgelabz.registrationUtil;

import java.util.Scanner;

public class RegistrationUtility {

static Scanner scanner = new Scanner(System.in);
	
	/**
	 * @return user String Input
	 */
	public static String userStringInput() {
		String string = scanner.nextLine();
		return string;
	}

	/**
	 * @return user Integer Input
	 */
	public static int userIntegerInput() {
		try {
			int number = scanner.nextInt();
			return number;
		} catch (Exception e) {
			scanner.nextLine();
			System.out.println("Invalid number, please try again...");
			return userIntegerInput();
		}

	}
	
	/**
	 * @return user String name input
	 */
	public static String getName() {
		System.out.println("Enter Name: ");
		return userStringInput();
	}
	
	public static String getEmail() {
		System.out.println("Enter Email: ");
		return userStringInput();
	}
	public static String getPhoneNum() {
		System.out.println("Enter Contact Number: ");
		return userStringInput();
	}
	
	public static String getPassword() {
		System.out.println("Enter Password");
		return userStringInput();
	}
	public static String getGender() {
		System.out.println("Gender ??");
		return userStringInput();
	}
}
