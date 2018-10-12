package itp.java.dbconnection;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	//import java.sql.Statement;
	import java.util.logging.Level;
	import java.util.logging.Logger;
	/**
	 *
	 * @author Kaushi
	 */
	public class DBConnector {
	    Connection con;
	    public Connection getCon(){
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/micro_electronics", "root", "");
	            System.out.println("ab");
	            
	        } catch (SQLException | ClassNotFoundException ex) {
	            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return con;
	    }
	    
	}