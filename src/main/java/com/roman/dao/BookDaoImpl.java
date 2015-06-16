package com.roman.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roman.model.Book;
import com.roman.model.Storage;

@Repository
public class BookDaoImpl implements BookDao {
	
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Book book) {
		
		int numberOfCopies = book.getNumberOfCopies();
			for (int counter =0; counter<numberOfCopies; counter++ ){
				Storage storage = new Storage();
				storage.setBook(book);
				storage.setAvailable("YES");
				session.getCurrentSession().save(storage);
				book.getCopies().add(storage);
			}
			session.getCurrentSession().save(book);	
	}

	@Override
	public void update(Book book) {
		session.getCurrentSession().update(book);
	}

	@Override
	public void delete(Integer id) {
		session.getCurrentSession().delete(getById(id));
		
	}

	@Override
	public Book getById(Integer id) {
		return (Book)session.getCurrentSession().get(Book.class, id);
	}
	
	@Override
	public void deleteAll() {
		
		List<Book> bookList = (List<Book>) getAll();
		for (Book book : bookList) {
			session.getCurrentSession().delete(getById(book.getBookId()));
		}
	}
	@Override
	public List<Book> getAll() {
		return session.getCurrentSession().createQuery("from Book").list();
	}
}
