package com.bookapp.service;

import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;

public interface IBookService {
	List<Book> getAll();
	List<Book> getByAuthor(String author) throws BookNotFoundException;
	List<Book> getByCategory(String category)throws BookNotFoundException;
	Book getById(int bookId)throws IdNotFoundException;
	List<Book> getByLesserPrice(double price)throws BookNotFoundException;
}
