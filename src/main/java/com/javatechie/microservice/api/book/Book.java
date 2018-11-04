package com.javatechie.microservice.api.book;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book_tb_2")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	@Id
	private int id;
	private String name;
}
