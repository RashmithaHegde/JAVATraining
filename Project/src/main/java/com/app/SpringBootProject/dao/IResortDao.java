package com.app.SpringBootProject.dao;

import java.util.List;

import com.app.SpringBootProject.bean.Resort;

public interface IResortDao {
	
	public Resort registerResort(Resort resort,long guest_id);
	
	public long updateResort(Resort resort,long r_reservation_number);
	public Resort getResort(long r_reservation_number);
	public List<Resort> getAllResort(long guest_id);
	public long cancelResort(long r_reservation_number);

}
