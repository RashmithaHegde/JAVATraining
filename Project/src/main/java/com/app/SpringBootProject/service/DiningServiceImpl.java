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
	public Dining registerDining(Dining dining,long guestId) {
		
		return dao.registerDining(dining, guestId);
	}

	@Override
	public long updateDining(Dining dining, long dReservationNumber) {
		return dao.updateDining(dining, dReservationNumber);
	}

	@Override
	public Dining getDining(long dReservationNumber) {
		
		return dao.getDining(dReservationNumber);
	}

	@Override
	public List<Dining> getAllDining(long guestId) {
		return dao.getAllDining(guestId);
	}

	@Override
	public long cancelDining(long dReservationNumber) {
		
		return dao.cancelDining(dReservationNumber);
	}

	

	
}
