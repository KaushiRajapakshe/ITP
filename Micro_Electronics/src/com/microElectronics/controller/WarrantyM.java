package com.microElectronics.controller;

import com.microElectronics.dao.WarrantyDAO;
import com.microElectronics.dao.WarrantyDAOImplementation;

public class WarrantyM {
	public void addWarranty(String customerID, String cusName, String cusTelNo, String productId, String warrantyPeriod,
			String date, String status, String description) {

		String CustomerID = customerID;
		String CusName = cusName;
		String CusTelNo = cusTelNo;
		String ProductID = productId;
		String WarrantyPeriod = warrantyPeriod;
		String Date = date;
		String Status = status;
		String Description = description;

		com.microElectronics.model.Warranty war = new com.microElectronics.model.Warranty();
		war.setCustomerID(CustomerID);
		war.setCusName(CusName);
		war.setCusTelNo(CusTelNo);
		war.setProductID(ProductID);
		war.setWarrantyPeriod(WarrantyPeriod);
		war.setDate(Date);
		war.setStatus(Status);
		war.setDescription(Description);

		WarrantyDAO warrantyDAO = new WarrantyDAOImplementation();
		warrantyDAO.add(war);

	}

	public void updateWarranty(String warrantyID, String customerID, String productId, String warrantyPeriod,
			String date, String status,String description) {
		String WarrantyID = warrantyID;
		String CustomerID = customerID;
		String ProductID = productId;
		String WarrantyPeriod = warrantyPeriod;
		String Date = date;
		String Status = status;
		String Description = description;

		com.microElectronics.model.Warranty war = new com.microElectronics.model.Warranty();
		war.setWarrantyID(WarrantyID);
		war.setCustomerID(CustomerID);
		war.setProductID(ProductID);
		war.setWarrantyPeriod(WarrantyPeriod);
		war.setDate(Date);
		war.setStatus(Status);
		war.setDescription(Description);

		WarrantyDAO warrantyDAO = new WarrantyDAOImplementation();
		warrantyDAO.update(war);

	}

	public void deleteWarranty(String warrantyID) {

		String WID = warrantyID;

		com.microElectronics.model.Warranty war = new com.microElectronics.model.Warranty();
		war.setWarrantyID(WID);

		WarrantyDAO warrantyDAO = new WarrantyDAOImplementation();
		warrantyDAO.delete(war);

	}
}
