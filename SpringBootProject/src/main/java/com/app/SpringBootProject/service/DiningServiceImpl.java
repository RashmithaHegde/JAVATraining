package com.app.SpringBootProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.SpringBootProject.bean.Dining;
import com.app.SpringBootProject.dao.DiningDaoImpl;

@Service
public class DiningServiceImpl implements IDiningService {
	
	@Autowired
	DiningDaoImpl dao;

	@Override
	public void registerDining(Dining dining,long guestId) {
		
		dao.registerDining(dining, guestId);
	}

	@Override
	public void updateDining(Dining dining, long dReservationNumber) {
		dao.updateDining(dining, dReservationNumber);
	}

	@Override
	public Dining getDining(long dReservationNumber) {
		
		return dao.getDining(dReservationNumber);
	}

	@Override
	public List<Dining> getAllDining(long guest_id) {
		return dao.getAllDining(guest_id);
	}

	@Override
	public long cancelDining(long dReservationNumber) {
		
		return dao.cancelDining(dReservationNumber);
	}

	

	
}
