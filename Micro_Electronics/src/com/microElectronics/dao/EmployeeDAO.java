package com.microElectronics.dao;

import com.microElectronics.model.Employee;

public interface EmployeeDAO {
	public boolean add(Employee employee);

	public boolean update(Employee employee);

	public boolean delete(Employee employee);

	public boolean view(Employee employee);
	
	public boolean checkNic(String nic);
}
