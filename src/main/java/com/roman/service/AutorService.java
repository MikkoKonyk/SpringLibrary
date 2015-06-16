package com.roman.service;

import java.util.List;

import com.roman.dto.BookDto;
import com.roman.model.Autor;
import com.roman.model.Book;

public interface AutorService {
	
	public void add (Autor autor);
	public void edit (Autor autor);
	public void delete (Integer id);
	public void deleteAll ();
	public Autor getAutorById (Integer id);
	public List<Autor> getAllAutors ();
}
