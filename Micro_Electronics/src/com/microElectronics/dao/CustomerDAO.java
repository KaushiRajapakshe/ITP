package com.microElectronics.dao;

import com.microElectronics.model.Customer;

public interface CustomerDAO {
	public boolean add(Customer customer);

	public boolean update(Customer customer);

	public boolean delete(Customer customer);
}
