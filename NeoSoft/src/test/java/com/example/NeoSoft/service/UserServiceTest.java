package com.example.NeoSoft.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.NeoSoft.beans.User;
import com.example.NeoSoft.repository.UserRepository;
import com.example.NeoSoft.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

	@Autowired
	private UserService service;
	
	@MockBean
	private UserRepository repository;
	
	@Test
	public void searchUserTest()
	{
		
		when(repository.findByFirstNameOrSurNameOrPinCode("vikas", "singh", "209312")).thenReturn(Stream.of(new User("1","vikas","Singh",new Date(17/11/2018),new Date(17/11/2018),"209312","Yes"),new User("2","vikas","Singh",new Date(17/11/2018),new Date(17/11/2018),"209312","Yes")).collect(Collectors.toList()));
	
	    assertEquals(2,service.searchUser("vikas","singh","209312").size());
	}
	
	
	@Test
	public void findUserByIdTest()
	{
		Optional<User> user=Optional.of(new User("1","vikas","Singh",new Date(17/11/2018),new Date(17/11/2018),"209312","Yes"));
		when(repository.findById("1")).thenReturn(user);
		assertEquals(user, service.findUserById("1"));

	}
	
	@Test
	public void registerUserTest()
	{
		User user=new User("1","vikas","Singh",new Date(17/11/2018),new Date(17/11/2018),"209312","Yes");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.registerUser(user));

	}
	
	
	
	@Test
	public void getUserSortedDOJTest()
	{
		
		when(repository.findByOrderByDateOfJoiningAsc()).thenReturn(Stream.of(new User("1","vikas","Singh",new Date(17/11/2018),new Date(17/11/2018),"209312","Yes"),new User("2","vikas","Singh",new Date(17/11/2018),new Date(17/11/2018),"209312","Yes")).collect(Collectors.toList()));
		assertEquals(2, service.getUserSortedDOJ().size());

	}
	
	@Test
	public void getUserSortedDOBTest()
	{
		
		when(repository.findByOrderByDateOfBirthAsc()).thenReturn(Stream.of(new User("1","vikas","Singh",new Date(17/11/2018),new Date(17/11/2018),"209312","Yes"),new User("2","vikas","Singh",new Date(17/11/2018),new Date(17/11/2018),"209312","Yes")).collect(Collectors.toList()));
		assertEquals(2, service.getUserSortedDOB().size());

	}
	
	@Test
	public void hardDeleteUserTest()
	{
		
		//User user=new User("1","vikas","Singh","17/11/2018","1/11/2018","209312","Yes");
		service.hardDeleteUser("1");
        verify(repository,times(1)).deleteById("1");
	
	}

}
