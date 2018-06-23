package com.bridgelabz.util;

import java.util.Scanner;

public class AddressBookUpdateUtility {
	
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
	
	public static String getFirstName() {
		// TODO Auto-generated method stub
		System.out.println("Enter the First Name: ");
		return userStringInput();
	}
	public static String getLastName() {
		System.out.println("Enter the Last Name: ");
		return userStringInput();
	}
	public static String getAddress() {
		System.out.println("Enter The Address: ");
		return userStringInput();
	}
	public static String getCity() {
		System.out.println("Enter The City Address: ");
		return userStringInput();
	}
	public static String getState() {
		System.out.println("Enter The State Name: ");
		return userStringInput();
	}
	public static String getZip() {
		System.out.println("Enter The City Zip: ");
		return userStringInput();
	}
	public static String getphoneNumber() {
		System.out.println("Enter the Phone Number");
		return userStringInput();
	}
}
