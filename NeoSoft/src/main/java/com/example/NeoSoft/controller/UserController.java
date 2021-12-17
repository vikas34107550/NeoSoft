package com.example.NeoSoft.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.NeoSoft.beans.User;
import com.example.NeoSoft.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(method=RequestMethod.POST,path="/registerUser")
	public User registerUser(@Valid @RequestBody User user)
	
	{
		
		User savedUser =service.save(user);
		return savedUser;
	}
	
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	
	public List<User> getUserProfile(@RequestParam("firstName") String firstName,@RequestParam("surName") String surName,@RequestParam("pinCode") String pinCode) {

		return service.searchUser(firstName, surName, pinCode);
		
	}
	
    @RequestMapping(value = "/getUserSorted", method = RequestMethod.GET)
	
	public List<User> getUserProfileSorted() {

		return service.getUserSorted();
		
	}

}
