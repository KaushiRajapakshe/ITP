package itp.java.bill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import itp.java.dbconnection.DBConnector;

public class BillNumber {
	private String billNumber;
	
	public BillNumber() {
	}
	
	public String genarateBillNumber() {
		DBConnector db = new DBConnector();
	       Connection con = db.getCon();
	   try {
	       String query = "Select count(billNumber) from bill";
	       Statement st = con.createStatement();
	       ResultSet rs1 = st.executeQuery(query);
	       while(rs1.next()){ 
	    	   billNumber = rs1.getString(1);
	       }
	       int result = Integer.parseInt(billNumber);
	       result += 1;
	       billNumber = String.valueOf(result);
	  
	   } catch (Exception e) {
	        e.printStackTrace();
	   }
	       return billNumber;
	}
	
	
}
