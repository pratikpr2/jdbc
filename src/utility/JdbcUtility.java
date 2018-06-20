package utility;

import java.util.Scanner;

public class JdbcUtility {
	
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
}
