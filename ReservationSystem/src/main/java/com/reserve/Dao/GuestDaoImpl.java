package com.reserve.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.reserve.bean.DiningReservation;
import com.reserve.bean.ResortReservation;
import com.reserve.mapper.DiningRowMapper;
import com.reserve.mapper.ResortRowMapper;


@Transactional
@Repository
public class GuestDaoImpl implements GuestDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public DiningReservation getBookingDetails(int guestId) {
		DiningReservation diningReservation = null;
		RowMapper<DiningReservation> rowMapper = new DiningRowMapper();
		try {
			diningReservation = jdbcTemplate.queryForObject("SELECT * FROM dining WHERE guest_id = ?",
					new Object[] { guestId }, rowMapper);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return diningReservation;

	}


	@Override
	public ResortReservation getResortDetails(int guestId) {
		ResortReservation resortReservation=null;
		RowMapper<ResortReservation> rowmapper=new ResortRowMapper();
		try{
			resortReservation=jdbcTemplate.queryForObject("SELECT * FROM resort WHERE guest_id = ?",
					new Object[] { guestId }, rowmapper);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return resortReservation;
	}

}
