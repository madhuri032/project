package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.dao.UserDao;

import com.project.dto.UserDTo;

import javax.validation.Valid;

@Service

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao  userdao;
	@Override
	public ResponseEntity<Object> update(int id, UserDTo user) {
		// TODO Auto-generated method stub
		return userdao.update(id,user);
	}
	@Override
	public void insertAdminDetail(@Valid UserDTo ad) {
		// TODO Auto-generated method stub
		userdao.insertAdminDetail(ad);
	}
	@Override
	public List<UserDTo> getAllRecords() {
		// TODO Auto-generated method stub
		return userdao.getAllRecords();
	}
	@Override
	public ResponseEntity<Object> findUserById(int uid) {
		// TODO Auto-generated method stub
		return userdao.findUserById(uid);
	}
	@Override
	public ResponseEntity<Object> deleteById(int uid) {
		// TODO Auto-generated method stub
		return userdao.deleteById(uid);
	}
	
}
