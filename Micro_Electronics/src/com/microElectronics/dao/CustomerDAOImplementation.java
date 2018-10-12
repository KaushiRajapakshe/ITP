package com.microElectronics.dao;

import java.sql.Connection;
import java.sql.Statement;

import com.microElectronics.dataBase.dbConnection;
import com.microElectronics.model.Customer;

public class CustomerDAOImplementation implements CustomerDAO {
public boolean add(Customer customer) {
		
        String sql = "INSERT INTO customer"
                + "(CID,Name,TelephoneNo,Address,Date) "
                + "VALUES("
                + "'" +  customer.getCID()
                + "','" + customer.getCName()
                + "','" + customer.getCTelNo()
                + "','" + customer.getCAdrs()
                + "','" + customer.getDate()+ "')";

        try {
            Connection con = dbConnection.connection();
            Statement st = con.createStatement();

            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("Error add customer : "+ex);
        }
        return true;
    }

    
    public boolean update(Customer customer) {
    		String sql ="UPDATE  customer "
    				+ "SET Name='" + customer.getCName()
    				+ "',TelephoneNo='" + customer.getCTelNo()
    				+ "',Address='"+ customer.getCAdrs()
    				+ "',Date='" + customer.getDate()
    				+ "' WHERE CID='" + customer.getCID() + "'";
    		
    		 try {
    	            Connection con = dbConnection.connection();
    	            Statement st = con.createStatement();
    	            st.executeUpdate(sql);
    	        
    	        } catch (Exception ex) {
    	            System.out.println("Error update customer : "+ex);
    	        }
    	        return true; 
    }

    
    public boolean delete(Customer customer) {
    	String sql = "DELETE FROM customer WHERE CID = '" + customer.getCID()+"'";
    	 try {
	            Connection con = dbConnection.connection();
	            Statement st = con.createStatement();

	            st.executeUpdate(sql);
	        } catch (Exception ex) {
	            System.out.println("Error delete customer: "+ex);
	        }
	        return true; 
   }

}
