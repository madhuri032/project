package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.AdminDTo;
import com.project.service.AdminService;

import javax.validation.Valid;

@RestController
@RequestMapping("Admin")
public class AdminController {

    @Autowired
    private AdminService aservice;
    
    //update data
    @PutMapping("id/{id}")
    public ResponseEntity<Object> update(@Valid @PathVariable("id") int id, @RequestBody AdminDTo ad) throws Exception {
        System.out.println("update admin data with id---");
        return aservice.update(id, ad);
    }
    
    //insert data
    @PostMapping("insert")
    public String insertAdminDetail(@Valid @RequestBody AdminDTo ad) throws Exception {
        aservice.insertAdminDetail(ad);
        return "Admin details inserted successfully";
    }
    
    //get all data
    @GetMapping("getAllRecords")
    public ResponseEntity<List<AdminDTo>> getAdminDetails() {
        List<AdminDTo> adminRecords = aservice.getAllRecords();
        return ResponseEntity.ok(adminRecords);
    }
    
    //find by id
    @GetMapping("search_id/{id}")
    public ResponseEntity<Object> findAdminById(@PathVariable("id") int id) {
		
		return aservice.findAdminById(id);
	}
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object>deleteById(@PathVariable("id") int id){
    	
    	return aservice.deleteById(id);
    }
    
    
}
