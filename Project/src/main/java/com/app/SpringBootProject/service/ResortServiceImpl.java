package com.app.SpringBootProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.SpringBootProject.bean.Resort;
import com.app.SpringBootProject.dao.ResortDaoImpl;

@Service
public class ResortServiceImpl implements IResortService {

	@Autowired
	private ResortDaoImpl dao;
	
	@Override
	public Resort registerResort(Resort resort,long guestId) {
		 return dao.registerResort(resort,guestId);
		
	}

	@Override
	public long updateResort(Resort resort,long rReservationNumber) {
		return dao.updateResort(resort,rReservationNumber);
		
	}

	@Override
	public Resort getResort(long rReservationNumber) {
		
		return dao.getResort(rReservationNumber);
	}

	@Override
	public List<Resort> getAllResort(long guestId) {
		
		return dao.getAllResort(guestId);
	}

	@Override
	public long cancelResort(long rReservationNumber) {
		
		return dao.cancelResort(rReservationNumber);
	}

}
