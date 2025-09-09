package com.example.TalkStream_User_Service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "UsersTalkStream")
public class Users {
	
	@Id
	@Column(name = "user_name")
	private String username;

    @Column(name = "first_name") 
    private String firstname;

    @Column(name = "last_name")
    private String lastname;
    
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
	

}
