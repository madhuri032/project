package com.project.dto;

import javax.persistence.Column;
import lombok.Data;

@Data

public class BookDto {
	
	
	 @Column(name = "bookid")
		private int bookid;
		  @Column(name = "booktitle")
		private String booktitle;
		  @Column(name = "bookauthor")
		private String bookauthor;
		  @Column(name = "genre")
		private String genre;
		  @Column(name = "isbn")
		private String isbn;
		  @Column(name = "bookprice")
		private double bookprice;
		  @Column(name = "stock")
		private int stock;
		  @Column(name = "publisher")
		private String publisher;
		  @Column(name = "publicationDate")
		private String publicationDate;
		  @Column(name = "description")
		private String description;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	public String getBookauthor() {
		return bookauthor;
	}
	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getBookprice() {
		return bookprice;
	}
	public void setBookprice(double bookprice) {
		this.bookprice = bookprice;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "BookDto [bookid=" + bookid + ", booktitle=" + booktitle + ", bookauthor=" + bookauthor + ", genre="
				+ genre + ", isbn=" + isbn + ", bookprice=" + bookprice + ", stock=" + stock + ", publisher="
				+ publisher + ", publicationDate=" + publicationDate + ", description=" + description + "]";
	}
	
	
	
}
