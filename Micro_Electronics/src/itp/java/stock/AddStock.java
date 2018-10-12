package itp.java.stock;

public class AddStock {
		private String productID;
		private String productName;
		private String productDescription;
		private int stockLevel;
		private int recorderLevel;
		private String date;
		
		public AddStock(String productID, String productName, String productDescription, int stockLevel, int recorderLevel, String date) {
			this.productID = productID;
			this.productName = productName;
			this.productDescription = productDescription;
			this.stockLevel = stockLevel;
			this.recorderLevel = recorderLevel;
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
		public void setStockLevel(int stockLevel) {
			this.stockLevel = stockLevel;
		}
		public void setRecorderLevel(int recorderLevel) {
			this.recorderLevel = recorderLevel;
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
		public int getStockLevel() {
			return this.stockLevel;
		}
		public int getRecorderLevel() {
			return this.recorderLevel;
		}
		public String getDate() {
			return this.date;
		}
}
