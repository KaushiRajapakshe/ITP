package itp.java.item;

public class Item {
	private String productID;
	private String productName;
	private String productDescription;
	private float cost;
	private float price;
	private float discount;
	private String date;
	
	public Item(String productID, String productName, String productDescription, float cost, float price, float discount, String date) {
		this.productID = productID;
		this.productName = productName;
		this.productDescription = productDescription;
		this.cost = cost;
		this.price = price;
		this.discount = discount;	
		this.date = date;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getProductID() {
		return this.productID;
	}
	public String getProductName() {
		return this.productName;
	}
	public String getProductDescription() {
		return this.productDescription;
	}
	public float getCost() {
		return this.cost;
	}
	public float getPrice() {
		return this.price;
	}
	public float getDiscount() {
		return this.discount;
	}
	public String getDate() {
		return this.date;
	}
}
