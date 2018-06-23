package com.bridgelabz.controller;

import com.bridgelabz.serviceimplement.AddressBookServiceDBImpl;
import com.bridgelabz.serviceimplement.AddressBookServiceJsonImpl;
import com.bridgelabz.services.AddressBookService;

public class AddressBookController {

	public static void main(String[] args) {
		
		AddressBookService addressBook = new AddressBookServiceDBImpl();
	
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
	}
}
