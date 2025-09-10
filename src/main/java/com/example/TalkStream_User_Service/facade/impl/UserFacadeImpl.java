package com.example.TalkStream_User_Service.facade.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TalkStream_User_Service.dto.UserDTO;
import com.example.TalkStream_User_Service.entity.Users;
import com.example.TalkStream_User_Service.facade.UserFacade;
import com.example.TalkStream_User_Service.facade.impl.populate.UserFacadeToDTOMapping;
import com.example.TalkStream_User_Service.persistence.UserPersistence;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserFacadeImpl implements UserFacade{

	@Autowired
	private UserPersistence userPersistence;
	
	@Autowired
	private UserFacadeToDTOMapping userMapping;
	
	@Override
	public Optional<Users> getUserDetails(String username) {
		return userPersistence.findByUsername(username);
	}

	@Override
	public void insertUser(UserDTO userDto) {
		 if (userPersistence.findById(userDto.getUsername()).isPresent()) {
		        log.error("User with this id already exists");
		        return;
		    }
		Users user = new Users();
		user = userMapping.populateUserDetails(userDto, user);
		userPersistence.save(user);
		
	}

	@Override
	public void editUser(String username, UserDTO userDto) {
		Users existingUser = userPersistence.findById(username)
				.orElseThrow(() -> new RuntimeException("User not Found"));
		existingUser=userMapping.populateUserDetails(userDto, existingUser);
		userPersistence.save(existingUser);
		
	}

	@Override
	public void deleteUser(String username) {
		Users user = userPersistence.findById(username)
		        .orElseThrow(() -> new RuntimeException("User not found"));
		userPersistence.delete(user);
	}

}
