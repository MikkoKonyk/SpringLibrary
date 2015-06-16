package com.roman.dao;

import java.util.List;

import com.roman.model.Reader;

public interface ReaderDao {

	public void add (Reader reader);
	public void update (Reader reader);
	public void delete (Integer id);
	public void deleteAll ();
	public Reader getById (Integer id);
	public List<Reader> getAll ();
}
