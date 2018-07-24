package com.app.SpringBootProject.dao;

import com.app.SpringBootProject.bean.Resort;

public interface IResortDao {
	
	public void registerResort(Resort resort);
	
	public void updateResort(Resort resort,long r_reservation_number);
	public Resort getResort(long r_reservation_number);

}
