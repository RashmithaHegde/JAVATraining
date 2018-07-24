package com.reserve.Dao;

import com.reserve.bean.Guest;

public interface LoginDao {
	
	public int addGuest(Guest guest);
	
	public boolean validateGuest(String emailId, String password);

}
