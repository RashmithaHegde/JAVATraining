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

import com.app.SpringBootProject.bean.Resort;
import com.app.SpringBootProject.service.IResortService;

@RestController

public class ResortController {
	
	@Autowired
	IResortService service;
	
	@PostMapping("/resort/register/{guest_id}")
	public ResponseEntity<Resort> Register(@PathVariable long guest_id, @RequestBody Resort resort)
	{
		//long status=0;
		
		
		Resort resort1=service.registerResort(resort,guest_id);
		if(resort1!=null)
		{
			
			return new ResponseEntity<Resort>(resort1,HttpStatus.CREATED);
		}
		return new ResponseEntity<Resort>(HttpStatus.BAD_REQUEST);
	}
	
	
	
	
 
	@PutMapping("/resort/update/{r_reservation_number}")
	public ResponseEntity<Resort> updateResort(@PathVariable long r_reservation_number  ,@RequestBody Resort resort)
	{
		long status=0;
		
			status=service.updateResort(resort,r_reservation_number);
			
			Resort resort1=service.getResort(r_reservation_number);
		if(status>0)
		{
			return new ResponseEntity<Resort>(resort1, HttpStatus.CREATED);
		}
		return new ResponseEntity<Resort>(HttpStatus.BAD_REQUEST);
		
		
	}
	
	@GetMapping("/resort/get/{r_reservation_number}")
	public ResponseEntity<Resort> getResort(@PathVariable long r_reservation_number )
	{
		Resort resort=service.getResort(r_reservation_number);
		if(resort!=null)
		{
			
			return new ResponseEntity<Resort>(resort,HttpStatus.CREATED);
		}
		return new ResponseEntity<Resort>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/resort/getall/{guest_id}")
	public List<Resort> getAllResort(@PathVariable long guest_id )
	{
		List<Resort> resort=service.getAllResort(guest_id);
		return resort;
	}
	
	@PutMapping("/resort/cancel/{r_reservation_number}")
	public ResponseEntity<Resort> cancelResort(@PathVariable long r_reservation_number)
	{
		long success=0;
		success=service.cancelResort(r_reservation_number);
		
		if(success>0)
		{
			return new ResponseEntity<Resort>( HttpStatus.CREATED);
		}
		else
		return new ResponseEntity<Resort>(HttpStatus.BAD_REQUEST);
		
		
		
	}
	
}
