package itp.java.bill;

public class Bill {
	private String billNo;
	private String billDate;
	private String cusName;
	private String address;
	private String itemNo;
	private int qty;
	
	public Bill(String billNo, String billDate, String cusName, String address, String itemNo, int qty) {
		this.billNo = billNo;
		this.billDate = billDate;
		this.cusName = cusName;
		this.address = address;
		this.itemNo = itemNo;
		this.qty = qty;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public void setCustomerName(String cusName) {
		this.cusName = cusName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getBillNo() {
		return this.billNo;
	}
	public String getBillDate() {
		return this.billDate;
	}
	public String getCustomerName() {
		return this.cusName;
	}
	public String getAddress() {
		return this.address;
	}
	public String getItemNo() {
		return this.itemNo;
	}
	public int getQty() {
		return this.qty;
	}
}
