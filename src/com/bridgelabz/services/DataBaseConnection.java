package com.bridgelabz.services;

import com.bridgelabz.model.User;

public interface DataBaseConnection {

	void getConnection();
	void selectUser();
	void registerUser(User user);
	void closeConnection();
}
