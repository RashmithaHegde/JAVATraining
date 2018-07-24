package com.reserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reserve.bean.Guest;
import com.reserve.service.LoginService;

@RestController
@RequestMapping("/guest-login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/add-guest", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Integer> addGuestDetails(@RequestBody Guest guest) {
		HttpHeaders headers = new HttpHeaders();
		if (guest == null) {
			return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}
		int guestId = loginService.addGuest(guest);
		headers.add("Guest Created  - ", String.valueOf(guest.getGuestId()));
		return new ResponseEntity<Integer>(guestId, headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("errorMsg", "Your username and password are invalid.");

		if (logout != null)
			model.addAttribute("msg", "You have been logged out successfully.");

		return "login";
	}
	
	
/*	
	@PostMapping("/validate")
	public String validate(Guest g)
	{
		int v =loginService.validateGuest(g.getEmail(),g.getPassword());
		if(v>0)
			return "guest valid";
		return "invalid";
		
	}*/

	
}
