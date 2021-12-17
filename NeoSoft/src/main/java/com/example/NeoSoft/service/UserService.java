package com.example.NeoSoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NeoSoft.beans.User;
import com.example.NeoSoft.repository.UserRepository;
@Service
public class UserService {

	@Autowired 
	UserRepository userRepository;
	
	public User save(User user)
	{
		User user1=userRepository.save(user);
		return user1;
		
	}
	
	public List<User> searchUser(String firstName,String surName,String pinCode)
	{
		List<User> user=userRepository.findByFirstNameOrSurNameOrPinCode(firstName, surName,pinCode);
		return user;
	}
	
	public List<User> getUserSorted()
	{
		List<User> user=userRepository.findByOrderByDateOfJoiningAsc();
		return user;
	}
}
