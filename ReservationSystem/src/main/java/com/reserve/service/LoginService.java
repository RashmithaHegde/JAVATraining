package com.reserve.service;

import com.reserve.bean.Guest;

public interface LoginService {

	public int addGuest(Guest guest);
	
	public boolean validateGuest(String emailId, String password);
}
