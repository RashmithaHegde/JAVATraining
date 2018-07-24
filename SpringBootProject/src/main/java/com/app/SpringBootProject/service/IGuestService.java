package com.app.SpringBootProject.service;

import com.app.SpringBootProject.bean.Guest;

public interface IGuestService {
	
	
	public void registerGuest(Guest guest);
	
	public void updateGuest(Guest guest,long guestId);
	
	
	public Guest getGuest(long guestId);
}
