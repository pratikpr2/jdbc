package com.bridgelabz.serviceimplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import com.bridgelabz.model.Person;
import com.bridgelabz.services.AddressBookService;
import com.bridgelabz.services.DAOConnect;
import com.bridgelabz.util.AddressBookUpdateUtility;

public class AddressBookServiceDBImpl implements AddressBookService {

	static DataSource ds=null;
	static Connection con=null;
	String tableName = null;
	List<Person> personlist;
	public AddressBookServiceDBImpl() {
		// TODO Auto-generated constructor stub
		connect();
		personlist=new LinkedList<>();
	}
	@Override
	public void create() {
		// TODO Auto-generated method stub
		String strQuery= "create table $tablename("
				+"firstName varchar(20),"
				+"lastName varchar(20),"
				+"address varchar(20),"
				+"city varchar(20),"
				+"state varchar(20),"
				+"zip varchar(10),"
				+"phone varchar(10)"
				+");";

		System.out.println("Enter the Name Of AddressBook");
		tableName= AddressBookUpdateUtility.userStringInput();
		String query = strQuery.replace("$tablename",tableName );
		
		try {
			con = ds.getConnection();
			Statement st = con.createStatement();
			st.executeUpdate(query);
			System.out.println("AddressBook Created");
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Name of AddressBook To Open");
		String name=AddressBookUpdateUtility.userStringInput();
		String query="show tables;";
		
		try {
			con=ds.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				if(rs.getString(1).equals(name)) {
					tableName=name;
					System.out.println("AddressBook Exists");
					return;
				}
				
			}
			System.out.println("No AddressBook");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBook() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Name of Address Book to delete");
		String name= AddressBookUpdateUtility.userStringInput();
		String strQuery ="drop table $tablename";
		String query=strQuery.replace("$tablename",name);
		try {
			con=ds.getConnection();
			Statement st = con.createStatement();
			st.executeUpdate(query);
			System.out.println("AddressBook Deleted");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("No Such AddressBook in Database");
			//e.printStackTrace();
		}
	}

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		System.out.println("Please Connect To a Database To Continue...");
		DAOConnect getcon = new ConnectToDatabase();
		ds = getcon.connection();
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.setFirstName(AddressBookUpdateUtility.getFirstName());
		person.setLastName(AddressBookUpdateUtility.getLastName());
		person.setAddress(AddressBookUpdateUtility.getAddress());
		person.setCity(AddressBookUpdateUtility.getCity());
		person.setState(AddressBookUpdateUtility.getState());
		person.setZip(AddressBookUpdateUtility.getZip());
		person.setPhoneNumber(AddressBookUpdateUtility.getphoneNumber());
		
		personlist.add(person);
		
		System.out.println("Person Added");
		System.out.println("Save To Confirm");
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		System.out.println("Enter the name of Person to edit Details: ");
		String name = AddressBookUpdateUtility.userStringInput();
		String strQuery= "update $tablename set address=? ,city=?,state=?,zip=?,phone=? where firstName=?;";
		String query=strQuery.replace("$tablename", tableName);
		try {
			con = ds.getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, AddressBookUpdateUtility.getAddress());
			pst.setString(2, AddressBookUpdateUtility.getCity());
			pst.setString(3,AddressBookUpdateUtility.getState());
			pst.setString(4, AddressBookUpdateUtility.getZip());
			pst.setString(5, AddressBookUpdateUtility.getphoneNumber());
			pst.setString(6, name);
			pst.executeUpdate();
			
			System.out.println("Contacts Edited");
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		String strQuery = "insert into $tablename values(?,?,?,?,?,?,?);";
		String query = strQuery.replace("$tablename", tableName);
		
		PreparedStatement pst;
		for(Person person:personlist) {
			try {
				con=ds.getConnection();
				pst = con.prepareStatement(query);
				pst.setString(1, person.getFirstName());
				pst.setString(2, person.getLastName());
				pst.setString(3, person.getAddress());
				pst.setString(4, person.getCity());
				pst.setString(5, person.getState());
				pst.setString(6, person.getZip());
				pst.setString(7, person.getPhoneNumber());
				
				pst.executeUpdate();
				
				System.out.println("Contacts Saved !");
				
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		personlist.clear();
		
	}

	@Override
	public void deletePerson() {
		// TODO Auto-generated method stub
		System.out.println("Enter the first Name of person to delete");
		String name = AddressBookUpdateUtility.userStringInput();
		
		String strQuery = "delete from $tablename "
				+"where firstName=?";
		String query = strQuery.replace("$tablename", tableName);
		try {
			con = ds.getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, name);
			pst.executeUpdate();
			System.out.println("Person Deleted");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void searchByName() {
		// TODO Auto-generated method stub
		System.out.println("Enter the First Name to Search: ");
		String name = AddressBookUpdateUtility.userStringInput();
		
		String strQuery="select * from $tablename where firstName=?;";
		String query= strQuery.replace("$tablename", tableName); 
		try {
			con=ds.getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				System.out.println("First Name: "+rs.getString(1));
				System.out.println("Last Name: "+rs.getString(2));
				System.out.println("Address: "+rs.getString(3));
				System.out.println("City: "+rs.getString(4));
				System.out.println("State: "+rs.getString(5));
				System.out.println("Zip: "+rs.getString(6));
				System.out.println("Contact : "+rs.getString(7));
			}
			else
				System.out.println("No Such Contacts");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	public void showAllContact() {
		// TODO Auto-generated method stub
		String strQuery="Select firstName, lastName from $tablename;";
		String query=strQuery.replace("$tablename",tableName);
		try {
			con=ds.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
