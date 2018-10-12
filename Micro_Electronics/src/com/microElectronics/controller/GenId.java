package com.microElectronics.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.microElectronics.dataBase.dbConnection;

public class GenId {
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	


public String setId(String pmKey, String table, String id) {
    //System.out.println("inside gen class");
       
    con = dbConnection.connection();
   
    
    String previous = "";
    int tempNo = 0;
    int nextNo = 0;
    String tempNum = "";
    String next = "";
    try {
        String qry = "Select " + pmKey + " from " + table + " ORDER BY " + pmKey + "";
        st = con.prepareStatement(qry);
        rs = st.executeQuery();
        if (rs.last()) {
            previous = rs.getString(pmKey);
        }
    } catch (Exception e) {
        System.out.println("sql error");
    }
    if (previous.equals("")) {
        previous = id + "100";
    }

    for (int x = 0; x < previous.length(); x++) {
        if (Character.isDigit(previous.charAt(x))) {
            tempNum = tempNum + previous.charAt(x) + "";
        }
    }
    tempNo = Integer.parseInt(tempNum);
    nextNo = tempNo + 1;

    next = id + "" + nextNo;
   // System.out.println("gen class  id " + next);
    return next;
}

}
