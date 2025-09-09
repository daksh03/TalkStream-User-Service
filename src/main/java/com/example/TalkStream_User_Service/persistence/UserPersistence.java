package com.example.TalkStream_User_Service.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TalkStream_User_Service.entity.Users;

@Repository
public interface UserPersistence extends JpaRepository<Users, String> {
	Optional<Users> findByUsername(String userName);

}
