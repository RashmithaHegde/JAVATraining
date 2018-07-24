package com.app.SpringBootProject.service;

import com.app.SpringBootProject.bean.Resort;

public interface IResortService {
	
	public void registerResort(Resort resort);
	public void updateResort(Resort resort,long r_reservation_number);
	public Resort getResort(long r_reservation_number);
}
