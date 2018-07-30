package com.app.SpringBootProject.dao;


import com.app.SpringBootProject.bean.Guest;


public interface IGuestDao {
	
	public Guest registerGuest(Guest guest);
	
	public long updateGuest(Guest guest,long guestId);
	
	public Guest getGuest(long guestId);
	
	public long validate(String email, String password);
	
	
}
