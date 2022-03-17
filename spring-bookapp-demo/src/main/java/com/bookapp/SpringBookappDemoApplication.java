package com.bookapp;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringBookappDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBookappDemoApplication.class, args);
	}

	@Autowired
	IBookService bookService;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("All Books");
		bookService.getAll().forEach(System.out::println);
		System.out.println();
		System.out.println("Books By Author");
		try {
			List<Book> booksByAuthor = bookService.getByAuthor("Steve");
			for (Book book : booksByAuthor) {
				System.out.println(book);
			}
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		System.out.println("Books By Category");
		try {
			List<Book> booksByCategory = bookService.getByCategory("Tech");
			for (Book book : booksByCategory) {
				System.out.println(book);
			}
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Book By Id");
		try {
			Book nbook = bookService.getById(5);
			System.out.println(nbook);
		} catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
