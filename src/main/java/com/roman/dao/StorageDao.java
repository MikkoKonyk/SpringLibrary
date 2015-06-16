package com.roman.dao;

import java.util.List;

import com.roman.model.Storage;

public interface StorageDao {
	public void add (Storage storage);
	public void update (Storage storage);
	public void delete (Integer id);
	public void deleteAll ();
	public Storage getById (Integer id);
	public List<Storage> getAll ();
}
