package com.example.NeoSoft.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NeoSoft.beans.User;

@Repository
	public interface UserRepository extends JpaRepository<User, String> {
		
		User findByuserId(String userId);

	

}
