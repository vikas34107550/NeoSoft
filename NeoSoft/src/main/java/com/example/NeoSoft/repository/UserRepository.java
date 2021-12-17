package com.example.NeoSoft.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.NeoSoft.beans.User;

@Repository
	public interface UserRepository extends JpaRepository<User, String> {
		
	 public List<User> findByFirstNameOrSurNameOrPinCode(@Param("firstName") String firstName, @Param("surName") String surName,@Param("pinCode") String pinCode);
     

	 public  List<User> findByOrderByDateOfJoiningAsc();
		 
	

}
