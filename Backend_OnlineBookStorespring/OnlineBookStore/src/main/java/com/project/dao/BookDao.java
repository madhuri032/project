package com.project.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.project.dto.BookDto;
import com.project.entity.Book;
import com.project.repository.BookRepository;

import javax.validation.Valid;

@Repository
public class BookDao {
	
	@Autowired
	private ModelMapper mp;
	
	@Autowired
	private BookRepository brepo;

	 public ResponseEntity<Object> update(@Valid int bookid, BookDto bookDto) {
	        // Check if the book with the given bookid exists
	        if (!brepo.existsById(bookid)) {
	            // If not, return a NOT FOUND response
	            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
	        }

	        // Convert the BookDto to the Book entity
	        Book book = mp.map(bookDto, Book.class);
	        
	        // Set the book id (to update the existing record)
	        book.setBookid(bookid);

	        // Save the updated book entity to the repository
	        brepo.save(book);

	        // Return a success response with a message
	        return new ResponseEntity<>("Book updated successfully", HttpStatus.OK);
	    }

	

	 public BookDto insertUserDetail(BookDto bookDto) {
	        // Convert BookDto to Book entity
	        Book book = mp.map(bookDto, Book.class);

	        // Save the Book entity to the database
	        Book savedBook = brepo.save(book);

	        // Convert saved Book entity back to BookDto
	        return mp.map(savedBook, BookDto.class);
	    }



	 public List<BookDto> getAllRecords() {
	        // Fetch all books from the repository
	        List<Book> books = brepo.findAll();

	        // Convert the list of Book entities to a list of BookDto using ModelMapper
	        return books.stream()
	                    .map(book -> mp.map(book, BookDto.class))
	                    .collect(Collectors.toList());
	    }



	 public ResponseEntity<Object> findAdminById(int bookid) {
	        // Find the book by ID
	        Book book = brepo.findById(bookid).orElse(null);

	        // If the book is not found, return a 404 response
	        if (book == null) {
	            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
	        }

	        // Map the found book entity to BookDto
	        BookDto bookDto = mp.map(book, BookDto.class);

	        // Return the BookDto in the response with a 200 status
	        return new ResponseEntity<>(bookDto, HttpStatus.OK);
	    }


	 public ResponseEntity<Object> deleteById(int bookid) {
	        // Check if the book exists by its ID
	        if (!brepo.existsById(bookid)) {
	            // If the book is not found, return 404 Not Found
	            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
	        }

	        // Proceed to delete the book
	        brepo.deleteById(bookid);

	        // Return a success message with 200 OK status
	        return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
	    }
}
