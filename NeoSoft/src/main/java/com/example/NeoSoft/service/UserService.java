package com.example.NeoSoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NeoSoft.beans.User;
import com.example.NeoSoft.repository.UserRepository;
@Service
public class UserService {

	@Autowired 
	UserRepository userRepository;
	
	public Optional<User> findUserById(String id)
	{
		Optional<User> user1=userRepository.findById(id);
		return user1;
		
	}
	
	public User registerUser(User user)
	{
		User user1=userRepository.save(user);
		return user1;
		
	}
	
	public List<User> searchUser(String firstName,String surName,String pinCode)
	{
		List<User> user=userRepository.findByFirstNameOrSurNameOrPinCode(firstName, surName,pinCode);
		return user;
	}
	
	public List<User> getUserSortedDOJ()
	{
		List<User> user=userRepository.findByOrderByDateOfJoiningAsc();
		return user;
	}
	
	public List<User> getUserSortedDOB()
	{
		List<User> user=userRepository.findByOrderByDateOfBirthAsc();
		return user;
	}
	
	public void hardDeleteUser(String id)
	{
		userRepository.deleteById(id); 
		
	}
	
	public void softDeleteUser(String id)
	{
		Optional<User> user=userRepository.findById(id); 
		if(user.isPresent())
		{
		user.get().setDeleteFlag("Y");
		userRepository.save(user.get());
	    }
		
		
		
	}
	
	public void editUser(User user)
	{
		Optional<User> user1=userRepository.findById(user.getUserId()); 
		if(user1.isPresent())
		{
			user1.get().setFirstName(user.getFirstName());
	   		user1.get().setSurName(user.getSurName());
	   		user1.get().setDateOfBirth(user.getDateOfBirth());
	   		user1.get().setDateOfJoining(user.getDateOfJoining());
	   		user1.get().setPinCode(user.getPinCode());
	   		user1.get().setDeleteFlag(user.getDeleteFlag());
	   		
	   		userRepository.save(user1.get());
	    }
		
		
		
	}
	
}
