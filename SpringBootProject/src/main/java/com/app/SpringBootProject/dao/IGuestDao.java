package com.app.SpringBootProject.dao;

import com.app.SpringBootProject.bean.Resort;

public interface IGuestDao {
	
	public long registerResort(Resort resort);
	
	public void updateResort(Resort resort,long r_reservation_number);
	public Resort getResort(long r_reservation_number);

}
