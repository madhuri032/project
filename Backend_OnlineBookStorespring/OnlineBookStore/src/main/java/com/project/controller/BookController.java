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


import com.project.dto.BookDto;
import com.project.service.BookService;

import javax.validation.Valid;

@RestController
@RequestMapping("book")
public class BookController {
	
	@Autowired
	private BookService bservice;
	
	  //update data
    @PutMapping("id/{id}")
    public ResponseEntity<Object> update(@Valid @PathVariable("bookid") int bookid, @RequestBody BookDto ad) throws Exception {
        System.out.println("update admin data with id---");
        return bservice.update(bookid, ad);
    }
    
    //insert data
    @PostMapping("insert")
    public String insertUserDetail(@Valid @RequestBody BookDto ad) throws Exception {
        bservice.insertUserDetail(ad);
        return "Book details inserted successfully";
    }
    
    //get all data
    @GetMapping("getAllRecords")
    public ResponseEntity<List<BookDto>> getAdminDetails() {
    	
        List<BookDto> bookRecords = bservice.getAllRecords();
        
        return ResponseEntity.ok(bookRecords);
    }
    
    //find by id
    @GetMapping("search_id/{bookid}")
    public ResponseEntity<Object> findAdminById(@PathVariable("bookid") int bookid) {
		
		return bservice.findAdminById(bookid);
	}
    
    @DeleteMapping("delete/{bookid}")
    public ResponseEntity<Object>deleteById(@PathVariable("bookid") int bookid){
    	
    	return bservice.deleteById(bookid);
    }
	
}
