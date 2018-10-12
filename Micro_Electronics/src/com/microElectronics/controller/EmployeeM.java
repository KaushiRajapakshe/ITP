package com.microElectronics.controller;

import com.microElectronics.dao.EmployeeDAOImplementation;

import javax.swing.JOptionPane;

import com.microElectronics.dao.EmployeeDAO;

public class EmployeeM {
	public void addEmp(String eid, String name, String status, String designation, String age, String adrs, String nic,
			String accno, String telno, String email, String qualifi, String workexp, String pwd, String salary,
			String date) {

		String EID = eid;
		String EName = name;
		String EStatus = status;
		String EDesignation = designation;
		String EAge = age;
		String EAddress = adrs;
		String ENIC = nic;
		String EAccNo = accno;
		String ETelNo = telno;
		String EEmail = email;
		String EQualification = qualifi;
		String EWorkExp = workexp;
		String EPassword = pwd;
		String ESalary = salary;
		String EDate = date;

		com.microElectronics.model.Employee emp = new com.microElectronics.model.Employee();
		emp.setEmpID(EID);
		emp.setEName(EName);
		emp.setEStatus(EStatus);
		emp.setEDesignation(EDesignation);
		emp.setEAge(EAge);
		emp.setEAddress(EAddress);
		emp.setENIC(ENIC);
		emp.setEAccNo(EAccNo);
		emp.setETelNo(ETelNo);
		emp.setEEmail(EEmail);
		emp.setEQualification(EQualification);
		emp.setEWorkExp(EWorkExp);
		emp.setEPassword(EPassword);
		emp.setESalary(ESalary);
		emp.setEDate(EDate);

		EmployeeDAO employeeDAO = new EmployeeDAOImplementation();
		//boolean check = employeeDAO.checkNic(ENIC);
		//if (!check) 
			employeeDAO.add(emp);
		/*else {
			JOptionPane.showMessageDialog(null, "NIC is already exist.");
			System.out.println("NIC is already exist");
		}*/
	}

	public void updateEmp(String eid, String name, String status, String designation, String age, String adrs,
			String nic, String accno, String telno, String email, String qualifi, String workexp, String pwd,
			String salary, String date) {

		String EID = eid;
		String EName = name;
		String EStatus = status;
		String EDesignation = designation;
		String EAge = age;
		String EAddress = adrs;
		String ENIC = nic;
		String EAccNo = accno;
		String ETelNo = telno;
		String EEmail = email;
		String EQualification = qualifi;
		String EWorkExp = workexp;
		String EPassword = pwd;
		String ESalary = salary;
		String EDate = date;

		com.microElectronics.model.Employee emp = new com.microElectronics.model.Employee();
		emp.setEmpID(EID);
		emp.setEName(EName);
		emp.setEStatus(EStatus);
		emp.setEDesignation(EDesignation);
		emp.setEAge(EAge);
		emp.setEAddress(EAddress);
		emp.setENIC(ENIC);
		emp.setEAccNo(EAccNo);
		emp.setETelNo(ETelNo);
		emp.setEEmail(EEmail);
		emp.setEQualification(EQualification);
		emp.setEWorkExp(EWorkExp);
		emp.setEPassword(EPassword);
		emp.setESalary(ESalary);
		emp.setEDate(EDate);

		EmployeeDAO employeeDAO = new EmployeeDAOImplementation();
		employeeDAO.update(emp);

	}

	public void viewEmp(String name, String status, String designation, String age, String adrs, String nic,
			String accno, String telno, String email, String qualifi, String workexp, String pwd, String salary,
			String date) {

		String EName = name;
		String EStatus = status;
		String EDesignation = designation;
		String EAge = age;
		String EAddress = adrs;
		String ENIC = nic;
		String EAccNo = accno;
		String ETelNo = telno;
		String EEmail = email;
		String EQualification = qualifi;
		String EWorkExp = workexp;
		String EPassword = pwd;
		String ESalary = salary;
		String EDate = date;

		com.microElectronics.model.Employee emp = new com.microElectronics.model.Employee();
		emp.setEName(EName);
		emp.setEStatus(EStatus);
		emp.setEDesignation(EDesignation);
		emp.setEAge(EAge);
		emp.setEAddress(EAddress);
		emp.setENIC(ENIC);
		emp.setEAccNo(EAccNo);
		emp.setETelNo(ETelNo);
		emp.setEEmail(EEmail);
		emp.setEQualification(EQualification);
		emp.setEWorkExp(EWorkExp);
		emp.setEPassword(EPassword);
		emp.setESalary(ESalary);
		emp.setEDate(EDate);

		EmployeeDAO employeeDAO = new EmployeeDAOImplementation();
		employeeDAO.view(emp);

	}

	public void deleteEmp(String eid, String name) {

		String EID = eid;
		String EName = name;

		com.microElectronics.model.Employee emp = new com.microElectronics.model.Employee();
		emp.setEmpID(EID);
		emp.setEName(EName);

		EmployeeDAO employeeDAO = new EmployeeDAOImplementation();
		employeeDAO.delete(emp);

	}
	
}
