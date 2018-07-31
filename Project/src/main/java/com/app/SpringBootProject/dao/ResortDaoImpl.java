package com.app.SpringBootProject.dao;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.SpringBootProject.bean.Resort;
import com.app.SpringBootProject.bean.ResortRowMapper;

@Transactional
@Repository
public class ResortDaoImpl implements IResortDao {

	private static final Logger LOGGER = Logger.getLogger("ResortDaoImpl.class");
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	Date date = new Date();
	
	@Override
	public Resort registerResort(Resort resort,long guestId) {

		
		String status = "booked";

		String query = "INSERT INTO resort(guest_id,room_type,arrival_date,departure_date,no_of_people,created_date,updated_date) VALUES (?,?,?,?,?,?,?)";

		long success;
		try {
			success = jdbcTemplate.update(query, guestId, resort.getRoomType(), resort.getArrivalDate(),
					resort.getDepartureDate(), resort.getNoOfPeople(), date, date);
		} catch (DataAccessException e) {
			LOGGER.info("DataAccessException occured in register resort. . .!!!");
			return null;
		}
		if (success == 1) {
			String query1 = "UPDATE resort SET status=? ";

			jdbcTemplate.update(query1, status);

		} 

		Resort resort1 = jdbcTemplate.queryForObject("select * from resort where rReservationNumber in(select max(rReservationNumber) from resort);", new ResortRowMapper());
		
		return resort1;
	}

	@Override
	public long updateResort(Resort resort, long rReservationNumber) {

		long success;
		
		String query = "UPDATE resort SET room_type=?, arrival_date=?, departure_date=?,no_of_people=?,updated_date=? WHERE rReservationNumber=?";
		try {
			success=jdbcTemplate.update(query, resort.getRoomType(), resort.getArrivalDate(), resort.getDepartureDate(),
					resort.getNoOfPeople(), date, rReservationNumber);
		} catch (DataAccessException e) {
			LOGGER.info("DataAccessException occured in update resort. . .!!!");
			return 0;
		}
		return success;
	}

	@Override
	public Resort getResort(long rReservationNumber) {
		Resort resort;
		try {
			resort = jdbcTemplate.queryForObject("SELECT * FROM resort WHERE rReservationNumber = ?",
					new Object[] { rReservationNumber }, new ResortRowMapper());
		} catch (DataAccessException e) {
			LOGGER.info("DataAccessException occured in get resort. . .!!!");
			return null;
		}
		return resort;
	}

	@Override
	public List<Resort> getAllResort(long guestId) {
		String query = "SELECT * FROM RESORT WHERE guest_id=" + guestId + "";
		List<Resort> resort;
		try {
			resort = jdbcTemplate.query(query, new ResortRowMapper());
		} catch (DataAccessException e) {
			LOGGER.info("DataAccessException occured in get All resort. . .!!!");
			return null;
		}
		return resort;
	}

	@Override
	public long cancelResort(long rReservationNumber) {

		String status = "cancelled";
		long success=0;

		String query1 = "UPDATE resort SET status=? where rReservationNumber="+rReservationNumber+"";

		try {
			success=jdbcTemplate.update(query1, status);
		} catch (DataAccessException e) {
			LOGGER.info("DataAccessException occured in cancel resort. . .!!!");
			return 0;
		}
		
		if(success==1)
		{
			return rReservationNumber;
		}
		return 0;

	}

}
