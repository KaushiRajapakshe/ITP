package itp.java.bill;

public class BillTable {
	private String itemNumber;
	private String productName;
	private String productDescription;
	private int stockLevel;
	public int qty;
	private String availability;
	
	public BillTable() {
		
	}
	public BillTable(String itemNumber, String productName, String productDescription, int stockLevel, int qty1) {
		this.itemNumber = itemNumber;
		this.productName = productName;
		this.productDescription = productDescription;
		this.stockLevel = stockLevel;
		this.qty =  qty1;
	}
	
	public String getItemNumber() {
		return this.itemNumber;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public int getQty() {
		return qty;
	}
	
	public String getProductDescription() {
		return this.productDescription;
	}
	
	public String checkAvailability() {
		if(stockLevel - qty >= 0) {
			availability = "Availabale";
		}else {
			availability = "Not Available";
		}
		return availability;
	}
	
	public int getStock() {
		return this.stockLevel;
	}
}
