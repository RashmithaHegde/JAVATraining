package com.app.SpringBootProject.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.SpringBootProject.bean.Guest;
import com.app.SpringBootProject.bean.GuestRowMapper;

@Repository
public class GuestDaoImpl implements IGuestDao{
	@Autowired
	JdbcTemplate jdbcTemplate;
	//static int count=101;
	
	Date date=new Date();
	//java.sql.Date sqlDate = new  java.sql.Date(date.getTime());

	@Override
	public void registerGuest(Guest guest) {
		String query = "INSERT INTO guest(email,first_name,last_name,address,phone,password,created_date,updated_date) VALUES (?,?,?,?,?,?,?,?)";

		 jdbcTemplate.update(query, guest.getEmail(), guest.getFirstName(),
				guest.getLastName(), guest.getAddress(), guest.getPhone(), guest.getPassword(),date,date);
	
	}

	@Override
	public void updateGuest(Guest guest, long guestId) {
		String query= "UPDATE guest SET email=?, first_name=?,last_name=?,address=?,phone=?,password=? WHERE guest_id=?";
		jdbcTemplate.update(query,guest.getEmail(), guest.getFirstName(),
				guest.getLastName(), guest.getAddress(), guest.getPhone(), guest.getPassword(),guestId);
				
		
		
	}

	@Override
	public Guest getGuest(long guestId) {
		Guest guest = jdbcTemplate.queryForObject("SELECT * FROM guest WHERE guest_id = ?",
			     new Object[] { guestId }, new GuestRowMapper());
		return guest;
	}
	
	

}
