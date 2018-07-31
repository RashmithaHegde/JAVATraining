package com.app.SpringBootProject.dao;

import java.util.Date;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.SpringBootProject.bean.Guest;
import com.app.SpringBootProject.bean.GuestRowMapper;

@Repository
public class GuestDaoImpl implements IGuestDao{

	private static final Logger LOGGER = Logger.getLogger("GuestDaoImpl.class");
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	Date date=new Date();

	@Override
	public Guest registerGuest(Guest guest) {
		
		
		
		String query = "INSERT INTO guest(email,first_name,last_name,address,phone,password,created_date,updated_date) VALUES (?,?,?,?,?,?,?,?)";

		try {
		 	jdbcTemplate.update(query, guest.getEmail(), guest.getFirstName(),
					guest.getLastName(), guest.getAddress(), guest.getPhone(), guest.getPassword(),date,date);
		} catch(DataAccessException e) {
			LOGGER.info("DataAccessException occured in register guest. . .!!!");
			return null;
		}
		Guest guest1 = jdbcTemplate.queryForObject("select * from guest where guest_id in(select max(guest_id) from guest);", new GuestRowMapper());
		
			return guest1;
	
	}

	@Override
	public long updateGuest(Guest guest, long guestId) {
		long success;
		String query= "UPDATE guest SET  first_name=?,last_name=?,address=?,phone=?,password=? WHERE guest_id=?";
	
	
		try {
			success = jdbcTemplate.update(query, guest.getFirstName(),
					guest.getLastName(), guest.getAddress(), guest.getPhone(), guest.getPassword(),guestId);
		} catch (DataAccessException e) {
			LOGGER.info("DataAccessException occured in update guest .!!!");
			return 0;
		}
		
				
		return success;
		
	}

	@Override
	public Guest getGuest(long guestId) {
		Guest guest;
		try {
			guest = jdbcTemplate.queryForObject("SELECT * FROM guest WHERE guest_id = ?",
				     new Object[] { guestId }, new GuestRowMapper());
		} catch (DataAccessException e) {
			LOGGER.info("DataAccessException occured in get guest. . .!!!");
			return null;
		}
		return guest;
	}

	@Override
	public Guest validate(String email, String password) {
	
		Guest guest =new Guest();
			try {
			guest= jdbcTemplate.queryForObject("SELECT * FROM guest WHERE email = ? AND password =?",
				     new Object[] { email, password }, new GuestRowMapper());
		} catch (DataAccessException e) {
			LOGGER.info("DataAccessException occured while validating. . .!!!");
			return null;
		}
		
		return guest;
	}

	

	
	
	

}
