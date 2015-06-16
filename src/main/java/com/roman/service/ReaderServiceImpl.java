package com.roman.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roman.dao.ReaderDao;
import com.roman.dao.StorageDao;
import com.roman.model.Reader;

@Service
public class ReaderServiceImpl implements ReaderService {

	@Autowired
	private StorageDao storageDao;
	
	@Autowired
	private ReaderDao readerDao;
	
	@Transactional
	public void add(Reader reader) {
		readerDao.add(reader);
		
	}

	@Transactional
	public void edit(Reader reader) {
		readerDao.update(reader);
	}

	@Transactional
	public void delete(Integer readerId) {
		readerDao.delete(readerId);
	}

	@Transactional
	public void deleteAll() {
		readerDao.deleteAll();
	}

	@Transactional
	public Reader getReaderById(Integer readerId) {
		
		return readerDao.getById(readerId);
	}

	@Transactional
	public List<Reader> getAllReaders() {
		
		return readerDao.getAll();
	}

}
