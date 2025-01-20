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


import com.project.dto.UserDTo;

import com.project.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
    public class UserController {
        @Autowired
        private UserService uservice;
        
        
        @PutMapping("userid/{id}")
        public ResponseEntity<Object> update(@Valid @PathVariable("uid") int uid, @RequestBody UserDTo user) throws Exception {
            System.out.println("update user data with id---");
            return uservice.update(uid, user);
        }
        
        //insert data
        @PostMapping("insert")
        public String insertAdminDetail(@Valid @RequestBody UserDTo ad) throws Exception {
            uservice.insertAdminDetail(ad);
            return "Admin details inserted successfully";
        }
        
        //get all data
        @GetMapping("getAllRecords")
        public ResponseEntity<List<UserDTo>> getAdminDetails() {
            List<UserDTo> userRecords = uservice.getAllRecords();
            return ResponseEntity.ok(userRecords);
        }
        
      //find by id
        @GetMapping("search_uid/{uid}")
        public ResponseEntity<Object> findUserById(@PathVariable("uid") int uid) {
    		
    		return uservice.findUserById(uid);
    	}
        
        @DeleteMapping("delete/{uid}")
        public ResponseEntity<Object>deleteById(@PathVariable("uid") int uid){
        	
        	return uservice.deleteById(uid);
        }
           
        
    }



