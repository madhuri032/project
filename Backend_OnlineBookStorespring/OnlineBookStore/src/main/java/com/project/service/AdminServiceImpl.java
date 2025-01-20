package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.dao.AdminDao;
import com.project.dto.AdminDTo;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adao;

    @Override
    public ResponseEntity<Object> update(int id, AdminDTo ad) {
        return adao.update(id, ad);
    }

    @Override
    public AdminDTo insertAdminDetail(AdminDTo ad) {
        return adao.insertAdminDetail(ad);
    }

	@Override
	public List<AdminDTo> getAllRecords() {
		// TODO Auto-generated method stub
		return adao.getAllRecords();
	}

	@Override
	public ResponseEntity<Object> findAdminById(int id) {
		
		return adao.findAdminById(id);
	}

	@Override
	public ResponseEntity<Object> deleteById(int id) {
		// TODO Auto-generated method stub
		return adao.deleteById(id);
	}
}
