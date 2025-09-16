package com.example.TalkStream_User_Service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

	private String firstname;

	private String lastname;

	private String username;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format") 
	private String email;

	@NotBlank(message = "Password is required")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$",
	message = "Password must be at least 8 characters long,"
			+ " contain one uppercase, one lowercase, one digit,"
			+ " and one special character")
	private String password;
	
	private String status;

}
