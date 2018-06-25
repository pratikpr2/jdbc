package com.bridgelabz.serviceimplement;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.bridgelabz.model.Person;
import com.bridgelabz.services.AddressBookService;
import com.bridgelabz.util.AddressBookUpdateUtility;

public class AddressBookServiceJsonImpl implements AddressBookService{
	
	private List<Person> personList;
	private List<String> addressBook;
	private String filename;
	
	public AddressBookServiceJsonImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("Address Manager Initialised");
		try {
			//tempList.clear();
			addressBook = AddressBookUpdateUtility.readBook();
				
		}catch(Exception e) {
			addressBook=new LinkedList<>();
			System.out.println("No addressBook");
		}
	
	}
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		AddressBookUpdateUtility.userStringInput();
		boolean b=false;
		System.out.println("Enter the name of Address Book: ");
		filename = AddressBookUpdateUtility.userStringInput();
		try {
			b=AddressBookUpdateUtility.createJson(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(b) {
			addressBook.add(filename);
			try {
				AddressBookUpdateUtility.saveBook(addressBook);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		AddressBookUpdateUtility.userStringInput();
		System.out.println("Enter the name of Address Book: ");
		filename = AddressBookUpdateUtility.userStringInput();
		
		if(AddressBookUpdateUtility.searchFile(filename)) {
			System.out.println(filename+" AddressBook Opened");
			try {
				personList=AddressBookUpdateUtility.readAddressBook(filename);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Address Book Empty");
				personList= new LinkedList<>();
			}
		}
		
		
	}

	@Override
	public void deleteBook() {
		// TODO Auto-generated method stub
		AddressBookUpdateUtility.userStringInput();
		System.out.println("Enter the AdressBook Name to delete");
		String name=AddressBookUpdateUtility.userStringInput();
		
		try {
			AddressBookUpdateUtility.deleteLog(name);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addressBook.remove(name);
		AddressBookUpdateUtility.deleteFile(name);
		
	}

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		AddressBookUpdateUtility.userStringInput();
		System.out.println("Enter The Person Details: ");
		Person person = new Person();
		person.setFirstName(AddressBookUpdateUtility.getFirstName());
		person.setLastName(AddressBookUpdateUtility.getLastName());
		person.setAddress(AddressBookUpdateUtility.getAddress());
		person.setCity(AddressBookUpdateUtility.getCity());
		person.setState(AddressBookUpdateUtility.getState());
		person.setZip(AddressBookUpdateUtility.getZip());
		person.setPhoneNumber(AddressBookUpdateUtility.getphoneNumber());
		
		personList.add(person);
		
		System.out.println("Person added");
		System.out.println("Click save to continue");
		
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		AddressBookUpdateUtility.userStringInput();
		System.out.println("Enter the first Name to edit: ");
		String firstname= AddressBookUpdateUtility.userStringInput();
		for(Person person:personList) {
			if(person.getFirstName().equals(firstname)) {
				person.setAddress(AddressBookUpdateUtility.getAddress());
				person.setCity(AddressBookUpdateUtility.getCity());
				person.setState(AddressBookUpdateUtility.getState());
				person.setZip(AddressBookUpdateUtility.getZip());
				person.setPhoneNumber(AddressBookUpdateUtility.getphoneNumber());
				
				System.out.println("Contacts Updated");
			}
			else
				System.out.println("No such Contacts");
		}
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		try {
			AddressBookUpdateUtility.savePerson(personList,filename);
			System.out.println("Changes Saved");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deletePerson() {
		// TODO Auto-generated method stub
		AddressBookUpdateUtility.userStringInput();
		System.out.println("Enter the First Name to Delete: ");
		String name = AddressBookUpdateUtility.userStringInput();
		for(Person person:personList) {
			if(person.getFirstName().equals(name)) {
				personList.remove(person);
				System.out.println("Person Deleted");
			}
			else
				System.out.println("No Such Entry");
		}
	}

	@Override
	public void searchByName() {
		// TODO Auto-generated method stub
		AddressBookUpdateUtility.userStringInput();
		System.out.println("Enter the First Name to Search a Contact: ");
		String firstName = AddressBookUpdateUtility.userStringInput();
		for(Person person:personList) {
			if(person.getFirstName().equals(firstName)) {
				System.out.println("First Name: "+person.getFirstName());
				System.out.println("Last Name: "+person.getLastName());
				System.out.println("Address: "+person.getAddress());
				System.out.println("City: "+person.getCity());
				System.out.println("State: "+person.getState());
				System.out.println("Zip: "+person.getZip());
				System.out.println("Contact: "+person.getPhoneNumber());
			}
			else
				System.out.println("No Such Contact");
		}
	}

	@Override
	public void showAllContact() {
		// TODO Auto-generated method stub
		System.out.println("***************Contacts************");
		if(!personList.isEmpty())
		for(Person person:personList) {
			System.out.println("First Name: "+person.getFirstName());
			System.out.println("Last Name: "+person.getLastName());
			System.out.println("Address: "+person.getAddress());
			System.out.println("City: "+person.getCity());
			System.out.println("State: "+person.getState());
			System.out.println("Zip: "+ person.getZip());
			System.out.println("Contact: "+person.getPhoneNumber());
			System.out.println("__________________________________");
		}
		else
			System.out.println("AddressBook Empty");
	}

	@Override
	public void view() {
		// TODO Auto-generated method stub
		int i=1;
		for(String book:addressBook) {
			System.out.println(i+". "+book);
			i++;
		}
	}

}
