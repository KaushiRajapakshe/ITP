package com.microElectronics.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.microElectronics.dataBase.dbConnection;
import com.mysql.jdbc.StringUtils;

public class Validation {
	public boolean isEmpty(String val) {
		if(val.equals("")) {
			return false;
		}
		return true;
	}
	public Boolean ValidateNIC(String nic) {
		if (nic.length() != 10) {
			return false;
		}
		for (int i = 0; i < 9; i++) {
			if (!Character.isDigit(nic.charAt(i))) {
				return false;
			}
		}
		Character c = Character.toLowerCase(nic.charAt(nic.length() - 1));
		if (!(c == 'V' || c == 'v')) {
			return false;
		}
		if(nic.equals("")) {
			return false;
		}
		return true;
	}

	public boolean ValidateTelNo(String telNo) {

		if (telNo.length() != 10) {
			return false;
		}
		
		return true;
	}

	public boolean ValidateAccNo(String accNo) {
		if (!accNo.matches("[0-9]+")) {
			return false;
		}
		if (accNo.length() != 8) {
			return false;
		}
		return true;
	}

	public boolean Alphanumeric(String val) {
		if (!val.matches("[a-zA-Z0-9]+")) {
			return false;
		}
		return true;
	}
	public boolean numeric(String val) {
		for (int i = 0; i < val.length(); i++) {
			if (!Character.isDigit(val.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	public boolean EmailValidation(String email) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);

		if (matcher.matches() == false) {
			return false;
		}
		return true;
	}

	public boolean Password(String pwd) {
		if (pwd.length() < 5 || pwd.length() > 8) {
			return false;
		}
		if (!pwd.matches("[a-zA-Z0-9]+")) {
			return false;
		}
		return true;

	}
	public boolean checkNIC(String nic) {
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
