package com.app.SpringBootProject.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.SpringBootProject.bean.Guest;
import com.app.SpringBootProject.bean.GuestRowMapper;

@Repository
public class GuestDaoImpl implements IGuestDao{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	Date date=new Date();

	@Override
	public long registerGuest(Guest guest) {
		
		 long	success;
		// long id=0;
		String query = "INSERT INTO guest(email,first_name,last_name,address,phone,password,created_date,updated_date) VALUES (?,?,?,?,?,?,?,?)";

		try {
		 	success= jdbcTemplate.update(query, guest.getEmail(), guest.getFirstName(),
					guest.getLastName(), guest.getAddress(), guest.getPhone(), guest.getPassword(),date,date);
		} catch(Exception e) {
			return 0;
		}
		
			return success;
	
	}

	@Override
	public long updateGuest(Guest guest, long guestId) {
		long success;
		String query= "UPDATE guest SET email=?, first_name=?,last_name=?,address=?,phone=?,password=? WHERE guest_id=?";
	
	
		try {
			success = jdbcTemplate.update(query,guest.getEmail(), guest.getFirstName(),
					guest.getLastName(), guest.getAddress(), guest.getPhone(), guest.getPassword(),guestId);
		} catch (DataAccessException e) {
			return 0;
		}
				
		return success;
		
	}

	@Override
	public Guest getGuest(long guestId) {
		Guest guest = jdbcTemplate.queryForObject("SELECT * FROM guest WHERE guest_id = ?",
			     new Object[] { guestId }, new GuestRowMapper());
		return guest;
	}

	@Override
	public long validate(String email, String password) {
	
		Guest guest =new Guest();
		
	    guest=null;
	    long guestId=0;
		try {
			guest= jdbcTemplate.queryForObject("SELECT * FROM guest WHERE email = ? AND password =?",
				     new Object[] { email, password }, new GuestRowMapper());
		} catch (DataAccessException e) {
			
			return 0;
		}
		
		if(guest!=null)
		{
			guestId= guest.getguestId();
		}
		
		
		return guestId;
	}

	

	
	
	

}
