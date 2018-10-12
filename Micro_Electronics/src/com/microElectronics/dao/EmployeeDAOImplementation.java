package com.microElectronics.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import com.microElectronics.dataBase.dbConnection;
import java.sql.Statement;
import com.microElectronics.model.Employee;
import java.sql.PreparedStatement;

public class EmployeeDAOImplementation implements EmployeeDAO {
	@Override
    public boolean add(Employee employee) {
		
		
        String sql = "INSERT INTO employee"
                + "(EID,Name,Status,Designation,Age,Address,NIC,AccNo,TelNo,Email,Qualification,WorkExperience,Password,Salary,Date) "
                + "VALUES("
                + "'" + employee.getEID()
                + "','" + employee.getEName()
                + "','" + employee.getEStatus()
                + "','" + employee.getEDesignation()
                + "','" + employee.getEAge()
                + "','" + employee.getEAddress()
                + "','" + employee.getENIC()
                + "','" + employee.getEAccNo()
                + "','" + employee.getETelNo()
                + "','" + employee.getEEmail()
                + "','" + employee.getEQualification()
                + "','" + employee.getEWorkExp()
                + "','" + employee.getEPassword()
                + "','" + employee.getESalary()
                + "','" + employee.getEDate() + "')";

        try {
            Connection con = dbConnection.connection();
            Statement st = con.createStatement();

            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("Error add: "+ex);
        }
        return true;
    }

    @Override
    public boolean update(Employee employee) {
    		String sql ="UPDATE  employee "
    				+ "SET Name='" + employee.getEName()
    				+ "',Status='" + employee.getEStatus()
    				+ "',Designation='"+ employee.getEDesignation()
    				+ "',Age='" + employee.getEAge()
    				+ "',Address='" + employee.getEAddress()
    				+ "',NIC='" + employee.getENIC()
    				+ "',AccNo='" +  employee.getEAccNo()
    				+ "',TelNo='" + employee.getETelNo()
    				+ "',Email='" +  employee.getEEmail()
    				+ "',Qualification='" + employee.getEQualification()
    				+ "',WorkExperience='" + employee.getEWorkExp()
    				+ "',Password='" +  employee.getEPassword()
    				+ "',Salary='"+ employee.getESalary()
    				+ "',Date='" + employee.getEDate()
    				+ "' WHERE EID='" + employee.getEID() + "'";
    		
    		 try {
    	            Connection con = dbConnection.connection();
    	            Statement st = con.createStatement();
    	            st.executeUpdate(sql);
    	        
    	        } catch (Exception ex) {
    	            System.out.println("Error update: "+ex);
    	        }
    	        return true; 
    }

    @Override
    public boolean delete(Employee employee) {
    	String sql = "DELETE FROM employee WHERE EID = '" + employee.getEID()+"'";
    	 try {
	            Connection con = dbConnection.connection();
	            Statement st = con.createStatement();

	            st.executeUpdate(sql);
	        } catch (Exception ex) {
	            System.out.println("Error delete: "+ex);
	        }
	        return true; 
   }

   
    @Override
    public boolean view(Employee employee) {
    	
    	String sql = "SELECT * FROM employee ";
   	 try {
	            Connection con = dbConnection.connection();
	            Statement st = con.createStatement();

	            st.executeUpdate(sql);
	        } catch (Exception ex) {
	            System.out.println("Error view : "+ex);
	        }
	        return true;
	 }

	@Override
	public boolean checkNic(String nic) {
		String sql = "Select count(NIC) from employee where NIC like '"+nic+"'";
		try {
            Connection con = dbConnection.connection();
            
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
            	int count = rs.getInt(1);
            	if(count>0)
            		return true;
            }
            	
        } catch (Exception ex) {
            System.out.println("Error view : "+ex);
        }
		return false;
	}

    
}
