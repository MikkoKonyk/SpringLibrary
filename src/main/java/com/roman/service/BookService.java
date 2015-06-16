package com.roman.service;

import java.util.List;

import com.roman.dto.BookDto;
import com.roman.model.Book;

public interface BookService {
	public void add(Book book);
	public void edit(Book book);
	public void delete(Integer bookId);
	public void deleteAll();
	public Book getBookById(Integer bookId);
	public List<Book> getAllBooks();
}

