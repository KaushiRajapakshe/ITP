package com.microElectronics.controller;

import com.microElectronics.dao.CustomerDAO;
import com.microElectronics.dao.CustomerDAOImplementation;

public class CustomerM {
	public void addCustomer(String cid, String name, String telNo, String adrs, String date) {
		String CID = cid;
		String CName = name;
		String CTelNo = telNo;
		String CAdrs = adrs;
		String CDate = date;

		com.microElectronics.model.Customer cus = new com.microElectronics.model.Customer();
		cus.setCID(CID);
		cus.setCName(CName);
		cus.setCTelNo(CTelNo);
		cus.setCAdrs(CAdrs);
		cus.setCDate(CDate);

		CustomerDAO customerDAO = new CustomerDAOImplementation();
		customerDAO.add(cus);

	}

	public void updateCustomer(String cid, String name, String telNo, String adrs, String date) {
		String CID = cid;
		String CName = name;
		String CTelNo = telNo;
		String CAdrs = adrs;
		String CDate = date;

		com.microElectronics.model.Customer cus = new com.microElectronics.model.Customer();
		cus.setCID(CID);
		cus.setCName(CName);
		cus.setCTelNo(CTelNo);
		cus.setCAdrs(CAdrs);
		cus.setCDate(CDate);

		CustomerDAO customerDAO = new CustomerDAOImplementation();
		customerDAO.update(cus);

	}

	public void viewCustomer(String name, String telNo, String adrs, String date) {

		String CName = name;
		String CTelNo = telNo;
		String CAdrs = adrs;
		String CDate = date;

		com.microElectronics.model.Customer cus = new com.microElectronics.model.Customer();
		cus.setCName(CName);
		cus.setCTelNo(CTelNo);
		cus.setCAdrs(CAdrs);
		cus.setCDate(CDate);

		CustomerDAO customerDAO = new CustomerDAOImplementation();
		customerDAO.add(cus);

	}

	public void deleteCustomer(String cid) {

		String CID = cid;

		com.microElectronics.model.Customer cus = new com.microElectronics.model.Customer();
		cus.setCID(CID);

		CustomerDAO customerDAO = new CustomerDAOImplementation();
		customerDAO.delete(cus);

	}
}
