package com.roman.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roman.model.Reader;

@Repository
public class ReaderDaoImpl implements ReaderDao {
	
	
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Reader reader) {
		session.getCurrentSession().save(reader);
	}

	@Override
	public void update(Reader reader) {
		session.getCurrentSession().update(reader);
	}

	@Override
	public void delete(Integer id) {
		session.getCurrentSession().delete(getById(id));
	}

	@Override
	public Reader getById(Integer id) {
		return (Reader)session.getCurrentSession().get(Reader.class, id);
	}
	@Override
	public void deleteAll() {
		
		List<Reader> readerList = (List<Reader>) getAll();
		for (Reader reader : readerList) {
			session.getCurrentSession().delete(getById(reader.getReaderId()));
		}
	}
	
	@Override
	public List<Reader> getAll() {
		return session.getCurrentSession().createQuery("from Reader").list();
	}
}
