package itp.java.bill;

public class calAmount {
	private double price;
	private double discount;
	private double amount;
	private double lastPrice;
	
	public calAmount() {
		
	}
	public calAmount(double price, double discount) {
		this. price = price;
		this.discount = discount;
	}
	
	public double getPrice() {
		return this.price;
	}

	public double calcAmount(int qty) {
		BillTable bill = new BillTable();
		if(bill.checkAvailability() == "Availabale") {
			amount = qty * price;
		}
		else
			amount = 0.0;
		return amount;
	}
	
	public double calcLastAmount() {
		lastPrice = amount - (amount * discount / 100);
		return lastPrice; 
	}
}
