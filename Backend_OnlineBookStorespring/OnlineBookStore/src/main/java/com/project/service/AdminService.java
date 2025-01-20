package com.project.service;

import org.springframework.http.ResponseEntity;

import com.project.dto.AdminDTo;

public interface AdminService{
	
	public abstract ResponseEntity<Object>update(int id,AdminDTo ad);
	
	public abstract AdminDTo insertAdminDetail(AdminDTo ad);

	public abstract java.util.List<AdminDTo> getAllRecords();

	public abstract ResponseEntity<Object> findAdminById(int id);

	public abstract ResponseEntity<Object> deleteById(int id);

	
}