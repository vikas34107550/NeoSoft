package com.example.NeoSoft.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name="User")
public class User {

	@Id
	@Column(name="userId",length = 32)
	private String userId;
	
    @Size(min=2,message="name should have atleast 2 character")
    
    @Column(name="firstName",length = 32)
	private String firstName;
    
    @Size(min=2,message="Surname should have atleast 2 character")
    @Column(name="surName",length = 32)
	private String surName;
    
    @Column(name="dateOfJoining",length = 32)
    private String dateOfJoining;
 
    @Column(name="datefFBirth",length = 32)
    private String dateOfBirth;
    
    @Column(name="PinCode",length = 32)
    private String pinCode;
 	
    public User() {}
	
	public User(String userId, String firstName, String surName ,String dateOfJoining, String dateOfBirth, String pinCode) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.surName = surName;
		this.dateOfJoining = dateOfJoining;
		this.dateOfBirth = dateOfBirth;
		this.pinCode = pinCode;
	}
	
}

