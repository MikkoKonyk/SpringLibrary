package com.roman.dao;

import java.util.List;

import com.roman.model.Book;


public interface BookDao {

	public void add (Book book);
	public void update (Book book);
	public void delete (Integer id);
	public void deleteAll ();
	public Book getById (Integer id);
	public List<Book> getAll ();
}