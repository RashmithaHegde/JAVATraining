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
		ResortReservation resortReservation = null;
		RowMapper<ResortReservation> rowmapper = new ResortRowMapper();
		try {
			resortReservation = jdbcTemplate.queryForObject("SELECT * FROM resort WHERE guest_id = ?",
					new Object[] { guestId }, rowmapper);

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return resortReservation;
	}

	@Override
	public DiningReservation cancelDining(int diningReservationNum) {
		DiningReservation diningReservation = null;
		RowMapper<DiningReservation> rowMapper = new DiningRowMapper();
		int count = 0;
		try {
			count = jdbcTemplate.update("UPDATE dining set status = ? where d_reservation_number = ?",
					new Object[] { "CANCELED", diningReservationNum });
			if (count != 0) {
				diningReservation = jdbcTemplate.queryForObject("SELECT * FROM dining WHERE d_reservation_number = ?",
						new Object[] { diningReservationNum }, rowMapper);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return diningReservation;
	}

	@Override
	public ResortReservation cancelResort(int resortReservationNum) {
		ResortReservation resortReservation = null;
		RowMapper<ResortReservation> rowMapper = new ResortRowMapper();
		int count = 0;
		try {
			count = jdbcTemplate.update("UPDATE resort set status = ? where r_reservation_number = ?",
					new Object[] { "CANCELED", resortReservationNum });
			if (count != 0) {
				resortReservation = jdbcTemplate.queryForObject("SELECT * FROM resort WHERE r_reservation_number = ?",
						new Object[] { resortReservationNum }, rowMapper);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resortReservation;
	}

}
