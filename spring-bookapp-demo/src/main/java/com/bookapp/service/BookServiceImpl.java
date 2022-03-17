package com.bookapp.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.bookapp.dao.IBookDetails;
import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // indicates that this is a service layer
public class BookServiceImpl implements IBookService {

	IBookDetails bookDetails;
	@Autowired
	public void setBookDetails(IBookDetails bookDetails) {
		this.bookDetails = bookDetails;
	}

	@Override
	public List<Book> getAll() {
		return bookDetails.findAll();
	}

	@Override
	public List<Book> getByAuthor(String author) throws BookNotFoundException {
		return	bookDetails.findByAuthor(author)
						.stream()
						.sorted((o1,o2)->o1.getTitle().compareTo(o2.getTitle()))  // using lambda
						.collect(Collectors.toList());
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		return bookDetails.findByCategory(category)
						.stream()
						.sorted(Comparator.comparing(Book::getTitle))
						.collect(Collectors.toList());
	}

	@Override
	public Book getById(int bookId) throws IdNotFoundException {
		return bookDetails.findById(bookId);
	}

	@Override
	public List<Book> getByLesserPrice(double price) throws BookNotFoundException {
		List<Book> booksByPrice =  bookDetails.findByLesserPrice(price);
		if(booksByPrice!=null)
			Collections.sort(booksByPrice,(b1,b2)->b1.getTitle().compareTo(b2.getTitle()));
		return booksByPrice;
	}


}
