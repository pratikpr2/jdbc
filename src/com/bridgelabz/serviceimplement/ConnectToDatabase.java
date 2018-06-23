package com.bridgelabz.serviceimplement;

import javax.sql.DataSource;

import com.bridgelabz.services.DAOConnect;
import com.bridgelabz.util.DataBaseConnectionFactory;

public class ConnectToDatabase implements DAOConnect {
	DataSource ds = null;

	@Override
	public DataSource connection() {
		// TODO Auto-generated method stub
		ds =DataBaseConnectionFactory.getMysqlConnection();
		if(ds!=null) {
			System.out.println("Connection Established");
		}
		else
			System.out.println("Could Not Connect");
		
		return ds;
	}
	
}
