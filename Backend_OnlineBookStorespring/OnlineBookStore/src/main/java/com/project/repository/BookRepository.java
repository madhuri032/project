package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.project.entity.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
