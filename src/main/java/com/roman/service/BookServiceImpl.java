package com.roman.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roman.dao.BookDao;
import com.roman.model.Book;
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Transactional
	public void add(Book book) {
		bookDao.add(book);
	}

	@Transactional
	public void edit(Book book) {
		bookDao.update(book);
		
	}

	@Transactional
	public void delete(Integer bookId) {
		bookDao.delete(bookId);
		
	}

	@Transactional
	public void deleteAll() {
		bookDao.deleteAll();
		
	}

	@Transactional
	public Book getBookById(Integer bookId) {
		return bookDao.getById(bookId);
	}

	@Transactional
	public List<Book> getAllBooks() {
		return bookDao.getAll();
	}

}
