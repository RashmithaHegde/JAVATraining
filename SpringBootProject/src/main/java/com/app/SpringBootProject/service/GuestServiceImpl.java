package com.app.SpringBootProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.SpringBootProject.bean.Resort;
import com.app.SpringBootProject.dao.GuestDaoImpl;

@Service
public class GuestServiceImpl implements IGuestService {

	@Autowired
	private GuestDaoImpl dao;
	
	@Override
	public void registerResort(Resort resort) {
		 dao.registerResort(resort);
		
	}

	@Override
	public void updateResort(Resort resort,long r_reservation_number) {
		dao.updateResort(resort,r_reservation_number);
		
	}

	@Override
	public Resort getResort(long r_reservation_number) {
		
		return dao.getResort(r_reservation_number);
	}

}
