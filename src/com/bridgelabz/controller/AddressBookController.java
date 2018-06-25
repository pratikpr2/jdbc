package com.bridgelabz.controller;

import com.bridgelabz.serviceimplement.AddressBookServiceDBImpl;
import com.bridgelabz.serviceimplement.AddressBookServiceJsonImpl;
import com.bridgelabz.services.AddressBookService;
import com.bridgelabz.util.AddressBookUpdateUtility;

public class AddressBookController {

	static int option; 
	static AddressBookService addressBook;
	public static void main(String[] args) {
		option=0;
		while(option!=3) {
			System.out.println("WELCOME TO ADDRESSBOOK APPLICATION");
			System.out.println("Please Connect a DataStorage Type !");
			System.out.println("1:JSON                 2:MySql Database");
			System.out.println("              3: Exit");
			option = AddressBookUpdateUtility.userIntegerInput();
			switch(option) {
			case 1:
				addressBook = new AddressBookServiceJsonImpl();
				System.out.println("Json DataStorage Selected");
				menu1();
				break;
			case 2:
				addressBook = new AddressBookServiceDBImpl();
				break;
			case 3:
				System.out.println("Exiting Program !");
				break;
			default:
				System.out.println("Invalid Option");
				
			}
		}
		//addressBook.create();
		//addressBook.open();
		//addressBook.deleteBook();
		//addressBook.add();
		//addressBook.add();
		//addressBook.save();
		//addressBook.deletePerson();
		//addressBook.searchByName();
		//addressBook.edit();
		//addressBook.showAllContact();
		//addressBook.create();
		//addressBook.open();
		//addressBook.deleteBook();
		//addressBook.add();
		//addressBook.deletePerson();
		//addressBook.save();
		//addressBook.showAllContact();
		//addressBook.edit();
		//addressBook.showAllContact();
		//addressBook.save();
		//addressBook.searchByName();
	}
	private static void menu1() {
		// TODO Auto-generated method stub
		option=0;
		while(option!=5) {	
			System.out.println("********MENU 1*********");
			System.out.println("Enter A Valid Option...");
			System.out.println("1: CREATE     2: OPEN  ");
			System.out.println("3: VIEW       4: DELETE");
			System.out.println("        5:EXIT");
			option=AddressBookUpdateUtility.userIntegerInput();
			switch(option) {
			case 1:
				addressBook.create();
				break;
			case 2:
				addressBook.open();
				menu2();
				break;
			case 3:
				addressBook.view();
				break;
			case 4:
				addressBook.deleteBook();
				break;
			case 5:
				System.out.println("Exiting Menu 1");
			}
		}
	}
	private static void menu2() {
		// TODO Auto-generated method stub
		option=0;
		while(option!=7) {
			System.out.println("********MENU 2*********");
			System.out.println("Enter A Valid Option...");
			System.out.println("1: ADD       2: DELETE");
			System.out.println("3: EDIT      4: SEARCH");
			System.out.println("5: VIEW ALL  6: SAVE");
			System.out.println("       7: Exit");
			option=AddressBookUpdateUtility.userIntegerInput();
			switch(option) {
			case 1:
				addressBook.add();
				break;
			case 2:
				addressBook.deletePerson();
				break;
			case 3:
				addressBook.edit();
				break;
			case 4:
				addressBook.searchByName();
				break;
			case 5:
				addressBook.showAllContact();
				break;
			case 6:
				addressBook.save();
				break;
			case 7:
				System.out.println("Exiting Menu 2");
				break;
			default:
				System.out.println("Invalid Option");
			}
	
		}

	}
}
