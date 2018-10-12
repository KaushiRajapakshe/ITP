package com.microElectronics.dao;

import com.microElectronics.model.Warranty;

public interface WarrantyDAO {
	public boolean add(Warranty warranty);

	public boolean update(Warranty warranty);

	public boolean delete(Warranty warranty);
}
