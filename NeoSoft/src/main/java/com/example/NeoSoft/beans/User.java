package com.example.NeoSoft.beans;
import java.util.Date;

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
	@Column(name="userId")
	private String userId;
	
    @Size(min=2,message="name should have atleast 2 character")
    @Column(name="firstName")
	private String firstName;
    
    @Size(min=2,message="Surname should have atleast 2 character")
    @Column(name="surName")
	private String surName;
    
    @Column(name="dateOfJoining")
    private Date dateOfJoining;
 
    @Column(name="datefFBirth")
    private Date dateOfBirth;
    
    @Column(name="PinCode")
    private String pinCode;
 	
	
	public User(String userId, String firstName, String surName ,Date dateOfJoining, Date dateOfBirth, String pinCode) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.surName = surName;
		this.dateOfJoining = dateOfJoining;
		this.dateOfBirth = dateOfBirth;
		this.pinCode = pinCode;
	}
	
}

