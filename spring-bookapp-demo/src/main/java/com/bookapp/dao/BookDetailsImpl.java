package com.bookapp.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookDetailsImpl implements IBookDetails {

	@Override
	public List<Book> findAll() {

		return showBooks();
	}

	@Override
	public List<Book> findByAuthor(String author) throws BookNotFoundException {
		List<Book> booksByAuthor =
						showBooks()
						.stream()
						.filter(book -> book.getAuthor().equals(author)) // to filter the author
						.collect(Collectors.toList()); // is to return the stream back to list
		if (booksByAuthor.isEmpty())
			throw new BookNotFoundException("Books with this author not found");
		return booksByAuthor;
	}

	@Override
	public List<Book> findByCategory(String category) throws BookNotFoundException {
		List<Book> booksByCategory = showBooks()
						.stream()
						.filter(book->book.getCategory().equals(category))
						.collect(Collectors.toList());
		if (booksByCategory.isEmpty())
			throw new BookNotFoundException("Books with this category not found");
		return booksByCategory;
	}

	@Override
	public Book findById(int bookId) throws IdNotFoundException {
//		Optional<Book> bookOpt= showBooks()
//					.stream()
//					.filter(book->book.getBookId() == bookId)
//				    .findFirst();
//
//		if (bookOpt.isEmpty())
//			throw new IdNotFoundException("Book with this id not found");
//		return bookOpt.get();
		return showBooks()
				.stream()
				.filter(book->book.getBookId() == bookId)
				.findFirst()
				.orElseThrow(()->new IdNotFoundException("Book with this id not found"));
	}

	@Override
	public List<Book> findByLesserPrice(double price) throws BookNotFoundException {
		List<Book> booksByPrice =
						showBooks()
						.stream()
						.filter(book->book.getPrice() < price)
						.collect(Collectors.toList());
		if (booksByPrice.isEmpty())
			throw new BookNotFoundException("Books lesser than this price not found");
		return booksByPrice;
	}

	private List<Book> showBooks() {
		return Arrays.asList(
				new Book("Java in Action", 1, "Kathy", 900, "Tech"),
				new Book("Spring in Action", 2, "Rod", 900, "Tech"),
				new Book("Atomic Habits", 3, "Steve", 900, "SelfHelp"),
				new Book("Secret", 4, "Steve", 900, "SelfHelp"),
				new Book("Seven Habits", 5, "Steve", 900, "SelfHelp"));
	}

}
