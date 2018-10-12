package com.microElectronics.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class dbConnection {

	public static void main(String args[]) {
		 Connection con = null;
		    PreparedStatement st = null;
		    Connection connection = connection();
		   // System.out.println("SHIYO");
	}
	 public static Connection connection() {
	        Connection connection = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/micro_electronics", "root", "");

	          //  System.out.println("okDB");

	        } catch (Exception e) {
	            System.out.println("Error");
	        }
	        return connection;
	    
	}
}
