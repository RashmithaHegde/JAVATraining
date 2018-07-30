package com.app.SpringBootProject.GuestController;

import java.util.ArrayList;
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
import com.app.SpringBootProject.bean.Guest;
import com.app.SpringBootProject.bean.Resort;
import com.app.SpringBootProject.service.IDiningService;
import com.app.SpringBootProject.service.IGuestService;
import com.app.SpringBootProject.service.IResortService;


@RestController

public class GuestController {
	
	@Autowired
	IGuestService service;
	
	@Autowired
	IDiningService diningService;
	
	@Autowired
	IResortService resortService;
	
	@PostMapping("/guest/login")
	public String login(@RequestBody Guest guest)
	{
		
	  long guestId=service.validate(guest.getEmail(), guest.getPassword());
	  
	  if(guestId==0)
	  {
		  return "Please register yourself before login.";
	  }
	
	return "You have logged in successfully. Your guest id is "+guestId;
		
	}
	/*@PostMapping("/guest/login")
	public ResponseEntity<Guest> login(@RequestBody Guest guest)
	{
		
	  long guestId=service.validate(guest.getEmail(), guest.getPassword());
	  
	  if(guestId==0)
	  {
		  return new ResponseEntity<Guest>(HttpStatus.NOT_FOUND);
	  }
	  return new ResponseEntity<Guest>(guest,HttpStatus.CREATED);
	 
		
	}*/
	
	
	@PostMapping("/guest/register")
	public ResponseEntity<Guest> Register(@RequestBody Guest guest)
	{
		
		
		Guest guest1=service.registerGuest(guest);
		if(guest1!=null)
		{
			return new ResponseEntity<Guest>(guest1,HttpStatus.CREATED);
		}
		return new ResponseEntity<Guest>(HttpStatus.NOT_FOUND);
	}
	
	
 
	@PutMapping("/guest/update/{guestId}")
	public ResponseEntity<Guest> updateGuest(@PathVariable long guestId  ,@RequestBody Guest guest)
	{
		
		long status=service.updateGuest(guest, guestId);
		Guest guest1=service.getGuest(guestId);
		if(status>0)
		{
			return new ResponseEntity<Guest>(guest1, HttpStatus.CREATED);
		}
		return new ResponseEntity<Guest>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/guest/get/{guestId}")
	public ResponseEntity<Guest> getResort(@PathVariable long guestId )
	{
		Guest guest;
		
			guest = service.getGuest(guestId);
			if(guest!=null)
			{
				
				return new ResponseEntity<Guest>(guest,HttpStatus.CREATED);
			}
			return new ResponseEntity<Guest>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/guest/view/{guestId}")
	public List viewItenarary(@PathVariable long guestId)
	{
		List list = new ArrayList<>();
		
		List<Resort> resort = resortService.getAllResort(guestId);
		List<Dining> dining = diningService.getAllDining(guestId);
		
		list.add(resort);
		list.add(dining);
		return list;
		
		
		
	}
	
}
