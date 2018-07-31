package com.app.SpringBootProject.dao;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.SpringBootProject.bean.Dining;
import com.app.SpringBootProject.bean.DiningRowMapper;

@Transactional
@Repository
public class DiningDaoImpl implements IDiningDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static final Logger LOGGER = Logger.getLogger("DiningDaoImpl.class");
	
	Date date=new Date();
	//java.sql.Date sqlDate = new  java.sql.Date(date.getTime());
	
	

	@Override
	public Dining registerDining(Dining dining,long guestId) {
		
		String status="booked";
		
		String query= "INSERT INTO dining(guest_id,dining_type,arrival_date,no_of_people,created_date,updated_date) VALUES (?,?,?,?,?,?)";
		long success;
		try {
			success=jdbcTemplate.update(query,guestId,dining.getDiningType(),dining.getArrivalDate(),dining.getNoOfPeople(),date,date);
		} catch (DataAccessException e) {
			
			LOGGER.info("DataAccessException occured in register dining. . .!!!");
			return null;
		}
		
		if(success==1)
		{
			String query1= "UPDATE dining SET status=? ";

			jdbcTemplate.update(query1,status);

		}
		
		Dining dining1 = jdbcTemplate.queryForObject("select * from dining where d_reservation_number in(select max(d_reservation_number) from dining);", new DiningRowMapper());
		
		return dining1;
		
		
	}

	@Override
	public long updateDining(Dining dining, long dReservationNumber) {
		
		
		String query= "UPDATE dining SET dining_type=?, arrival_date=?,no_of_people=?,updated_date=? "
				+ "WHERE d_reservation_number=?";
		
		long success;
		
		try {
			success = jdbcTemplate.update(query,dining.getDiningType(),dining.getArrivalDate(),dining.getNoOfPeople(),
					date,dReservationNumber);
		} catch (DataAccessException e) {
			LOGGER.info("DataAccessException occured in update dining. . .!!!");
			return 0;
		}
			
		return success;
		
		
	}

	@Override
	public Dining getDining(long dReservationNumber) {
	
		Dining dining;
		
			try {
				dining = jdbcTemplate.queryForObject("SELECT * FROM dining WHERE d_reservation_number = ?",
					     new Object[] { dReservationNumber }, new DiningRowMapper());
			} catch (DataAccessException e) {
				LOGGER.info("DataAccessException occured in get dining. . .!!!");
				return null;
			}
		
		return dining;
	}

	@Override
	public List<Dining> getAllDining(long guestId) {
		String query="SELECT * FROM DINING WHERE guest_id="+guestId+"";
		List<Dining> dining;
		try {
			dining = jdbcTemplate.query(query,new DiningRowMapper());
		} catch (DataAccessException e) {
			LOGGER.info("DataAccessException occured in get All Dining. . .!!!");
			return null;

		}
		return dining;
	
	}

	@Override
	public long cancelDining(long dReservationNumber) {
		String status = "cancelled";
		long success;
		
		String query1 = "UPDATE dining SET status=? where d_reservation_number="+dReservationNumber+"";
		
		try {
			
			success = jdbcTemplate.update(query1,status);
			
		} catch (Exception e) {
			LOGGER.info("DataAccessException occured in cancel dining. . .!!!");
			return 0;
		}
		if(success==1)
		{
			return dReservationNumber;
		}
		return 0;
		
	}
	
	

}
