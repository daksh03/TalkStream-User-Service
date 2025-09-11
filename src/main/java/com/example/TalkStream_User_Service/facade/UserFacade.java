package com.example.TalkStream_User_Service.facade;

import java.util.Optional;

import com.example.TalkStream_User_Service.dto.UserDTO;
import com.example.TalkStream_User_Service.entity.Users;

public interface UserFacade {
	
	Optional<Users> getUserDetails(String username);

	String insertUser(UserDTO userDto);

	String editUser(String username, UserDTO userDto);

	void deleteUser(String username);

}
