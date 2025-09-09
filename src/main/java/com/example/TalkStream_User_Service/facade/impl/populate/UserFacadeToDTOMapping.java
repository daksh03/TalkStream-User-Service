package com.example.TalkStream_User_Service.facade.impl.populate;

import org.springframework.stereotype.Component;

import com.example.TalkStream_User_Service.dto.UserDTO;
import com.example.TalkStream_User_Service.entity.Users;

@Component
public class UserFacadeToDTOMapping {

	public Users populateUserDetails(UserDTO userDto, Users user) {

		user.setFirstname(userDto.getFirstname());
		user.setLastname(userDto.getLastname());
		user.setPassword(userDto.getPassword());
		user.setUsername(userDto.getUsername());
		
		return user;
	}

}
