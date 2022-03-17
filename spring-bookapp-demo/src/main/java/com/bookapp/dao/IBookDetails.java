package com.bookapp.dao;

import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;

public interface IBookDetails {

	List<Book> findAll();

	List<Book> findByAuthor(String author) throws BookNotFoundException;

	List<Book> findByCategory(String category) throws BookNotFoundException;

	Book findById(int bookId) throws IdNotFoundException;

	List<Book> findByLesserPrice(double price) throws BookNotFoundException;
}
