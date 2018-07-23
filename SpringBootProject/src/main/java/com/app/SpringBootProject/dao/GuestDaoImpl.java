package com.app.SpringBootProject.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.SpringBootProject.bean.Resort;
import com.app.SpringBootProject.bean.ResortRowMapper;

@Transactional
@Repository
public class GuestDaoImpl implements IGuestDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	Date date=new Date();
	java.sql.Date sqlDate = new  java.sql.Date(date.getTime());
	
	static long count =102;
	
	@Override
	public long registerResort(Resort resort) { 
		
		String status="booked";
		
		String query= "INSERT INTO resort(r_reservation_number,guest_id,room_type,arrival_date,departure_date,no_of_people,created_date,updated_date) VALUES (?,?,?,?,?,?,?,?)";
		
		long success=jdbcTemplate.update(query, count++,1,resort.getRoomType(),resort.getArrivalDate(),resort.getDepartureDate(),resort.getNoOfPeople(),date,date);
		
		if(success==1)
		{
			String query1= "UPDATE resort SET status=? ";

			jdbcTemplate.update(query1,status);

		}
		else
			System.out.println("insertion failed, SOMETHING WENT WRONG . . .!!!");
		return count;
	}

	@Override
	public void updateResort(Resort resort,long r_reservation_number) {
		

		String query= "UPDATE resort SET room_type=?, arrival_date=?, departure_date=?,no_of_people=?,updated_date=? WHERE r_reservation_number=?";
		jdbcTemplate.update(query,resort.getRoomType(),resort.getArrivalDate(),resort.getDepartureDate(),resort.getNoOfPeople(),date,r_reservation_number);
				
	}

	@Override
	public Resort getResort(long r_reservation_number) 
	{
		 Resort resort = jdbcTemplate.queryForObject("SELECT * FROM resort WHERE r_reservation_number = ?",
			     new Object[] { r_reservation_number }, new ResortRowMapper());
		return resort;
	}


}
