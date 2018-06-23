package com.bridgelabz.util;

import java.io.FileInputStream;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataBaseConnectionFactory {

	public static DataSource getMysqlConnection() {
		
		Properties prop =  new Properties();
		FileInputStream file = null;
		MysqlDataSource mysqlDB = null;
		try {
			file = new FileInputStream("/home/bridgelabz/mycodes/AddressBookUpdate/src/com/bridgelabz/files/dbconnect.properties");
			prop.load(file);
			mysqlDB = new MysqlDataSource();
			mysqlDB.setUrl(prop.getProperty("MYSQL_DB_URL"));
			mysqlDB.setUser(prop.getProperty("MYSQL_DB_USERNAME"));
			mysqlDB.setPassword(prop.getProperty("MYSQL_DB_PASSWORD"));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mysqlDB;
	}
}
