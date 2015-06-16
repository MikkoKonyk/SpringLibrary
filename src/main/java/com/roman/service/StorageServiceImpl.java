package com.roman.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roman.dao.ReaderDao;
import com.roman.dao.StorageDao;
import com.roman.model.Storage;

@Service
public class StorageServiceImpl implements StorageService{

	@Autowired
	StorageDao storageDao;
	
	@Autowired
	ReaderDao readerDao;
	
	@Transactional
	public void add(Storage storage) {
		storageDao.add(storage);
		
	}

	@Transactional
	public void edit(Storage storage) {
		storageDao.update(storage);
	}

	@Transactional
	public void delete(Integer storageId) {
		storageDao.delete(storageId);
	}

	@Transactional
	public void deleteAll() {
		storageDao.deleteAll();
	}

	@Transactional
	public Storage getStorageById(Integer storageId) {
		return storageDao.getById(storageId);
	}

	@Transactional
	public List<Storage> getAllStorages() {
		return storageDao.getAll();
	}

}
