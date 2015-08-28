package com.konyk.service;

import java.util.List;

import com.konyk.model.Book;
import com.konyk.model.Reader;

public interface ReaderService {
	public void add(Reader reader);
	public void edit(Reader reader);
	public void delete(Integer readerId);
	public void deleteAll();
	public Reader getReaderById(Integer readerId);
	public List<Reader> getAllReaders();
}
