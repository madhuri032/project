package com.project.service;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.project.dto.BookDto;

import javax.validation.Valid;

public interface BookService {

	public ResponseEntity<Object> update(@Valid int bookid, BookDto ad);

	public abstract BookDto insertUserDetail(BookDto ad);



	public List<BookDto> getAllRecords();

	public ResponseEntity<Object> findAdminById(int bookid);

	public ResponseEntity<Object> deleteById(int bookid);

}
