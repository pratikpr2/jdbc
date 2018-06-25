package com.bridgelabz.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.model.Person;

public class AddressBookUpdateUtility {
	
	static ObjectMapper mapper = new ObjectMapper();
	static Object obj;
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

	public static List<String> readBook() throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		List<String> list = new LinkedList<>();
		obj=new JSONParser().parse(new FileReader("/home/bridgelabz/mycodes/AddressBookUpdate/src/com/bridgelabz/files/booklog.json"));
		JSONArray addressarray = (JSONArray) obj;
		for(Object object:addressarray) {
			String name = object.toString();
			list.add(name);
		}
		return list;
	}

	public static boolean createJson(String filename) throws IOException {
		// TODO Auto-generated method stub
		String fileName = filename+".json";
		File file = new File("/home/bridgelabz/mycodes/AddressBookUpdate/src/com/bridgelabz/files/"+fileName);
		if((file.createNewFile())) {
			System.out.println("AddressBook Created");
		}
		else {
			System.out.println("AddressBook Already Exists");
			return false;
		}
		return true;
		
	}

	public static void saveBook(List<String> addressBook) throws IOException, JsonMappingException{
		// TODO Auto-generated method stub
		mapper.writeValue(new File("/home/bridgelabz/mycodes/AddressBookUpdate/src/com/bridgelabz/files/booklog.json"),addressBook);
	}

	public static List<Person> readAddressBook(String filename) throws FileNotFoundException, IOException, Exception {
		// TODO Auto-generated method stub
		List<Person> list = new LinkedList<>();
		Person person = new Person();
		obj=new JSONParser().parse(new FileReader("/home/bridgelabz/mycodes/AddressBookUpdate/src/com/bridgelabz/files/"+filename+".json"));
		JSONArray addressarray = (JSONArray) obj;
		for(Object object:addressarray) {
			JSONObject getPerson = (JSONObject) object;
			person.setFirstName(getPerson.get("firstName").toString());
			person.setLastName(getPerson.get("lastName").toString());
			person.setAddress(getPerson.get("address").toString());
			person.setCity(getPerson.get("city").toString());
			person.setState(getPerson.get("state").toString());
			person.setZip(getPerson.get("zip").toString());
			person.setPhoneNumber(getPerson.get("phoneNumber").toString());
			list.add(person);
		}
		return list;
		
	}

	public static void deleteLog(String name) throws IOException, ParseException {
		// TODO Auto-generated method stub
		obj = new JSONParser().parse(new FileReader("/home/bridgelabz/mycodes/AddressBookUpdate/src/com/bridgelabz/files/booklog.json"));
		JSONArray addressArray=(JSONArray) obj;
		for(int i=0;i<addressArray.size();i++) {
			if(addressArray.get(i).equals(name)) {
				addressArray.remove(i);
				mapper.writeValue(new File("/home/bridgelabz/mycodes/AddressBookUpdate/src/com/bridgelabz/files/booklog.json"),addressArray);
				return;
			}
		}
	}

	public static void deleteFile(String name) {
		// TODO Auto-generated method stub
		String file = name+".json";
		File file1 = new File("/home/bridgelabz/mycodes/AddressBookUpdate/src/com/bridgelabz/files/"+file);
		 if(file1.delete())
	        {
	            System.out.println("AddressBook deleted successfully");
	        }
	        else
	        {
	            System.out.println("No Such AddressBook");
	        }
	}

	public static void savePerson(List<Person> personList, String filename) throws IOException {
		// TODO Auto-generated method stub
		mapper.writeValue(new File("/home/bridgelabz/mycodes/AddressBookUpdate/src/com/bridgelabz/files/"+filename+".json"),personList);
	}

	public static boolean searchFile(String filename) {
		// TODO Auto-generated method stub
		File file= new File("/home/bridgelabz/mycodes/AddressBookUpdate/src/com/bridgelabz/files/");
		File[] list = file.listFiles();
		if(list!=null)
		for(File fil:list) {
			if(fil.isDirectory()) {
				searchFile(filename);
			}
			else if((filename+".json").equalsIgnoreCase(fil.getName())) {
				return true;
			}
		}
		System.out.println("File Not Found");
		return false;
	}

	public static void deleteContact(String name) {
		// TODO Auto-generated method stub
		
	}
}
