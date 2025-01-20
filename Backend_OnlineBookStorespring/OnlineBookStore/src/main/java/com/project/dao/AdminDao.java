package com.project.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.project.dto.AdminDTo;
import com.project.entity.Admin;
import com.project.repository.AdminRepository;

import javax.transaction.Transactional;

@Repository

public class AdminDao {

    @Autowired
    private ModelMapper mp;

    @Autowired
    private AdminRepository jpt;
    @Transactional
    public ResponseEntity<Object> update(int id, AdminDTo ad) {
        Optional<Admin> data = jpt.findById(id);

        if (data.isEmpty()) {
            return new ResponseEntity<>("Admin not found", HttpStatus.NOT_FOUND);
        }

        Admin admin = data.get();

        // Update admin details using the DTO
        admin.setName(ad.getName());
        admin.setEmail(ad.getEmail());
        // Update other fields as needed

        jpt.save(admin); // Persist the updated entity

        return new ResponseEntity<>("Admin updated successfully", HttpStatus.OK);
    }
    
    @Transactional
    public AdminDTo insertAdminDetail(AdminDTo ad) {
        Admin admin = mp.map(ad, Admin.class);
        Admin savedAdmin = jpt.save(admin);
        return mp.map(savedAdmin, AdminDTo.class);
    }

    public List<AdminDTo> getAllRecords() {
        List<Admin> adminEntities = jpt.findAll();
        return adminEntities.stream()
                            .map(admin -> mp.map(admin, AdminDTo.class))
                            .collect(Collectors.toList());
    }

    public ResponseEntity<Object> findAdminById(int id) {
        Optional<Admin> adminOpt = jpt.findById(id);

        if (adminOpt.isPresent()) {
            AdminDTo adminDto = mp.map(adminOpt.get(), AdminDTo.class);
            return ResponseEntity.ok(adminDto);
        } else {
            return new ResponseEntity<>("Admin not found", HttpStatus.NOT_FOUND);
        }
    }
    
    
    public ResponseEntity<Object> deleteById(int id) {
        if (jpt.existsById(id)) {
            jpt.deleteById(id);
            return new ResponseEntity<>("Admin deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Admin not found", HttpStatus.NOT_FOUND);
        }
    }
}
