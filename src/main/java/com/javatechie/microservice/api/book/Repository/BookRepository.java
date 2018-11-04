package com.javatechie.microservice.api.book.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatechie.microservice.api.book.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
