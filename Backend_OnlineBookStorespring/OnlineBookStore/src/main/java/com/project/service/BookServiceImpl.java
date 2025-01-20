package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.dao.BookDao;
import com.project.dto.BookDto;

import javax.validation.Valid;
@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bdao;
	
	@Override
	public ResponseEntity<Object> update(@Valid int bookid, BookDto ad) {
		// TODO Auto-generated method stub
		return bdao.update(bookid,ad);
	}
	@Override
	public BookDto insertUserDetail(BookDto ad) {
		// TODO Auto-generated method stub
		return bdao.insertUserDetail(ad);
	}
	@Override
	public List<BookDto> getAllRecords() {
		// TODO Auto-generated method stub
		return bdao.getAllRecords();
	}
	@Override
	public ResponseEntity<Object> findAdminById(int bookid) {
		// TODO Auto-generated method stub
		return bdao.findAdminById(bookid);
	}
	@Override
	public ResponseEntity<Object> deleteById(int bookid) {
		// TODO Auto-generated method stub
		return bdao.deleteById(bookid);
	}

	

}
