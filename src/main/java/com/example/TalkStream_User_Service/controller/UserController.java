package com.example.TalkStream_User_Service.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TalkStream_User_Service.dto.UserDTO;
import com.example.TalkStream_User_Service.entity.Users;
import com.example.TalkStream_User_Service.facade.UserFacade;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {

	@Autowired
	private UserFacade userFacade;

	@GetMapping
	public Optional<Users> getUserDetails(@RequestParam String username) {
		return userFacade.getUserDetails(username);

	}

	@PostMapping("/addUser")
	public String addUserDetails(@RequestBody UserDTO userDto) {
		userFacade.insertUser(userDto);
		log.info("User Added successfully");
		return "Added Successfully";
	}
	
	@PutMapping("/editUser/{username}")
	public String editUser(@PathVariable String username, @RequestBody UserDTO userDto) {
		userFacade.editUser(username, userDto);
		log.info("User Details were updated successfully");
		return "Update SuccessFull";
	}
	
	@DeleteMapping("/deleteUser/{username}")
	public String deleteUser(@PathVariable String username) {
		userFacade.deleteUser(username);
		log.info("Deleted User Details");
		return "Delete SuccessFull";
	}

}
