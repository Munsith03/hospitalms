package com.profile;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	// Setting up the URL, username, and password for the database connection
		private static String url = "jdbc:mysql://localhost:3306/oop";
		private static String userName = "root";
		private static String password = "12301230";
		private static Connection con;

		// Method to get the database connection
		public static Connection getConnection() {
			
			try {
				// Loading the MySQL JDBC driver
				Class.forName("com.mysql.jdbc.Driver");
				
				// Establishing the database connection using the DriverManager
				con = DriverManager.getConnection(url, userName, password);
				
			}
			catch (Exception e) {
				
				// Printing the error message if the connection is not successful
				System.out.println("Database connection is not success!!!");
			}
			
			return con;
		}
	}

