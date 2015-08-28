package com.konyk.service;

import java.util.List;

import com.konyk.dto.BookDto;
import com.konyk.model.Autor;
import com.konyk.model.Book;

public interface AutorService {
	
	public void add (Autor autor);
	public void edit (Autor autor);
	public void delete (Integer id);
	public void deleteAll ();
	public Autor getAutorById (Integer id);
	public List<Autor> getAllAutors ();
}
