package itp.java.bill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import itp.java.dbconnection.DBConnector;

public class cusomerBill {
	private String billNumber;
	private String billDate;
	private int noOfItem;
	private String itemNo;
	private String itemName;
	private double rate;
	private int qty;
	private double discount;
	private double amount;
	private String cusName;
	private String cusAddress;
	
	public cusomerBill() {
		
	}
	
	public cusomerBill(int noOfItem, String itemNo, String itemName, double rate, int qty, double discount, double amount) {
		this.noOfItem = noOfItem;
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.rate = rate;
		this.qty = qty;
		this.discount = discount;
		this.amount = amount;
	}
	
	public cusomerBill(int noOfItem, String itemName, double rate, int qty, double amount) {
		this.noOfItem = noOfItem;
		this.itemName = itemName;
		this.rate = rate;
		this.qty = qty;
		this.amount = amount;
	}
	
	public cusomerBill(String billNumber, String billDate, int noOfItem, String itemNo, String itemName, double rate, int qty, double discount, double amount, String cusName, String cusAddress) {
		this.billNumber = billNumber;
		this.billDate = billDate;
		this.noOfItem = noOfItem;
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.rate = rate;
		this.qty = qty;
		this.discount = discount;
		this.amount = amount;
		this.cusName = cusName;
		this.cusAddress =cusAddress;
	}
	
	public String getItemNo() {
		return itemNo;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public double getRate() {
		return rate;
	}
	
	public int getQty() {
		return qty;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public int getNoOfItem() {
		return noOfItem;
	}
	
	public String getCusName() {
		return cusName;
	}
	
	public String getCusAddress() {
		return cusAddress;
	}
	public void enterDetails() {
		DBConnector db = new DBConnector();
        Connection con = db.getCon();
        try {
			Statement stm = con.createStatement();
			String query = "insert into customerbill (billNumber,billDate,noOfItem,itemNo,itemName,rate,qty,discount,amount) values ('"+this.billNumber+"','"+this.billDate+"','"+this.noOfItem+"','"+this.itemNo+"','"+this.itemName+"','"+this.rate+"','"+this.qty+"','"+this.discount+"','"+this.amount+"')";
			stm.executeUpdate(query);
        }catch(SQLException e1) {
			e1.printStackTrace();
        }
	}
	
	public String calTotalAmount(String billNum) {
		String totalAmount = "0";
		DBConnector db = new DBConnector();
        Connection con = db.getCon();
        try {
			Statement stm = con.createStatement();
			String query = "select sum(amount) AS TotalAmount from customerbill where billNumber ='"+billNum+"'";
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				totalAmount = rs.getString("TotalAmount");
			}
        }catch(SQLException e1) {
			e1.printStackTrace();
        }
        return totalAmount;
	}
}
