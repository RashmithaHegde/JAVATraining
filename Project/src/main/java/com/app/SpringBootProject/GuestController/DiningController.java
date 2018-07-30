package com.app.SpringBootProject.GuestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.SpringBootProject.bean.Dining;
import com.app.SpringBootProject.bean.Resort;
import com.app.SpringBootProject.service.IDiningService;

@RestController
public class DiningController {
	
	@Autowired
	IDiningService service;
	
	@PostMapping("/dining/register/{guestId}")
	public ResponseEntity<Dining> Register(@PathVariable long guestId,@RequestBody Dining dining)
	{
	
		Dining dining1 = service.registerDining(dining,guestId);
		
		if(dining1!=null)
		{
			return new ResponseEntity<Dining>(dining1, HttpStatus.CREATED);
		}
		return new ResponseEntity<Dining>(HttpStatus.BAD_REQUEST);
	}
 
	@PutMapping("/dining/update/{dReservationNumber}")
	public ResponseEntity<Dining> updateDining(@PathVariable long dReservationNumber,@RequestBody Dining dining)
	{
		
		long status=0;
		
		
			status = service.updateDining(dining, dReservationNumber);
			Dining dining1=service.getDining(dReservationNumber);
		
			if(status!=0)
			{
				return new ResponseEntity<Dining>(dining1, HttpStatus.CREATED);
			}
			return new ResponseEntity<Dining>(HttpStatus.BAD_REQUEST);
		
		
	}
	
	@GetMapping("/dining/get/{dReservationNumber}")
	public ResponseEntity<Dining> getDining(@PathVariable long dReservationNumber )
	{
		Dining dining;
		
			dining = service.getDining(dReservationNumber);
			if(dining!=null)
			{
				
				return new ResponseEntity<Dining>(dining,HttpStatus.CREATED);
			}
			else
			return new ResponseEntity<Dining>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/dining/getall/{guest_id}")
	public List<Dining> getAllDining(@PathVariable long guest_id )
	{
		List<Dining> dining;
		try {
			dining = service.getAllDining(guest_id);
		} catch (Exception e) {
			return null;
		}
		return dining;
	}
	
	@PutMapping("/dining/cancel/{dReservationNumber}")
	public ResponseEntity<Dining> cancelDining(@PathVariable long dReservationNumber)
	{
		long success=0;
		success=service.cancelDining(dReservationNumber);
		

		if(success>0)
		{
			return new ResponseEntity<Dining>( HttpStatus.CREATED);
		}
		else
		return new ResponseEntity<Dining>(HttpStatus.BAD_REQUEST);
	}
	
	

}
