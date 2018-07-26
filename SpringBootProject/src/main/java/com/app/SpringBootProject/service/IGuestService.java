package com.app.SpringBootProject.service;

import com.app.SpringBootProject.bean.Guest;

public interface IGuestService {
	
	
	public long registerGuest(Guest guest);
	
	public long updateGuest(Guest guest,long guestId);
	
	
	public Guest getGuest(long guestId);
	
	public long validate(String email, String password);
	
	
}
