package com.konyk.dao;

import java.util.List;

import com.konyk.model.Autor;


public interface AutorDao {
	public void add (Autor autor);
	public void update (Autor autor);
	public void delete (Integer id);
	public void deleteAll ();
	public Autor getById (Integer id);
	public List<Autor> getAll ();
}
