package com.app.SpringBootProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.SpringBootProject.bean.Guest;
import com.app.SpringBootProject.dao.IGuestDao;

@Service
public class GuestServiceImpl implements IGuestService{
	@Autowired
	IGuestDao dao;

	@Override
	public Guest registerGuest(Guest guest) {
		return dao.registerGuest(guest);
		
	}

	@Override
	public long updateGuest(Guest guest, long guestId) {
	return dao.updateGuest(guest, guestId);
		
	}

	@Override
	public Guest getGuest(long guestId) {
		
	return	dao.getGuest(guestId);
	}

	@Override
	public Guest validate(String email, String password) {
		
		return dao.validate(email, password);
	}

	
	
}
