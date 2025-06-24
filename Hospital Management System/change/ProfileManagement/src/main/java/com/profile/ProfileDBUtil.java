package com.profile;

import java.sql.Connection;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProfileDBUtil {
	 // ENCAPSULATION (private static connection objects)
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
    

	
	// Method to validate user details by name and email
	public static  List<Profile> validate(String email, String password) {
		
           ArrayList<Profile> cus = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from profile where email='"+email+"' and password='"+password+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				int id = rs.getInt(1);
				String uname = rs.getString(2);
				String dob = rs.getString(3);
				String address = rs.getString(4);
				String email1 = rs.getString(5);
				String cnumber = rs.getString(6);
				String type = rs.getString(7);
				String password1 = rs.getString(8);

				
				
				Profile c = new Profile(id,uname,dob,address,email1,cnumber,type,password1);
				cus.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return cus;
	}
	
	
	// Method to insert customer details into the database
    public static boolean insertcustomer(String uname, String dob, String address, String email, String cnumber, String type, String password) {
    	
    	boolean isSuccess = false;
    	
    	try {
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    	    String sql = "insert into profile values (0,'"+uname+"','"+dob+"','"+address+"','"+email+"','"+cnumber+"','"+type+"','"+password+"')";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		} else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	} 
 	
    	return isSuccess;
    }
    
 // Method to update customer details in the database
    public static boolean updatecustomer(String id, String uname, String dob, String address, String email, String cnumber, String type, String password) {
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "update profile set uname='"+uname+"',dob='"+dob+"',address='"+address+"',email='"+email+"',cnumber='"+cnumber+"',type='"+type+"',password='"+password+"' "
    				+ "where id='"+id+"'";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }
    
    // Method to retrieve customer details from the database
    public static List<Profile> getCustomerDetails(String Id) {
    	
    	int convertedID = Integer.parseInt(Id);
    	
    	ArrayList<Profile> cus = new ArrayList<>();
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "select * from profile where id='"+convertedID+"'";
    		rs = stmt.executeQuery(sql);
    		
    		// COLLECTIONS FRAMEWORK (List<Profile>)
    		while(rs.next()) {
    			int id = rs.getInt(1);
    			String uname = rs.getString(2);
				String dob = rs.getString(3);
				String address = rs.getString(4);
				String email1 = rs.getString(5);
				String cnumber = rs.getString(6);
				String type = rs.getString(7);
				String password1 = rs.getString(8);

    			
				Profile c = new Profile(id,uname,dob,address,email1,cnumber,type,password1);
    			cus.add(c);
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}	
    	return cus;	
    }
    
 // Method to delete a customer from the database
    public static boolean deleteCustomer(String id) {
    	
    	int convId = Integer.parseInt(id);
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "delete from profile where id='"+convId+"'";
    		int r = stmt.executeUpdate(sql);
    		
    		if (r > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }
    
}
