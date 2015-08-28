package com.konyk.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.konyk.model.Storage;
@Repository
public class StorageDaoImpl implements StorageDao{
	
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Storage storage) {
		session.getCurrentSession().save(storage);
	}

	@Override
	public void update(Storage storage) {
		session.getCurrentSession().update(storage);
	}

	@Override
	public void delete(Integer id) {
		session.getCurrentSession().delete(getById(id));
	}

	@Override
	public Storage getById(Integer id) {
		return (Storage)session.getCurrentSession().get(Storage.class, id);
	}
	
	@Override
	public void deleteAll() {
		List<Storage> storageList = (List<Storage>) getAll();
		for (Storage storage : storageList) {
			session.getCurrentSession().delete(getById(storage.getCopyId()));
		}
	}
	
	@Override
	public List<Storage> getAll() {
		return session.getCurrentSession().createQuery("from Storage").list();
	}
}
