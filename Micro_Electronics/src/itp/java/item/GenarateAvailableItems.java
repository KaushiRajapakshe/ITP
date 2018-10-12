package itp.java.item;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import itp.java.dbconnection.DBConnector;

public class GenarateAvailableItems {
	private String productID;
	private int stockLevel;
	private int qty;
	private int availableStock;
	
	public GenarateAvailableItems() {
		
	}

	public GenarateAvailableItems(String productID, int stockLevel, int qty) {
		this.productID = productID;
		this.stockLevel = stockLevel;
		this.qty = qty;
	}
	
	public int getAvailableStock() {
		availableStock = stockLevel - qty;
		return availableStock;
	}
	
	public void setStockLevel() {
		DBConnector db = new DBConnector();
        Connection con = db.getCon();
        try {
			Statement stm = con.createStatement();
			String query = "Update stock set stockLevel = '"+availableStock+"' where (productID = '"+productID+"')";
			stm.executeUpdate(query);
        }catch(SQLException e1) {
			e1.printStackTrace();
        }
	}
}