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
	public long registerResort(Resort resort,long guest_id) {
		 return dao.registerResort(resort,guest_id);
		
	}

	@Override
	public long updateResort(Resort resort,long r_reservation_number) {
		return dao.updateResort(resort,r_reservation_number);
		
	}

	@Override
	public Resort getResort(long r_reservation_number) {
		
		return dao.getResort(r_reservation_number);
	}

	@Override
	public List<Resort> getAllResort(long guest_id) {
		
		return dao.getAllResort(guest_id);
	}

	@Override
	public long cancelResort(long r_reservation_number) {
		
		return dao.cancelResort(r_reservation_number);
	}

}
