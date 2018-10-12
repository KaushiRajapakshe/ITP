package com.microElectronics.dao;

import java.sql.Connection;
import java.sql.Statement;

import com.microElectronics.dataBase.dbConnection;
import com.microElectronics.model.Warranty;

public class WarrantyDAOImplementation implements WarrantyDAO {
	public boolean add(Warranty warranty) {
		
        String sql = "INSERT INTO warranty"
                + "(CusID,CusName,CusTelNo,ProductID,WarrantyPeriod,StartDate,Status,Description) "
                + "VALUES("
                + "'" +  warranty.getCustomerID()
                + "','" + warranty.getCusName()
                + "','" + warranty.getCusTelNo()
                + "','" + warranty.getProductID()
                + "','" + warranty.getWarrantyPeriod()
                + "','" + warranty.getDate()
                + "','" + warranty.getStatus()
                + "','" + warranty.getDescription() + "')";

        try {
            Connection con = dbConnection.connection();
            Statement st = con.createStatement();

            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("Error add warranty : "+ex);
        }
        return true;
    }

    
    public boolean update(Warranty warranty) {
    		String sql ="UPDATE  warranty "
    				+ "SET CusID='" + warranty.getCustomerID()
    				+ "',ProductID='" + warranty.getProductID()
    				+ "',WarrantyPeriod='"+ warranty.getWarrantyPeriod()
    				+ "',StartDate='" + warranty.getDate()
    				+ "',Status='" + warranty.getStatus()
    				+ "',Description='" + warranty.getDescription()
    				+ "' WHERE WarrantyID='" + warranty.getWarrantyID() + "'";
    		System.out.println("inside updatte sql");
    		 try {
    	            Connection con = dbConnection.connection();
    	            Statement st = con.createStatement();
    	            st.executeUpdate(sql);
    	        
    	        } catch (Exception ex) {
    	            System.out.println("Error update warranty : "+ex);
    	        }
    	        return true; 
    }

    
    public boolean delete(Warranty warranty) {
    	String sql = "DELETE FROM warranty WHERE WarrantyID = '" + warranty.getWarrantyID()+"'";
    	System.out.println("inside delete sql");
    	 try {
	            Connection con = dbConnection.connection();
	            Statement st = con.createStatement();

	            st.executeUpdate(sql);
	        } catch (Exception ex) {
	            System.out.println("Error delete warranty: "+ex);
	        }
	        return true; 
   }

}
