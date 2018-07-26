package com.app.SpringBootProject.GuestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	@PostMapping("/guest/register")
	public String Register(@RequestBody Guest guest)
	{
		
		long status=0;
		status=service.registerGuest(guest);
		//to get guest Id
		long guestId=service.validate(guest.getEmail(), guest.getPassword());
		
		if(status>0)
		{
			return "Registered successfully. Your guest Id is: " + guestId;
		}
		else
		{
			return "Registration Failed.....Please try later";
		}
	}
	
	
 
	@PutMapping("/guest/update/{guestId}")
	public String updateGuest(@PathVariable long guestId  ,@RequestBody Guest guest)
	{
		
		long status=service.updateGuest(guest, guestId);
		
		if(status==1)
		{
			return "updated successfullly with guest id:" +guestId;
		}
			
			return "Guest Id does not exits";
		
	}
	
	@GetMapping("/guest/get/{guestId}")
	public Guest getResort(@PathVariable long guestId )
	{
		Guest guest=service.getGuest(guestId);
		return guest;
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
