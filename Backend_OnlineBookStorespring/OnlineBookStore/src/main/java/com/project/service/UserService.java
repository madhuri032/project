package com.project.service;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.project.dto.UserDTo;

import javax.validation.Valid;

public interface UserService {
	
	public abstract ResponseEntity<Object>update(int id,UserDTo user);

	

	public abstract void insertAdminDetail(@Valid UserDTo ad);



	public abstract List<UserDTo> getAllRecords();



	public abstract ResponseEntity<Object> findUserById(int uid);



	public abstract ResponseEntity<Object> deleteById(int uid);

}
