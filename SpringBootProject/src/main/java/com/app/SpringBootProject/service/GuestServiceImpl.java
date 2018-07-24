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
	public void registerGuest(Guest guest) {
		dao.registerGuest(guest);
		
	}

	@Override
	public void updateGuest(Guest guest, long guestId) {
	dao.updateGuest(guest, guestId);
		
	}

	@Override
	public Guest getGuest(long guestId) {
		
	return	dao.getGuest(guestId);
	}
	
	
}
