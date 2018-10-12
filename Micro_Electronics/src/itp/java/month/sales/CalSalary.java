package itp.java.month.sales;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import itp.java.bill.cusomerBill;
import itp.java.dbconnection.DBConnector;

public class CalSalary {
	public static final String DateFormat1 = "MM";
	private static String month;
	
	private static float sum;

	DBConnector db = new DBConnector();
    Connection con = db.getCon();
    public float calcSales(){
	    String query = "SELECT sum(NetSal) FROM  salary where month = '"+month+"'";
	    Statement st;
	    ResultSet rs;
	    System.out.println(" "+month);
	    try {
	        st = con.createStatement();
	        rs = st.executeQuery(query);
	        cusomerBill bill;
	        while(rs.next())
	        {
	            sum = (float) rs.getDouble(1);
	            
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    System.out.println(" "+sum);
	    return sum;
    }
	public static String date() {
		Calendar c1 = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat(DateFormat1);
		month = format.format(c1.getTime());
		return month;
	}

}

