package com.konyk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.konyk.dao.AutorDao;
import com.konyk.model.Autor;
@Service
public class AutorServiceImpl implements AutorService {

	@Autowired
	private AutorDao autorDao;
	
	@Transactional
	public void add(Autor autor) {
		autorDao.add(autor);
	}

	@Transactional
	public void edit(Autor autor) {
		autorDao.update(autor);
		
	}

	@Transactional
	public void delete(Integer id) {
		autorDao.delete(id);
		
	}

	@Transactional
	public void deleteAll() {
		autorDao.deleteAll();
		
	}

	@Transactional
	public Autor getAutorById(Integer id) {
		
		return autorDao.getById(id);
	}

	@Transactional
	public List<Autor> getAllAutors() {
		
		return autorDao.getAll();
	}

}
