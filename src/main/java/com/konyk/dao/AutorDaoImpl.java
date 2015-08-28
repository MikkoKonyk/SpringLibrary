package com.konyk.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.konyk.model.Autor;

	@Repository
	public class AutorDaoImpl  implements AutorDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Autor autor) {
		session.getCurrentSession().save(autor);
		
	}

	@Override
	public void update(Autor autor) {
		session.getCurrentSession().update(autor);
		
	}

	@Override
	public void delete(Integer id) {
		session.getCurrentSession().delete(getById(id));
		
	}

	@Override
	public void deleteAll() {
		 List<Autor> autorList = (List<Autor>) getAll();
			for (Autor autor : autorList) {
				session.getCurrentSession().delete(getById(autor.getAutorId()));
						}
		
	}

	@Override
	public Autor getById(Integer id) {
		return (Autor) session.getCurrentSession().get(Autor.class, id);
	}

	@Override
	public List<Autor> getAll() {
		return session.getCurrentSession().createQuery("from Autor").list();
	}

}
